package com.gd.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.service.FindUserService;
import com.gd.lms.vo.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class FindUserController {
	
	@Autowired FindUserService findUserService;
	
	//아이디 / 비밀번호 찾기 페이지
	@GetMapping("/user/findUserId")
	public String userfindId() {
			
		return "user/findUserId";
	}
	
	@GetMapping("/user/findUserPw")
	public String userfindPw() {
			
		return "user/findUserPw";
	}
		
	//아이디 찾기 액션
	@PostMapping("/user/findUserId")
	public String findUserId(Model model, User user) {
		//실행을 위한 서비스 호출
		String findId = findUserService.findUserId(user);
		
		//db에 정보가 없을경우에
		if(findId == "") {
			System.out.println("데이터가 없을때");
			model.addAttribute("IdMsg" , "정보를 확인해주세요");
		}else {
			System.out.println("데이터가 있을때");
			model.addAttribute("IdMsg" , "아이디는 " + findId + "입니다");
		}
		
		log.debug(TeamColor.JCH + this.getClass()  + " 아이디 찾기 액션 ");
			
		return "user/findUserId";
	}
	
	//비밀번호 찾기 액션
	@PostMapping("/user/findUserPw")
	public String findUserPw(Model model, User user) {
		String findPw = findUserService.findUserPw(user);
		System.out.println(findPw + "유저 pw 확인용");
		
		
		//finPw가 null일경우에 ( 입력한 정보가 맞지않아 비밀번호를 db에서 찾아낼 수 없을때)
		if(findPw == "") {
			model.addAttribute("PwMsg", "입력 정보를 확인해주세요");
		}else {  
			//비밀번호가 존재하면 일부는 *로 치환해서 보여줄것.
			int pwSize = findPw.length()/2;
			//뒤에 붙일 *표
			String pwStar = "";
			if(pwSize%2 == 1) { //홀수인경우에는 *이 하나 추가
				for( int i=0; i<pwSize+1; i++) {
					pwStar += "*";
				}
			}else { // 짝수일경우는 추가없이 
				for( int i=0; i<pwSize; i++) {
					pwStar += "*";
				}
			}
			
			//비밀번호를 일부를 잘라서 *표로 표현하기위한 subString
			String mdPw = findPw.substring(0, pwSize);
			
			//최종적으로 값을 담아줄 resultPw
			String resultPw = mdPw + pwStar;
			model.addAttribute("PwMsg" , "비밀번호는 " + resultPw + "입니다");
		}
		
		log.debug(TeamColor.JCH + this.getClass()  + " 비밀번호 찾기 액션 ");

		return "user/findUserPw";
	}
}
