package com.gd.lms.service;

import java.util.List;


import java.util.Map;

import com.gd.lms.vo.AttendanceForm;
import com.gd.lms.vo.Board;
import com.gd.lms.vo.Lecture;

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
	//강의의 출결주차 리스트
	List<Map<String,Object>> weekList(int lectureNo);
	
	//교수의 해당강좌 수강생리스트
	List<Map<String, Object>> getStudentListForAtt(Lecture lecture, int week);
	
	//출석 데이터 입력
	boolean addStudentAttendance(AttendanceForm attForm);
	
	//강좌 출석페이지의 강좌정보
	Map<String, Object> getLectureInfo(Lecture lecture);
	
	//최신 게시글 10건 불러오기
	List<Map<String,Object>> getRecentBoard(int lectureNo);
	
	//강좌별 대시보드 진입시 사용여부 검사
	boolean getDashBoardCheck(String userId, int lectureNo, int userLevel);
}
