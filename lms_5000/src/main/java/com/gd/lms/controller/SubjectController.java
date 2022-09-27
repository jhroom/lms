package com.gd.lms.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.service.ISubjectService;
import com.gd.lms.vo.Subject;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class SubjectController {
	@Autowired ISubjectService subjectService;
	
	
	// 강좌 리스트
	@GetMapping("/lmsSubject/SubjectList")
	public String getSubjectList(Model model) {
		
		//리스트 불러오기
		List<Subject> SubjectList = subjectService.getSubjectList();
		
		//구현
		model.addAttribute("SubjectList", SubjectList);
		
		log.debug(TeamColor.SSH + "강좌리스트 : " + SubjectList);
		
		return "/subject/SubjectList";
	}
	
	// 강좌 보기
	@GetMapping("/lmsSubject/subjectOne")
	public String getselectSubjectOne(int subjectNo, String subjectName, Model model) {
		
		Map<String, Object> subjectOne = subjectService.getSubjectOne(subjectNo);
		
		model.addAttribute("subjectOne", subjectOne);
		
		model.addAttribute("subjectNo", subjectNo);
		model.addAttribute("subjectName", subjectName);
		
		log.debug(TeamColor.SSH + "결과확인 : " + subjectOne);
		log.debug(TeamColor.SSH + "결과확인 / 포워딩");
		
		
		return "subject/SubjectOne";
		
		
	}
	
	// 강좌 추가
	@GetMapping("/lmsSubject/addSubject")
	public String addSubject() {
		
		
		return "/subject/addSubject";
	}
	
	// 강좌 추가 액션
	@GetMapping("/lmsSubject/addSubject/add")
	public String addSubject(Subject subject) {
		subjectService.addSubject(subject);
		
		log.debug(TeamColor.SSH + "강좌 추가 : " + subject);
		
		return "redirect:/subject/SubjectList";
	}
	
}
