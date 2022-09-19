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
		
		
		
		//리스트 불러오기
		List<LmsNotice> LmsNoticeList = lmsNoticeService.getLmsNoticeList();
		model.addAttribute("lmsNoticeList", LmsNoticeList);
		return "/lmsNotice/LmsNoticeList";
		
	}

	//공지 추가
	@GetMapping("/lmsNotice/LmsNoticeAddBoard")
	public String LmsNoticeAddBoard() {
		
		return "/lmsNotice/LmsNoticeAddBoard";
		
	}
	
	//공지 추가 액션
//	@GetMapping("/lmsNotice/LmsNoticeAddBoard")
//	public String LmsNoticeAddboard(LmsNotice lmsNotice, HttpSession session) {
//		
//		String path = session.getServletContext().getRealPath("/upload");
//		lmsNoticeService.LmsAddNotice(lmsNotice, path);
//			
//		return "redirect:/lmsNotice/LmsNticeList";
//		
//	}
	
	
}
