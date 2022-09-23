package com.gd.lms.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.mapper.LectureDashBoardMapper;
import com.gd.lms.vo.Board;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class LectureDashBoardService implements ILectureDashBoadService {
	@Autowired LectureDashBoardMapper lectureDashBoardMapper;
	
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


}
