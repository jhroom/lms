package com.gd.lms.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.service.ILectureDashBoadService;
import com.gd.lms.vo.Attendance;
import com.gd.lms.vo.Board;
import com.gd.lms.vo.Lecture;
import com.gd.lms.vo.Sign;
import com.gd.lms.vo.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LectureDashBoadController {
	@Autowired ILectureDashBoadService lectureDashBoardService;
	//////////////////////////////////////기타 게시판////////////////////////////////
	// 기타 게시판 추가
	@GetMapping("/dashBoard/addSubBoardForm")
	public String addSubBoardForm(Board board, HttpSession session) {
		int addSubBoardForm = lectureDashBoardService.addSubBoard(board);
		session.getAttribute("lectureNo");
		// 게시판 생성 확인
		log.debug(TeamColor.YHW + "-- addSubBoardForm-controller--"+ addSubBoardForm );
		return "/dashBoard/addSubBoardForm";
	}
	
	
	
	//////////////////////////////////////과제 제출 관련 게시판////////////////////////////////
	//게시판 추가 메서드
	@GetMapping("/board/addform")
	public String directAddBoard(Board board ,int lectureNo, Model model) {
		//파라미터 확인 디버깅
		log.debug(TeamColor.KHJ + "파라미터 확인 / lectureNo : " + lectureNo);

		//값 넘겨주기
		model.addAttribute("lectureNso", lectureNo);
		//포워딩
		return "/dashBoard/addAssignmentBoard";
	}
	
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
	public String AssignmentBoard (Board board, Model model, Board lectureNo, HttpSession session , Sign sign) {
		List<Map<String, Object>> assignMentBoard = lectureDashBoardService.getAssignment(lectureNo);
		// 게시판 확인
		log.debug(TeamColor.YHW + "-- assignMentBoard-controller--"+ assignMentBoard );
		// model에 값 담기
		model.addAttribute("assignMentBoard", assignMentBoard);
		
		//session값에 userId를 담고 강좌번호 + 유저id를 가지고 해당 강좌를 듣는 유저의 출결현황을 출력해준다.
		log.debug(TeamColor.JCH + "출석현황 리스트 ");
		String userId = ((User)session.getAttribute("loginUser")).getUserId();
		sign.setUserId(userId);
		List<Map<String,Object>> stuAtt = lectureDashBoardService.stuAttendance(board.getLectureNo() , userId);
		model.addAttribute("stuAtt" , stuAtt);
		
		int lectureNoForWeek = lectureNo.getLectureNo();
		List<Map<String,Object>> weekList = lectureDashBoardService.weekList(lectureNoForWeek);
		log.debug(TeamColor.AJH + "해당강좌의 weekList :  " + weekList);
		model.addAttribute("weekList",weekList);
		model.addAttribute("lectureNo",lectureNo.getLectureNo());

	return "/dashBoard/lectureDashBoard";
	}
	//////////////////////////////////////   AssignmentBoard crud end///////////////////////////////////
	//해당 주차를 눌렀을 떄 해당 강좌의 수강생 리스트 보여주기
	/*
	 * @GetMapping("/dashBoard/lectureAttendance") public String
	 * attendance(HttpSession session, Lecture lecture, Model model) {
	 * lecture.setUserId(((User)session.getAttribute("loginUser")).getUserId());
	 * //get 방식의 lecture No 와 세션의 아이디로 해당강좌 수강생 리스트 받아오기 List<Map<String, Object>>
	 * list = lectureDashBoardService.getStudentListForAtt(lecture);
	 * log.debug(TeamColor.AJH +"교수 id의 해당 강의 수강생 리스트 : " + list);
	 * model.addAttribute("studentList",list); return "dashBoard/addAttendance"; }
	 */
	
	@PostMapping("/dashBoard/lectureAttendance")
	public String attendanceList(HttpSession session, Lecture lecture, Model model,@RequestParam (value="lectureNo",required =false) int lectureNo,@RequestParam (value="week",required =false) int week) {
		
		  System.out.println("lecture : " + lectureNo);
		  System.out.println("lecture : " + week);
		 
		lecture.setUserId(((User)session.getAttribute("loginUser")).getUserId());
		//get 방식의 lecture No 와 세션의 아이디로 해당강좌 수강생 리스트 받아오기
		List<Map<String, Object>> list = lectureDashBoardService.getStudentListForAtt(lecture);
		log.debug(TeamColor.AJH +"교수 id의 해당 강의 수강생 리스트 : " + list);
		model.addAttribute("studentList",list);
		model.addAttribute("week",week);
		model.addAttribute("lectureNo",lecture.getLectureNo());
		
		System.out.println("자스 포스트 테스트");
		return "dashBoard/addAttendance";
	}
	
	@PostMapping("dashBoard/addAttendance")
	public String attendance(Sign sign, Attendance att) {
		System.out.println("att 파라미터 값 확인 : " + att);
		System.out.println("sign 파라미터 값 확인 : " + sign);
		return "index";
	}
}
