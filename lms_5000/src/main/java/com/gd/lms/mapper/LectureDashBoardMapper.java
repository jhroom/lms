package com.gd.lms.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gd.lms.vo.Board;
import com.gd.lms.vo.BoardPost;

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
}
