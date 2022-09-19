package com.gd.lms.service;

import java.util.List;
import java.util.Map;

import com.gd.lms.vo.Board;
import com.gd.lms.vo.BoardFile;
import com.gd.lms.vo.BoardPost;

public interface IBoardService {
	//게시판 리스트 생성 서비스
	public List<Board> getBoardList(int lectureNo);
	
	//게시판 추가 쿼리
	public int addBoard(Board board);
	
	
	
	//선택 게시판의 게시글 리스트 생성 서비스
	public List<BoardPost> getBoardPostList(int boardNo);


	
	//게시글의 상세 조회 서비스
	public Map<String, Object> getBoardPostOne(int boardPostNo);
	
	//선택 게시판의 게시글 추가 서비스
	public int addBoardPost(BoardPost boardPost);
	
	
	//선택 게시판의 게시글 추가 서비스
	public int addBoardFile(BoardFile boardFile);
		
	
}
