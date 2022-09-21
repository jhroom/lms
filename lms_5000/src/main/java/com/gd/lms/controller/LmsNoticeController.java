package com.gd.lms.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.service.ILmsNoticeService;
import com.gd.lms.service.LmsNoticeService;
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
	@GetMapping("/lmsNotice/LmsNoticeAddBoard//add")
	public String LmsNoticeAddboard(LmsNotice lmsNotice) {
		
		
		lmsNoticeService.LmsAddNotice(lmsNotice);
			
		return "redirect:/lmsNotice/LmsNoticeList";
		
	}
	
	//공지 상세보기
	@GetMapping("/lmsNotice/LmsNoticeOne")
	public String getselectLmsNoticeOne(int lmsNoticeNo, String lmsNoticeTitle, Model model) {
		
	Map<String, Object> noticeOne = lmsNoticeService.getLmsNoticeOne(lmsNoticeNo);
	
	//이거 하나로 다 받아오고 있다.
	model.addAttribute("noticeOne", noticeOne);
	
	//수정 삭제를 위해서 이게 필요하다.
	model.addAttribute("lmsNoticeNo", lmsNoticeNo);
	model.addAttribute("lmsNoticeTitle", lmsNoticeTitle);
	
	log.debug(TeamColor.SSH + "값 확인/noticeOne" + noticeOne);
	log.debug(TeamColor.SSH + "결과확인 / 포워딩");
	
	
	return "lmsNotice/LmsNoticeOne";
	
	}
	
	//공지 삭제
	@GetMapping("/lmsNotice/deleteLmsNotice")
	public String deleteLmsNotice(int lmsNoticeNo) {
		int row = lmsNoticeService.deleteLmsNotice(lmsNoticeNo);
		
		//디버깅
		log.debug(TeamColor.SSH+ "삭제되는 값 :" + row);
		
		return "redirect:/lmsNotice/LmsNoticeList";
	}
	
	
	//공지 수정
	@GetMapping("/lmsNotice/UpdateLmsNotice")
	public String updateLmsNotice(Model model, @RequestParam(value="lmsNoticeNo") int lmsNoticeNo, LmsNotice lmsNotice) {
		
		//lmsNoticeNo의 해당하는 One을 가지고온다.
		Map<String, Object> updateNotice = lmsNoticeService.getLmsNoticeOne(lmsNoticeNo);
		
		model.addAttribute("updateNotice", updateNotice);
//		model.addAttribute("lmsNoticeNo", lmsNoticeNo);
//		model.addAttribute("lmsNotice", lmsNotice);
		
		return "lmsNotice/UpdateLmsNotice";
	}
	
 
	//수정 액숀
	@GetMapping("/lmsNotice/updateLmsNotice/action")
	public String updateLmsNotice(LmsNotice lmsNotice) {
		
		lmsNoticeService.updateLmsNotice(lmsNotice);
		
		return "redirect:/lmsNotice/LmsNoticeList";
		
		
	}
}

