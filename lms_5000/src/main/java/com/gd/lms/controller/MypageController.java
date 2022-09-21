package com.gd.lms.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public String myInfo(String msg, HttpSession session, Model model) {
		
		//사용자 정보가 없는 사람이 마이페이지 갈경우
		if(session.getAttribute("loginUser") == null) {
			model.addAttribute("errMsg","로그인 후 이용 가능합니다");
			return "index/login";
		}
		String userId = ((User)session.getAttribute("loginUser")).getUserId();
		
		// 유저의 가입정보 받아오기
		User userInfo = mypageService.getUserInfo(userId);
		System.out.println(TeamColor.AJH + "userId의 가입정보 : "+ userInfo);
		
		model.addAttribute("userInfo", userInfo);
		
		//주소창 파라미터 값 뷰로 넘겨주기
		model.addAttribute("msg", msg);
		
		return "user/myInfo";
	}
	
	@PostMapping("index/mypage/changeUserInfo")
	public String modifyUserInfo(HttpSession session, @RequestParam (value="userInfo") String userInfo) throws UnsupportedEncodingException {
		log.debug(TeamColor.AJH+"유저정보번경 메서드 파라미터 : " + userInfo);
		
		//세션에 저장된 UserInfo 의 아이디
		String userId = ((User)session.getAttribute("loginUser")).getUserId();
		int userLevel = ((User)session.getAttribute("loginUser")).getUserLevel();
		
		Map<String, Object> map = new HashMap<>();
		map.put("userInfo", userInfo);
		map.put("userLevel", userLevel);
		map.put("userId", userId);
		
		int result = mypageService.modifyUserInfo(map);
		String msg = null;
		
		if(result != 1) {
			return "index/mypage/info";
		}
		msg = "정보 변경 되었습니다";
		
		String encodedParam = URLEncoder.encode(msg, "UTF-8"); 
		//index 뷰페이지 msg 출력 추가해야함
		
		return "redirect:/index/mypage/info?msg="+encodedParam;
	}
	
	@GetMapping("index/mypage/postList")
	public String myPostList(HttpSession session, Model model) {
		String userId = ((User)session.getAttribute("loginUser")).getUserId();
		System.out.println(TeamColor.AJH + "세션에 저장된 아이디 : " + userId);
		
		return "user/postList";
	}
	
	@PostMapping("rest/pwCheck")
	@ResponseBody
	public int pwCheck(Model model, User user) {
		log.debug("파라미터 값 확인 : " + user.getUserId() + " " + user.getUserPw());
		// 현재 비밀번호가 db에있는 user id의 pw가 일치하면 1 틀리면 0
		User result = mypageService.getPwCheck(user);
		
		if( result != null) {
			log.debug("db결과 값 확인 : " + result);
			return 1;
		}
		return 0;
	}
	@PostMapping("index/mypage/updatePw")
	public String updatePw(User user, @RequestParam (value="userPw1") String userPw1) {
		
		log.debug("뷰에서 넘어온 파라미터 값 확인 : " + user + " " + userPw1);
		// 변경할 비밀번호를 user 객체에
		user.setUserPw(userPw1);
		
		int result = mypageService.modifyUserPw(user);
		log.debug("db결과 확인 : " + result);
		
		return "redirect:/index/login";
	}

}
