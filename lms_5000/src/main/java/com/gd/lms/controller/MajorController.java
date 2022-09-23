package com.gd.lms.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.service.IMajorService;
import com.gd.lms.service.IMypageService;
import com.gd.lms.vo.Major;
import com.gd.lms.vo.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller

public class MajorController {
	@Autowired IMajorService majorService;
	@Autowired IMypageService mypageService;
	
	
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
	public String addMajor(HttpSession session, Model model) throws Exception {
		//세션값 중 ID만 가져오기
		String userId=((User)session.getAttribute("loginUser")).getUserId();
		
		//디버깅 이름 잘 들어왔나?
		log.debug(TeamColor.SSH + "userId : " + userId);
		
		//model을 사용하여 전달
		model.addAttribute("userId", userId);
		
		
		
		return "/major/addMajor";
	}
	
	
	// 학과 추가 액션
	@GetMapping("/lmsMajor/MajorList/add")
	public String addMajor(Major major) {
		majorService.addMajor(major);
		
		log.debug(TeamColor.SSH + "학과이름 : " + major);
		
		return "redirect:/lmsMajor/MajorList";
		
	}

}
