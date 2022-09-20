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
		
		//정보가 맞지않아 데이터를 찾을수 없을때
		if(findPw == "") {
			model.addAttribute("PwMsg", "입력 정보를 확인해주세요");
		}else {
			//임시 비밀번호를 만들어주는 서비스 출력
			String randomPw = String.valueOf( findUserService.updateUserPw(user)  );
			//임시비밀번호를 최종 비밀번호에 담아줌
			String resultPw = randomPw;
			
			//확인용 출력
			System.out.println(resultPw);
			//업데이트된 임시비밀번호 출력.
			model.addAttribute("PwMsg" , "임시비밀번호는 " + user.getUserPw() + "입니다."
					+ " 로그인 후 비밀번호를 변경해 주세요.");
			}
		
		log.debug(TeamColor.JCH + this.getClass()  + " 비밀번호 찾기 액션 ");

		return "user/findUserPw";
	}
}
