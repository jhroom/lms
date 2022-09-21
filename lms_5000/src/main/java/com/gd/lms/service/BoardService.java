package com.gd.lms.service;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
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
import com.gd.lms.controller.BoardController;
import com.gd.lms.mapper.BoardMapper;
import com.gd.lms.vo.Board;
import com.gd.lms.vo.BoardFile;
import com.gd.lms.vo.BoardPost;
import com.gd.lms.vo.Comment;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class BoardService implements IBoardService{
	@Autowired BoardMapper boardMapper;

	
	//게시판 리스트 생성 서비스
	@Override
	public List<Board> getBoardList(int lectureNo) {
		//리턴 값(list) 세팅
		List<Board> list = boardMapper.selectBoradList(lectureNo);
		
		//디버깅
		System.out.println("[boardSvc] Borad list : " + list);		
		return list;
	}


	//게시판 추가 쿼리
	@Override
	public int addBoard(Board board) {
		//리턴 값(int) 세팅
		int row = boardMapper.insertBoard(board);
		
		//디버깅
		System.out.println("[boardSvc] add Board row : " + row);
		
		//리턴
		return row;
	}

	//선택 게시판의 게시글 리스트 생성 서비스
	@Override
	public List<BoardPost> getBoardPostList(int boardNo) {
		//리턴 값(list) 세팅
		List<BoardPost> list = boardMapper.selectBoardPostList(boardNo);
		
		//디버깅
		System.out.println("[boardSvc] BoardPost list : " + list);
		
		//리턴
		return list;
	}
	
	
	
	//게시글의 상세 조회 서비스
	@Override
	public Map<String, Object> getBoardPostOne(int boardPostNo) {
		//리턴 값(list) 세팅
		Map<String, Object> boardPost = boardMapper.selectBoardPostOne(boardPostNo);
		
		//디버깅
		System.out.println("[boardSvc] boardPost : " + boardPost);
		
		//리턴
		return boardPost;
	}
	
	

	//게시글 추가 서비스
	@Override
	public int addBoardPostandFile(BoardPost boardPost, MultipartFile[] uploadFile, HttpServletRequest request) {
		
		//파라미터 확인 디버깅
		log.debug(TeamColor.KHJ + "파라미터 확인 / boardPost : " + boardPost);
		log.debug(TeamColor.KHJ + "파라미터 확인 / boardFile : " + uploadFile);
		
		
		//리턴 값(int) 세팅
		int row = boardMapper.insertBoardPost(boardPost);
		
		//파일 추가
		if(row == 1 && uploadFile !=null) {
			//////파일 첨부 코드
			// 변수 확인
			//상대 주소
			String realPath = request.getSession().getServletContext().getRealPath("/uploadFile/boardFile");
			String originFileName = "";
			String contentType = "";

			//리스트 생성
			List<BoardFile> list = new ArrayList<>();
			

			for(MultipartFile file : uploadFile) {
				if(!file.isEmpty()) {
					//변수 세팅
					originFileName = file.getOriginalFilename();
					contentType = file.getContentType();	
					
					//파일 객체 생성
					BoardFile tempFile = new BoardFile();
					
					//디버깅
					log.debug(TeamColor.KHJ + "값 확인 / 파일 vo 세팅 전 값 : " + tempFile);
					
					//값 세팅하기
					tempFile.setFileOriginname(originFileName);
					tempFile.setFileName(UUID.randomUUID() + "_" + originFileName);
					tempFile.setFileType(contentType);
					tempFile.setBoardPostNo(boardPost.getBoardPostNo());
					
					//디버깅
					log.debug(TeamColor.KHJ + "값 확인 / 파일 vo 세팅 후 값 : " + tempFile);
				
	
					//리스트에 추가하기
					list.add(tempFile);
			
	
					//저장 파일 이름 생성(연구 중)
					String saveFileName = realPath + File.separator + tempFile.getFileName();
					
					//저장 파일 경로 생성 (확인 중)
					Path savePath = Paths.get(saveFileName);
					
					
					try {
						//전송하기
						file.transferTo(savePath);
						
						//첨부파일 추가하기
						row =+ boardMapper.insertBoardFile(tempFile);
						
						//결과 확인 디버깅
						log.debug(TeamColor.KHJ + "결과 확인 / 게시글 첨부파일 추가 행 수 : " + row);
						
					} catch (Exception e) {
						//실패 디버깅
						log.debug(TeamColor.KHJ + "파일 추가 실패");
						e.printStackTrace();
					}
				}
			}
		}
		
		//디버깅
		System.out.println("[boardSvc] add boardFile row : " + row);
		
		return row;
	}


	@Override
	public ResponseEntity<Object> downloadFile(String fileName, String realPath) {
		//리턴타입 세팅
		ResponseEntity<Object> returnVal = null;

		try {
			
			//path의 경로 객체 생성
			Path filePath = Paths.get(realPath);
			
			// 파일 resource 얻기
			Resource resource = new InputStreamResource(Files.newInputStream(filePath)); 
			
			//파일 객체 생성
			File file = new File(realPath);
			
			//헤더 객체 생성
			HttpHeaders headers = new HttpHeaders();
			
			// 다운로드 되거나 로컬에 저장되는 용도로 쓰이는지를 알려주는 헤더			
			headers.setContentDisposition(ContentDisposition.builder("attachment").filename(file.getName()).build());  
			
			//결과 확인 디버깅
			log.debug(TeamColor.KHJ + "결과 확인 / 파일 다운로드 성공");
			
			//리턴
			return new ResponseEntity<Object>(resource, headers, HttpStatus.OK);
		} catch(Exception e) {
			//결과확인 디버깅
			log.debug(TeamColor.KHJ + "결과 확인 / 파일 다운로드 실패");
			
			//리턴
			return new ResponseEntity<Object>(null, HttpStatus.CONFLICT);
		}
		
		
	}


	

	@Override
	public int addComment(Comment comment) {
		//파라미터 확인 디버깅
		log.debug(TeamColor.KHJ + "파라미터 확인 / comment : " + comment);
		
		//실행
		int row = boardMapper.insertComment(comment);
		
		//디버깅
		log.debug(TeamColor.KHJ + "결과 확인 / 추가된 commet 행수 : " + row);
		
		//리턴
		return row;
	}


	@Override
	public List<Comment> getComment(int boardPostNo) {
		//파라미터 확인 디버깅
		log.debug(TeamColor.KHJ + "파라미터 확인 / boardPostNo : " + boardPostNo);
		
		//실행
		List<Comment> list = boardMapper.selectComment(boardPostNo);
		
		//디버깅
		log.debug(TeamColor.KHJ + "결과 확인 / 댓글 list : " + list);
				
		//리턴
		return list;
	}


	@Override
	public int removeComment(int commentNo) {
		//파라미터 확인 디버깅
		log.debug(TeamColor.KHJ + "파라미터 확인 / commentNo : " + commentNo);
		
		//실행
		int row = boardMapper.deleteComment(commentNo);
		
		//디버깅
		log.debug(TeamColor.KHJ + "결과 확인 / 댓글 삭제 행수 : " + row);
				
		//리턴
		return row;
	}	


	@Override
	public int removeBoardPost(int boardPostNo, String fileName, HttpServletRequest request) {
		//파라미터 확인 디버깅
		log.debug(TeamColor.KHJ + "파라미터 확인 / boardPostNo : " + boardPostNo);
		
		//실행
		int row = boardMapper.deleteBoardPost(boardPostNo);
		
		
		
		//실제 파일 삭제
        String srcFileName = null;
        
        String uploadPath = request.getSession().getServletContext().getRealPath("/uploadFile/boardFile");
        try{
            srcFileName = URLDecoder.decode(fileName,"UTF-8");
            //UUID가 포함된 파일이름을 디코딩해줍니다.
            File file = new File(uploadPath +File.separator + srcFileName);
            boolean result = file.delete();

            File thumbnail = new File(file.getParent(),"s_"+file.getName());
            //getParent() - 현재 File 객체가 나태내는 파일의 디렉토리의 부모 디렉토리의 이름 을 String으로 리턴해준다.
            result = thumbnail.delete();
            new ResponseEntity<>(result,HttpStatus.OK);
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
            new ResponseEntity<>(false,HttpStatus.INTERNAL_SERVER_ERROR);
        }
		
		
		
		
		
		//디버깅
		log.debug(TeamColor.KHJ + "결과 확인 / 댓글 삭제 행수 : " + row);
		
		//리턴
		return row;
	}





}
