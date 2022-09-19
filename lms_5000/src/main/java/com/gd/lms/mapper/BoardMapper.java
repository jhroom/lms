package com.gd.lms.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gd.lms.vo.Board;
import com.gd.lms.vo.BoardFile;
import com.gd.lms.vo.BoardPost;

@Mapper
public interface BoardMapper {
	//게시판 리스트 생성 쿼리
	public List<Board> selectBoradList(int lectureNo);
	
	//선택 게시판의 게시글 리스트 생성 쿼리
	public List<BoardPost> selectBoardPostList(int boardNo);
	
	//게시판 추가 쿼리
	public int insertBoard(Board board);
	
	//게시글 상세 조회 쿼리
	public Map<String, Object> selectBoardPostOne(int boardPostNo);
	
	//게시글 추가 쿼리
	public int insertBoardPost(BoardPost boardPost);
	
	//게시글 첨부 파일 추가 쿼리
	public int insertBoardFile(BoardFile boardFile);
	
	//댓글 리스트 생성 쿼리
	
	

}
