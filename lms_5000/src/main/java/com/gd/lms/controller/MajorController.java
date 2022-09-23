package com.gd.lms.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.service.IMajorService;
import com.gd.lms.vo.Major;
import com.gd.lms.vo.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller

public class MajorController {
	@Autowired IMajorService majorService;
	
	// 학과 리스트
	@GetMapping("/lmsMajor/MajorList")
	public String getMajorList(Model model) {
		
		//리스트 불러오기
		List<Major> MajorList = majorService.getMajorList();
		model.addAttribute("MajorList", MajorList);
		
		log.debug(TeamColor.SSH + "리스트" + MajorList);
		
		return "/major/MajorList";
	}
	
	// 학과 추가
	@GetMapping("/lmsMajor/addMajor")
	public String addMajor() {
		//HttpSession session, Model model
		
		
		return "/major/addMajor";
	}
	
	
	// 학과 추가 액션
	@GetMapping("/lmsMajor/MajorList/add")
	public String addMajor(Major major) {
		majorService.addMajor(major);
		
		return "redirect:/lmsMajor/MajorList";
		
	}

}
