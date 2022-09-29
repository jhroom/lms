package com.gd.lms.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.service.ITotalGradeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class TotalGradeController {
	@Autowired ITotalGradeService totalGradeService;
	
	//교수 성적 폼 전송
	@GetMapping("/grade/pro/form")
	public String goGradeProForm(HttpSession sesssion, Model model, int lectureNo) {
		//파라미터 확인 디버깅
		log.debug(TeamColor.KHJ + "파라미터 확인 / lectureNo : " + lectureNo);

		
		
		//리턴값 세팅
		List<Map<String, Object>> stuGradeList = totalGradeService.getTotalgradePro(lectureNo);
		
		//값 넘겨주기
		model.addAttribute("stuGradeList", stuGradeList);
		model.addAttribute("lectureNo", lectureNo);
		
		
		return "totalGrade/gradePro";
	}
	//각 점수 입력 및 산출 기능
	@PostMapping("/grade/pro/cal")
	public String calGrade(HttpSession sesssion, int [] paper, int lectureNo) {
		//파라미터 확인 디버깅
		log.debug(TeamColor.KHJ + "파라미터 확인 / lectureNo : " + lectureNo);
		log.debug(TeamColor.KHJ + "파라미터 확인 / paper : " + Arrays.toString(paper));
		
		int row = totalGradeService.calGrade(lectureNo, paper);
		
		
		//다시 폼으로 전송
		return "redirect:/grade/pro/form?lectureNo="+lectureNo;		
	}
	
	//최종 등수 및 학점 기능
	@GetMapping("/grade/pro/final")
	public String calFinalGrade(HttpSession sesssion, Model model, int lectureNo) {
		//파라미터 확인 디버깅
		log.debug(TeamColor.KHJ + "파라미터 확인 / lectureNo : " + lectureNo);
		
		
		
		
		
		//다시 폼으로 전송
		return "redirect:/grade/pro/form?lectureNo="+lectureNo;		
	}
	
	
	//<<<<<<<교수 기능
	
	
	
	//>>>>>>>>>학생 기능
	
	//학생 성적 폼 전송
	@GetMapping("/grade/stu/form")
	public String goGradeStuForm(HttpSession session, Model model,int lectureNo) {
		// 파라미터 확인 디버깅
		log.debug(TeamColor.YHW + "파라미터 확인 / lectureNo : " + lectureNo);
		
		// 리턴값 셋팅
		List<Map<String, Object>> gradeList = totalGradeService.
		
		return "totalGrade/gradeStu";
	}

}
