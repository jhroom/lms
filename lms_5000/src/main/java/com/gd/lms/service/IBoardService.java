package com.gd.lms.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.gd.lms.vo.Board;
import com.gd.lms.vo.BoardFile;
import com.gd.lms.vo.BoardPost;
import com.gd.lms.vo.Comment;

public interface IBoardService {
	//게시판 리스트 생성 서비스
	public List<Board> getBoardList(int startNo, int lectureNo);
	
	//게시판 추가 쿼리
	public int addBoard(Board board);
	
	//선택 게시판의 게시글 리스트 생성 서비스
	public List<BoardPost> getBoardPostList(int boardNo);
	
	//선택 게시판의 게시글 리스트 생성 서비스
	public List<BoardPost> getBoardPostList2(Board board);
	
	
	//게시글의 상세 조회 서비스
	public Map<String, Object> getBoardPostOne(int boardPostNo);
	
	//게시글 추가 서비스
	public int addBoardPostandFile(BoardPost boardPost, MultipartFile[] uploadFile,HttpServletRequest request);
		
	//게시글 파일 다운로드 서비스
	public ResponseEntity<Object> downloadFile(String fileName, String realPath);
	
	//댓글 추가 서비스
	public int addComment(Comment comment);
	
	//댓글 리스트 조회 서비스
	public List<Comment> getComment(int boardPostNo);
	
	//댓글 삭제 리스트
	public int removeComment(int commentNo);
	
	//게시글 삭제 리스트
	public int removeBoardPost(int boardPostNo, String fileName, HttpServletRequest request);
	
	//게시글 수정 서비스
	public int modifyBoardPost(BoardPost boardPost);
	
	//게시판 삭제 서비스
	public int removeBoard(int boardNo);
	
	//댓글 수정 서비스
	public int modifyComment(Comment comment);
	
	//강좌 번호로 강의 이름 알아내는 서비스
	public String getLectureName(int lectureNo);
	
	//페이징_게시판을 위한 마지막 게시판을 찾아내는 쿼리
	public int getRealEndPageForBoard(int lectureNo);
	
	
}
