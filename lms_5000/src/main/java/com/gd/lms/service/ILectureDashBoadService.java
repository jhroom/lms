package com.gd.lms.service;

import java.util.List;
import java.util.Map;

import com.gd.lms.vo.Board;

public interface ILectureDashBoadService {
	////////////////////////// 기타 게시판 /////////////////////////////
	// 기타 게시판 생성
	int addSubBoard(Board board);
	////////////////////////// 과제관련 게시판 /////////////////////////////
	// 과제 제출 게시판 생성
	int addAssignmentBoard(Board board);
	// 과제 제출 게시판
	List<Map<String, Object>> getAssignment(Board lectureNo);
	//출결현황 출력
	List<Map<String,Object>> stuAttendance(int lectureNo, String userId);
}
