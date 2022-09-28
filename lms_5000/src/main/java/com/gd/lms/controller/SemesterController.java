package com.gd.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.service.ISemeterService;
import com.gd.lms.vo.Semester;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class SemesterController {
	@Autowired ISemeterService semesterService;
	
	
	// 학기 리스트
	@GetMapping("lmsSemester/SemesterList")
	public String getSemesterList(Model model) {
		
		// 리스트 가져오기
		List<Semester> SemesterList = semesterService.getSemesterList();
		// 구현하기
		model.addAttribute("SemesterList", SemesterList);
		
		log.debug(TeamColor.SSH + "리스트" + SemesterList);
		
		return "/semester/semesterList";
	}
		
	
	// 학기 추가 폼
	@GetMapping("/lmsSemester/addSemester")
	public String addSemester() {
		
		return "/semester/addSemester";
	}
	
	// 학기 추가 액션
	@PostMapping("/lmsSemester/addSemester/add")
	public String addSemester(Semester semester) {
		semesterService.addSemseter(semester);
		
		//디버깅
		log.debug(TeamColor.SSH+ "학기 추가 : " + semester);
		
		return "redirect:/semester/semesterList";
		
		
	}
}