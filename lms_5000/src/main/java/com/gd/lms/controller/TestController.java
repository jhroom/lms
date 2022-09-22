package com.gd.lms.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.service.ITestService;
import com.gd.lms.vo.MultiChoice;
import com.gd.lms.vo.Question;
import com.gd.lms.vo.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class TestController {
	@Autowired ITestService testService;
	
	@GetMapping("/test/testLecture")
	// 시험볼 과목 리스트
	public String TestLectureList(Model model) {
		List<Map<String, Object>> testLectureList = testService.testLecture();
		//디버깅
		log.debug(TeamColor.YHW + "-- TestLectureList -controller --    "+ testLectureList );
		// 과목 목록을 출력 위해 view에 값 전달
		model.addAttribute("testLectureList",testLectureList);
		return "test/testLecture";
	}
	
	//시험 게시판 폼 전송 메서드
	@GetMapping ("/test/board")
	public String testBoard(int lectureNo, Model model) {
		
		//파라미터 값 확인 디버깅
		log.debug(TeamColor.KHJ + "파라미터 값 확인 / lectureNo : "+ lectureNo );
		
		
		//넘겨줄 값 세팅
		List<Map<String, Object>>  list = testService.getTestList(lectureNo);
		
		
		//값 넘겨주기
		model.addAttribute("testList",list);
		
		
		//리턴
		return "test/testBoard";
	}
	
	
	@GetMapping ("/test/page")
	public String testPage(int testNo, Model model) {
		
		//파라미터 값 확인 디버깅
		log.debug(TeamColor.KHJ + "파라미터 값 확인 / testNo : "+ testNo );
		
		
		//넘겨줄 값 세팅
		List<Question>  list = testService.getTestQuestionList(testNo);
		List<MultiChoice>  list2 = testService.getTestChoiceList();
		
		//값 넘겨주기
		model.addAttribute("questionList",list);
		model.addAttribute("choiceList",list2);
		
		
		return"test/testPage";
	}
	
	//시험 생성
	@GetMapping("test/addTest")
	public String directAddTestForm() {
		
		//바로 포워딩
		return "test/addTest";
	}
	
	
	//시험 추가 메서드
	@PostMapping("test/addTest")
	public String addTest(Test test, Question question, MultiChoice multichoice) {
		//파라미터 값 확인 디버깅
		log.debug(TeamColor.KHJ + "파라미터 값 확인 / test : "+ test );
		log.debug(TeamColor.KHJ + "파라미터 값 확인 / question : "+ question );
		log.debug(TeamColor.KHJ + "파라미터 값 확인 / multichoice : "+ multichoice );
		
		


		
				
		
		return "";
	}
	
	
}
