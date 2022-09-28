package com.gd.lms.mapper;

import java.util.List;


import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gd.lms.vo.AttendanceForm;
import com.gd.lms.vo.Board;
import com.gd.lms.vo.BoardPost;
import com.gd.lms.vo.Lecture;

@Mapper
public interface LectureDashBoardMapper {
	
	//////////////////일반 개신판///////////////////////////
	// 강좌 개시판 생성
	int insertSubBoard(Board board);
	
	
	//////////////////과제 제출 관련/////////////////////////
	// 과제 제출 게시판 생성
	int insertBoard(Board board);
	// 과제 제출 게시판 리스트
	List<Map<String, Object>> assignmentBoardList(Board lectureNo);
	// 과제 제출 상세 게시판
	int insertBoardPost(BoardPost boardPost);
	
	//학생 출석현황 리스트
	List<Map<String,Object>> sutAttendance(int lectureNo,  String userId);
	
	//교수의 강의대시보드 출결리스트
	List<Map<String,Object>> weekList(int lectureNo);
	
	//교수의 해당강좌 학생리스트
	List<Map<String,Object>> selectStudentListForAtt(Map<String,Object> map);
	
	//해당(강좌,주차) 학생의 출석정보유무 조회
	Integer selectStudentAttData(int week, String studentId2, int lectureNo);
	
	//출석하는데 정보가 없을시
	int insertStudentAttendance(AttendanceForm attForm);
	
	//출석하는데 이미 정보가 잇다면
	int updateStudentAttendance(AttendanceForm attForm);
	
	//출석페이지의 강좌 정보
	Map<String, Object> selectLectureInfo(Lecture lecture);
	
}
