package com.gd.lms.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public String userLogin(Model model, HttpSession session, User user) {
		
		//디버깅
		log.debug(TeamColor.AJH + user + "로그인한 매개변수 확인");
		
		//입력한 id ,pw로 서비스 호출
		User resultUser = userLoginService.getUserLogin(user);
		
		//디버깅
		log.debug(TeamColor.AJH + resultUser + " db 정보유무확인");
		
		// id pw가 user정보에 없다면(로그인실패)시 실패메세지 알림
		if(resultUser == null) {
			model.addAttribute("errMsg","로그인 정보를 다시 확인해주세요");
			return "user/login";
		}
		// 유저 정보는 있지만 승인대기상태(N) 일 떄 메세지출력
		if("N".equals(resultUser.getUserActive())) {
			model.addAttribute("errMsg","승인 대기 상태입니다");
			return "user/login";
		}
		
		// user 정보가 일치하고 계정 활성화(Y)인 계정에 세션부여
		session.setAttribute("user", resultUser.getUserId());
		session.setAttribute("level", resultUser.getUserLevel());
		
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
	
	//회원가입 폼으로가기
	@GetMapping("/user/addUser")
	public String addUser() {
		return "user/addUser";
	}
	
	//회원가입 액션
	@PostMapping("/user/addUser")
	public String addUser(Model model, User user) {
		
		log.debug(TeamColor.JCH + this.getClass() + user + " addUser 파라미터 값 ");
		
		//addUser 회원가입 페이지에서 입력한정보가 성공적으로 들어갔을 떄 로그인 폼, 확인메세지 출력
		if(userLoginService.addUser(user)) {
			model.addAttribute("errMsg","회원가입 완료되었습니다");
			System.out.println("회원가입완료");
		}
		//회원가입 로직중 에러발생시 404페이지로 이동 추가 할 예정
		
		return "user/login";
	}
	
	//회원가입시 아이디 중복체크
	@PostMapping("/user/idCheck")
	@ResponseBody
	public String userIdCkeck(@RequestParam (value="userId") String userId) {
		System.out.println(TeamColor.AJH + "id check 진입 "+ userId);
		if(userLoginService.getUserIdCheck(userId)) {
			return "true";
		}
		else {
			return "false";
		}
		
	}
	
		
}
