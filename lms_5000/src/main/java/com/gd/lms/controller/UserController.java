package com.gd.lms.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.service.UserLoginService;
import com.gd.lms.vo.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class UserController {
	
	@Autowired UserLoginService userLoginService;
	
	//로그인 페이지
	@GetMapping("/user/login")
	public String userLogin() {
		
		return "user/login";
	}
	
	//로그인 액션
	@PostMapping("/user/login")
	public String userLogin(HttpSession session, User user) {
		
		//디버깅
		log.debug(TeamColor.AJH + user + "로그인한 매개변수 확인");
		
		//입력한 id ,pw로 서비스 호출
		User resultUser = userLoginService.getUserLogin(user);
		
		//디버깅
		log.debug(TeamColor.AJH + resultUser + " db 정보유무확인");
		
		//계정 활성화가 Y인 계정에 id,level 값 세션 부여
		if( "Y".equals(resultUser.getUserActive()) ) {
			session.setAttribute("user", resultUser.getUserId());
			session.setAttribute("level", resultUser.getUserLevel());
		}
		
		return "redirect:/index";
	}
	
	//메인페이지
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	//로그아웃
	@GetMapping("/user/logout")			
	public String logout(HttpSession session) {			
	log.debug(TeamColor.AJH + this.getClass() + " 로그아웃 액션");
	
	// 세션 무효화			
	session.invalidate();			
				
	return "redirect:/user/login";			
	}
	
		
}
