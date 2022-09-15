package com.gd.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gd.lms.mapper.BoardMapper;
import com.gd.lms.vo.Board;

@Service
@Transactional
public class BoardService implements IBoardService{
	@Autowired BoardMapper boardMapper;

	@Override
	public List<Board> getBoardList(int lectureNo) {
		List<Board> list = boardMapper.selectBoradList(lectureNo);
		
		//디버깅
		System.out.println("[boardSvc] list : " + list);		
		return list;
	}

}
