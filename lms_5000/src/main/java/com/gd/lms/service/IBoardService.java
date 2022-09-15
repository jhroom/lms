package com.gd.lms.service;

import java.util.List;

import com.gd.lms.vo.Board;

public interface IBoardService {
	public List<Board> getBoardList(int lectureNo);


}
