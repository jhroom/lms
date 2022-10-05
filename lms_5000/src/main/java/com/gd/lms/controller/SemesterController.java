package com.gd.lms.controller;

import java.util.List;
import java.util.Map;

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
		
		return "redirect:/lmsSemester/SemesterList";
		
		
	}
	
	// 학기 상세보기
	@GetMapping("/lmsSemester/semesterOne")
	public String getselectSemesterOne(int semesterNo, int semesterDay, Model model) {
		
		// 상세보기 값 가지고오기
		Map<String, Object> semesterOne = semesterService.getSemesterOne(semesterNo);
		
		
		// 가지고온 값 구현
		model.addAttribute("semesterOne", semesterOne);
		model.addAttribute("semesterNo", semesterNo);
		model.addAttribute("semesterDay", semesterDay);
		
		
		
		
		
		
		
		
		//디버깅
		log.debug(TeamColor.SSH + "총 일수 : " + semesterDay);
		log.debug(TeamColor.SSH + "결과확인" + semesterOne);
		log.debug(TeamColor.SSH + "결과확인 / 포워딩");
		
		return "semester/SemesterOne";
		
	}
	
	// 학기 삭제
	@GetMapping("/lmsSemester/deleteSemester")
	public String deleteSemester(int semesterNo) {
		
		int row = semesterService.deleteSemester(semesterNo);
		
		log.debug(TeamColor.SSH + "삭제되는 값 : " + row);
		
		return "redirect:/lmsSemester/SemesterList";
	}
	
	
	// 학기 수정
	@GetMapping("/lmsSemester/updateSemester/form")
	public String updateSemester(int semesterNo, Model model) {
		
		//수정페이지에 보일 기본 값을 가지고온다
		//No에 해당하는 One 값을 가지고 옴
		Map<String, Object> semesterOne = semesterService.getSemesterOne(semesterNo);
		
		//가지고 온 값을 출력
		model.addAttribute("semesterOne", semesterOne);
		model.addAttribute("semesterNo", semesterNo);
		
		//디버깅
		log.debug(TeamColor.SSH + "수정값 넘겨주기 : " + semesterOne);
		log.debug(TeamColor.SSH + "게시판 수정으로 가십쇼");
		
		return "semester/updateSemester";
	}
	
	
	// 수정 액션
	@PostMapping("/lmsSemester/updateSemester")
	public String updateSemester(Semester semester) throws UnsupportedOperationException{
		
		//디버깅
		log.debug(TeamColor.SSH + "변경 값 : " + semester);
		
		semesterService.updateSemester(semester);
		
		return "redirect:/lmsSemester/SemesterList";
		
	}
	
	
	
	
}