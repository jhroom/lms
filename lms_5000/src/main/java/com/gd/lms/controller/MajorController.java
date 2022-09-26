package com.gd.lms.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
	
	// 학과 삭제
	@GetMapping("/lmsMajor/deleteMajor")
	public String deleteMajor(int majorNo) {
		int row = majorService.deleteMajor(majorNo);
		
		//디버깅
		log.debug(TeamColor.SSH + "삭제되는 값 : " + row);
		
		return "redirect:/lmsMajor/MajorList";
				
	}
	
	//학과 상세보기
	@GetMapping("/lmsMajor/majorOne")
	public String getselectMajorOne(int majorNo, String majorName, Model model) {
	
		Map<String, Object> majorOne = majorService.getMajorOne(majorNo);
		
		model.addAttribute("majorOne", majorOne);
		
		model.addAttribute("majorNo", majorNo);
		model.addAttribute("majorName", majorName);
		
		log.debug(TeamColor.SSH + "삭제 결과" + majorOne);
		log.debug(TeamColor.SSH + "결과확인 / 포워딩");
		
		return "major/MajorOne";
		}
	
	//학과 수정하기
	@GetMapping("/lmsMajor/updateMajor/form")
	public String updateMajor(int majorNo, Model model) {
		
		//No에 해당하는 One을 가지고 온다.
		Map<String, Object> majorOne = majorService.getMajorOne(majorNo);
		
		//받아온 값을 출력
		model.addAttribute("majorOne", majorOne);
		model.addAttribute("majorNo", majorNo);
		
		//디버깅
		log.debug(TeamColor.SSH + "수정 넘겨주기 : " + majorOne);
		log.debug(TeamColor.SSH + "게시판수정으로 가십시오");
		
		return "major/updateMajor";
		
	}
	
	//수정 액션
	@PostMapping("/lmsMajor/updateMajor")
	public String updateMajor(Major major) throws UnsupportedEncodingException {
		
		//디버깅
		log.debug(TeamColor.SSH + "변경 값 : " + major);
		
		majorService.updateMajor(major);
		
		return "redirect:/lmsMajor/MajorList";
		
	}
	
	
	
}
