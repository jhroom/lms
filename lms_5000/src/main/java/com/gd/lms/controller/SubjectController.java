package com.gd.lms.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.service.IMajorService;
import com.gd.lms.service.ISubjectService;
import com.gd.lms.vo.Major;
import com.gd.lms.vo.Subject;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class SubjectController {
	@Autowired ISubjectService subjectService;
	@Autowired IMajorService majorService;
	
	
	// 강좌 리스트
	@GetMapping("/lmsSubject/SubjectList")
	public String getSubjectList(Model model) {
		
		//리스트 불러오기
		List<Subject> SubjectList = subjectService.getSubjectList();
		List<Major> getMajorList = majorService.getMajorList();
		
		//리스트 구현
		model.addAttribute("SubjectList", SubjectList);
		model.addAttribute("getMajorList", getMajorList);
				
		//디버깅
		log.debug(TeamColor.SSH + "학과리스트 : " + getMajorList);
		log.debug(TeamColor.SSH + "강좌리스트 : " + SubjectList);
		
		return "/subject/SubjectList";
	}
	
	// 강좌 보기
	@GetMapping("/lmsSubject/subjectOne")
	public String getselectSubjectOne(int subjectNo, String subjectName, Model model) {
		
		// 상세값 가지고 오기
		Map<String, Object> subjectOne = subjectService.getSubjectOne(subjectNo);
		
		//리스트 불러우기
		List<Major> getMajorList = majorService.getMajorList();
		//리스트 구현
		model.addAttribute("getMajorList", getMajorList);
		
		//One 구현
		model.addAttribute("subjectOne", subjectOne);
		
		
		model.addAttribute("subjectNo", subjectNo);
		model.addAttribute("subjectName", subjectName);
		
		//디버깅
		log.debug(TeamColor.SSH + "결과확인 : " + subjectOne);
		log.debug(TeamColor.SSH + "결과확인 / 포워딩");
		
		
		return "subject/SubjectOne";
		
		
	}
	
	// 강좌 추가 폼
	@GetMapping("/lmsSubject/addSubject")
	public String addSubject(Model model) {
		
		//리스트 불러우기
		List<Major> getMajorList = majorService.getMajorList();
		//리스트 구현
		model.addAttribute("getMajorList", getMajorList);
		
		//디버깅
		log.debug(TeamColor.SSH + "학과리스트 : " + getMajorList);
		
		return "/subject/addSubject";
	}
	
	// 강좌 추가 액션
	@GetMapping("/lmsSubject/addSubject/add")
	public String addSubject(Subject subject) {
		subjectService.addSubject(subject);
		
		log.debug(TeamColor.SSH + "강좌 추가 : " + subject);
		
		return "redirect:/lmsSubject/SubjectList";
	}
	
	// 강좌 수정 폼
	@GetMapping("/lmsSubject/updateSubject/form")
	public String updateSubject(int subjectNo, Model model) {
		
		// No에 해당하는 One을 가지고 온다.
		Map<String, Object> subjectOne = subjectService.getSubjectOne(subjectNo);
		
		//리스트 불러우기
				List<Major> getMajorList = majorService.getMajorList();
				//리스트 구현
				model.addAttribute("getMajorList", getMajorList);
		
		// 가지고온 값을 출력한다.
		model.addAttribute("subjectOne", subjectOne);
		model.addAttribute("subjectNo", subjectNo);
		
		// 디버깅
		log.debug(TeamColor.SSH + "수정 넘겨주기 : " + subjectOne);
		log.debug(TeamColor.SSH + "게시판 수정으로 가십시오");
		
		return "subject/updateSubject";
	}
	
	// 수정 액션
	@PostMapping("/lmsSubject/updateSubject")
	public String updateSubject(Subject subject) throws UnsupportedEncodingException {
		
		// 디버깅
		log.debug(TeamColor.SSH + "변경 값 : " + subject);
		
		subjectService.updateSubject(subject);
		
		return "redirect:/lmsSubject/SubjectList";
		
	}
	
	//학과 삭제
	@GetMapping("/lmsSubject/deleteSubject")
	public String deleteSubject(int subjectNo) {
		int row = subjectService.deleteSubject(subjectNo); 
		
		//디버깅
		log.debug(TeamColor.SSH + "삭제되는 값 : " + row);
		 
		return "redirect:/lmsSubject/SubjectList";
	}
	
	
}
