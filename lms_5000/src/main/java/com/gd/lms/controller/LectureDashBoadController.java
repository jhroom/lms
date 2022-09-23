package com.gd.lms.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.service.ILectureDashBoadService;
import com.gd.lms.vo.Board;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LectureDashBoadController {
	@Autowired ILectureDashBoadService lectureDashBoardService;
	
	
	//////////////////////////////////////  AssignmentBoard crud  start////////////////////////////////
	
	// 과제제출 게시판 생성
	@GetMapping("/dashBoard/insertBoard")
	public String insertBoard(Board board) {
		int addAssignmentBoard = lectureDashBoardService.addAssignmentBoard(board);
		// 게시판 생성 확인
		log.debug(TeamColor.YHW + "-- addAssignmentBoard-controller--"+ addAssignmentBoard );
		return "redirect:/dashBoard/lectureDashBoard";
	}

	
	// 과제제출 게시판 리스트
	@GetMapping("/dashBoard/lectureDashBoard")
	public String AssignmentBoard (Board board, Model model, Board lectureNo) {
		List<Map<String, Object>> assignMentBoard = lectureDashBoardService.getAssignment(lectureNo);
		// 게시판 확인
		log.debug(TeamColor.YHW + "-- assignMentBoard-controller--"+ assignMentBoard );
		// model에 값 담기
		model.addAttribute("assignMentBoard", assignMentBoard);
	return "/dashBoard/lectureDashBoard";
	}
	//////////////////////////////////////   AssignmentBoard crud end///////////////////////////////////
}
