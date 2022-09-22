package com.gd.lms.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.gd.lms.vo.LmsNotice;

public interface ILmsNoticeService {

	// 리스트
	public List<LmsNotice> getLmsNoticeList();
	
	// 공지 추가 (파일도 필요)
	public int LmsAddNotice(LmsNotice lmsNotice, MultipartFile[] lmsFile, HttpServletRequest request);
	// 공지 삭제
	public int deleteLmsNotice(int lmsNoticeNo);
	// 공지 수정
	public int updateLmsNotice(LmsNotice lmsNotice);
	// 공지 상세보기
	public Map<String, Object> getLmsNoticeOne(int lmsNoticeNo);
	// 공지 파일 다운로드
	public ResponseEntity<Object> douwnloadFile(String fileName, String realPatth);
	
	
	
}
