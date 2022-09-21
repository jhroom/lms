package com.gd.lms.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.service.ITestService;

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
}
