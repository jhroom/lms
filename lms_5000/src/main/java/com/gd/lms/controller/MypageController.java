package com.gd.lms.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.service.IMypageService;
import com.gd.lms.vo.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MypageController {
	
	@Autowired IMypageService mypageService;
	
	@GetMapping("/index/mypage")
	public String mypage(HttpSession session, Model model) {
		//사용자 정보가 없는 사람이 마이페이지 갈경우
		if(session.getAttribute("loginUser") == null) {
			model.addAttribute("errMsg","로그인 후 이용 가능합니다");
			return "index/login";
		}
		
		return "user/mypage";
	}
	
	@GetMapping("index/mypage/info")
	public String myInfo(HttpSession session, Model model) {
		//사용자 정보가 없는 사람이 마이페이지 갈경우
		if(session.getAttribute("loginUser") == null) {
			model.addAttribute("errMsg","로그인 후 이용 가능합니다");
			return "index/login";
		}
		String userId = ((User)session.getAttribute("loginUser")).getUserId();
		
		// 유저의 가입정보 받아오기
		User userInfo = mypageService.getUserInfo(userId);
		model.addAttribute("userInfo", userInfo);
		
		return "user/myInfo";
	}
	
	@PostMapping("index/mypage/changeUserInfo")
	public String modifyUserInfo(Model model, HttpSession session, @RequestParam (value="userInfo") String userInfo) {
		log.debug(TeamColor.AJH+"유저정보번경 메서드 파라미터 : " + userInfo);
		
		//세션에 저장된 UserInfo 의 아이디
		String userId = ((User)session.getAttribute("loginUser")).getUserId();
		int userLevel = ((User)session.getAttribute("loginUser")).getUserLevel();
		
		Map<String, Object> map = new HashMap<>();
		map.put("userInfo", userInfo);
		map.put("userLevel", userLevel);
		map.put("userId", userId);
		
		int result = mypageService.modifyUserInfo(map);
		if(result != 1) {
			model.addAttribute("errMsg","오류로 인하여 변경 실패하였습니다.");
			return "index/login";
		}
		model.addAttribute("errMsg","정보 변경 되었습니다.");
		//index 뷰페이지 msg 출력 추가해야함
		return "redirect:/index";
		
	}

}
