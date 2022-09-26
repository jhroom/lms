package com.gd.lms.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.mapper.LectureDashBoardMapper;
import com.gd.lms.mapper.UserListMapper;
import com.gd.lms.vo.Board;
import com.gd.lms.vo.Lecture;
import com.gd.lms.vo.Week;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class LectureDashBoardService implements ILectureDashBoadService {
	@Autowired LectureDashBoardMapper lectureDashBoardMapper;	
	//////////////////////////기타 게시판 /////////////////////////////
	// 기타 게시판 생성
	@Override
	public int addSubBoard(Board board) {
		int addSubBoard = lectureDashBoardMapper.insertSubBoard(board);
		// 과제 제출 게시판 작동 확인
		log.debug(TeamColor.YHW + "-- addSubBoard-service--"+ addSubBoard );
		return addSubBoard;
	}
	////////////////////////// 과제관련 게시판 /////////////////////////////
	// 과제 제출 게시판 생성
	@Override
	public int addAssignmentBoard(Board board) {
		int addAssignmentBoard=lectureDashBoardMapper.insertBoard(board);
		// 과제 제출 게시판 작동 확인
		log.debug(TeamColor.YHW + "-- addAssignmentBoard-service--"+ addAssignmentBoard );
		
		
		return addAssignmentBoard;
	}
	
	// 과제 제출 개시판
	@Override
	public List<Map<String, Object>> getAssignment(Board lectureNo) {
		List<Map<String, Object>> getAssignment = lectureDashBoardMapper.assignmentBoardList(lectureNo);
		// 과제 제출 게시판 확인
		log.debug(TeamColor.YHW + "-- getAssignment-service--"+ getAssignment );
		return getAssignment;
	}
	
	//학생페이지에서 볼 수 있는 개인 출석 현황.
	@Override
	public List<Map<String, Object>> stuAttendance(int lectureNo, String userId) {
		//디버깅
		log.debug(TeamColor.JCH + this.getClass() + "학생 출결 리스트 확인");

		List<Map<String,Object>> stuAtt = lectureDashBoardMapper.sutAttendance(lectureNo , userId);
		
		System.out.println(lectureNo + "수강 번호 확인");
		return stuAtt;
	}

	@Override
	public List<Map<String,Object>> weekList(int lectureNo) {
		return lectureDashBoardMapper.weekList(lectureNo);
	}
	
	@Override
	public List<Map<String, Object>> getStudentListForAtt(Lecture lecture) {
		return lectureDashBoardMapper.selectStudentListForAtt(lecture);
	}

}
