package com.gd.lms.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gd.lms.mapper.BoardMapper;
import com.gd.lms.vo.Board;
import com.gd.lms.vo.BoardFile;
import com.gd.lms.vo.BoardPost;

@Service
@Transactional
public class BoardService implements IBoardService{
	@Autowired BoardMapper boardMapper;

	@Override
	public List<Board> getBoardList(int lectureNo) {
		//리턴 값(list) 세팅
		List<Board> list = boardMapper.selectBoradList(lectureNo);
		
		//디버깅
		System.out.println("[boardSvc] Borad list : " + list);		
		return list;
	}



	@Override
	public int addBoard(Board board) {
		//리턴 값(int) 세팅
		int row = boardMapper.insertBoard(board);
		
		//디버깅
		System.out.println("[boardSvc] add Board row : " + row);
		
		//리턴
		return row;
	}


	@Override
	public List<BoardPost> getBoardPostList(int boardNo) {
		//리턴 값(list) 세팅
		List<BoardPost> list = boardMapper.selectBoardPostList(boardNo);
		
		//디버깅
		System.out.println("[boardSvc] BoardPost list : " + list);
		
		//리턴
		return list;
	}
	
	
	

	@Override
	public Map<String, Object> getBoardPostOne(int boardPostNo) {
		//리턴 값(list) 세팅
		Map<String, Object> boardPost = boardMapper.selectBoardPostOne(boardPostNo);
		
		//디버깅
		System.out.println("[boardSvc] boardPost : " + boardPost);
		
		//리턴
		return boardPost;
	}

	@Override
	public int addBoardPost(BoardPost boardPost) {
		//리턴 값(int) 세팅
		int row = boardMapper.insertBoardPost(boardPost);
		
		//디버깅
		System.out.println("[boardSvc] add BoardPost row : " + row);
		
		//리턴
		return row;
	}



	@Override
	public int addBoardFile(BoardFile boardFile) {
		//리턴 값(int) 세팅
		int row = boardMapper.insertBoardFile(boardFile);
		
		//디버깅
		System.out.println("[boardSvc] add boardFile row : " + row);
		
		//리턴
		return row;
	}





}
