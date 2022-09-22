package com.gd.lms.service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.mapper.LmsNoticeMapper;
import com.gd.lms.vo.LmsFile;
import com.gd.lms.vo.LmsNotice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class LmsNoticeService implements ILmsNoticeService {
	@Autowired LmsNoticeMapper lmsNoticeMapper;
	
	
	// 공지 리스트
	@Override
	public List<LmsNotice> getLmsNoticeList() {
		return lmsNoticeMapper.selectLmsNoticeList();
	}
	
	
	
	
	// 공지 등록
	@Override
	public int LmsAddNotice(LmsNotice lmsNotice, MultipartFile[] lmsFile, HttpServletRequest request) {
		int row = lmsNoticeMapper.LmsAddNotice(lmsNotice);
		
		//디버깅
		System.out.println("AddNotice : " + row);
		//파일 추가
		if(row==1 && lmsFile!=null) {
			String realPath = request.getSession().getServletContext().getRealPath("/lmsFile/file");
			String originFileName = "";
			String contentType = "";
			
			List<LmsFile> list = new ArrayList<>();
			
			for(MultipartFile file : lmsFile) {
				if(!file.isEmpty()) {
					originFileName=file.getOriginalFilename();
					contentType=file.getContentType();
					//파일 객체
					LmsFile noticeFile = new LmsFile();
					
					//값 세팅
					noticeFile.setFileOriginname(originFileName);
					noticeFile.setFileName(UUID.randomUUID() + "_" + originFileName);
					noticeFile.setFileType(contentType);
					noticeFile.setLmsNoticeNo(lmsNotice.getLmsNoticeNo());
					
					//디버깅
					log.debug(TeamColor.SSH + "세팅 후 값 : " + noticeFile);
					
					list.add(noticeFile);
					
					String saveFileName = realPath + File.separator + noticeFile.getFileName();
					
					Path savePath = Paths.get(saveFileName);
					
					try {
						//전송
						file.transferTo(savePath);
						//파일 추가
						row =+ lmsNoticeMapper.insertLmsNoticeFile(noticeFile);
						
						//디버깅
						log.debug(TeamColor.SSH + "첨부파일 결과확인" + row);
					} catch(Exception e) {
						log.debug(TeamColor.SSH + "파일추가실패");
						e.printStackTrace();
					}
				}
			}
		}
		
		
		return row;
		
		
	}

	
	//공지 삭제
	@Override
	public int deleteLmsNotice(int lmsNoticeNo) {
		
		return lmsNoticeMapper.deleteLmsNotice(lmsNoticeNo);
	}
	
	
	
	
	//공지 수정
	@Override
	public int updateLmsNotice(LmsNotice lmsNotice) {
		
		int row = lmsNoticeMapper.updateLmsNotice(lmsNotice);
		

		

		
		return lmsNoticeMapper.updateLmsNotice(lmsNotice);
		
		
	}
	
	
	
	
	
	//공지 상세보기
	@Override
	public Map<String, Object> getLmsNoticeOne(int lmsNoticeNo) {
		
		Map<String, Object> noticeOne = lmsNoticeMapper.selectLmsNoticeOne(lmsNoticeNo);
		
		log.debug(TeamColor.SSH + "상세보기 값 넘기기" + noticeOne);
		
		return noticeOne;
	}



	// 첨부 파일 다운로드
	@Override
	public ResponseEntity<Object> douwnloadFile(String fileName, String realPath) {
		
		ResponseEntity<Object> returnVal = null;
		
		try {
			
			Path filePath = Paths.get(realPath);
			//파일 리소스
			Resource resource = new InputStreamResource(Files.newInputStream(filePath));
			//객체
			File file = new File(realPath);
			//헤더
			HttpHeaders headers = new HttpHeaders();
			//이건 이해가 필요
			headers.setContentDisposition(ContentDisposition.builder("attachment").filename(file.getName()).build());
			
			//디버깅
			log.debug(TeamColor.SSH + "파일 다운로드 성공");
			
			return new ResponseEntity<Object>(resource, headers, HttpStatus.OK);
		} catch(Exception e) {
			//디버깅
			log.debug(TeamColor.SSH + "파일 다운로드 실패");
			
			return new ResponseEntity<Object>(null, HttpStatus.CONFLICT);
		}
	
		
		
		
		
		
		
	}
	

}
