package com.gd.lms.service;

import java.util.List;
import java.util.Map;

import com.gd.lms.vo.Board;

public interface ILectureDashBoadService {
	
	// 과제 제출 게시판 생성
	int addAssignmentBoard(Board board);
	// 과제 제출 게시판
	List<Map<String, Object>> getAssignment(Board lectureNo);
}
