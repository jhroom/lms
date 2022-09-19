package com.gd.lms.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.service.ILmsNoticeService;
import com.gd.lms.vo.LmsNotice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LmsNoticeController {
	@Autowired ILmsNoticeService lmsNoticeService;
	
	// 공지 리스트
	@GetMapping("/lmsNotice/LmsNoticeList")
	public String getLmsNoticeList(Model model) {
		
		List<LmsNotice> LmsNoticeList = lmsNoticeService.getLmsNoticeList();
		model.addAttribute("lmsNoticeList", LmsNoticeList);
		return "/lmsNotice/LmsNoticeList";
		
	}

//	//공지 추가
//	@GetMapping("/LmsNoticeAddBoard")
//	public String LmsNoticeAddBoard() {
//		
//		//디버깅
//		log.debug(TeamColor.SSH + LmsNoticeAddBoard() + "정보 추가");
//		
//		return "LmsNoticeAddBoard";
//		
//	}
//	
//	//공지 추가 액션
//	@GetMapping("/LmsNoticeAddBoard")
//	public String LmsNoticeAddboard(LmsNotice lmsNotice, HttpSession session) {
//		
//		String path = session.getServletContext().getRealPath("/update");
//		lmsNoticeService.LmsAddNotice(lmsNotice, path);
//		
//		return "redirect:/LmsNticeList";
//		
//	}
//	
	
}
