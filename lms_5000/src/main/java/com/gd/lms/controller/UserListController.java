package com.gd.lms.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.service.IMypageService;
import com.gd.lms.service.IUserListService;
import com.gd.lms.vo.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class UserListController {
	@Autowired IUserListService userService;
	
	@Autowired IMypageService mypageService;
	//유저 리스트
	@GetMapping("/user/userList")
	public String userList(Model model) {
		
		//리스트 불러오기
		List<User> list = userService.selectUserList();
		model.addAttribute("list", list);
		
		log.debug(TeamColor.JCH + this.getClass()  + " 유저 리스트 출력 ");

		//페이징
		
		return "user/userList";
	}
	
	//유저 활성화값 변경 - 전체보기 리스트에서
	@PostMapping("/user/userList")
	public String updateUserActive(User user) {
		//유저 계정승인여부를 Y , N로 
		
		int row= userService.updateUserActive(user);
		
		return "redirect:/user/userList";
	}
	
	//승인대기 유저 리스트 페이지
	@GetMapping("/user/waitUser")
	
	public String waitUserList(Model model){
		//리스트 불러오기
		List<User> list = userService.selectWaitUserList();
		model.addAttribute("list", list);
		
		log.debug(TeamColor.JCH + this.getClass()  + " 승인 대기 유저 리스트 출력 ");

		//페이징
		
		return "user/waitUser";
	}
	
	//유저 활성화값 변경 - 대기유저 리스트에서
	@PostMapping("/user/waitUser")
	public String updateWaitUser(User user) {
		//유저 계정승인여부를 Y , N로 

		int row= userService.updateUserActive(user);

		
		return "redirect:/user/waitUser";
	}
	
	//승인완료 유저 리스트 페이지
	@GetMapping("/user/yesUser")
	
	public String yesUserList(Model model){
		//리스트 불러오기
		List<User> list = userService.selectYesUserList();
		model.addAttribute("list", list);
		
		log.debug(TeamColor.JCH + this.getClass()  + " 승인 대기 유저 리스트 출력 ");

		//페이징
		
		return "user/yesUser";
	}
	
	//유저 활성화값 변경 - 완료유저 리스트에서
		@PostMapping("/user/yesUser")
		public String updateYesUser(User user) {
			//유저 계정승인여부를 Y , N로 

			int row= userService.updateUserActive(user);

			
			return "redirect:/user/yesUser";
		}
	
	
	//비밀번호 변경 페이지. userController로 이동시켜도 무방.
	@GetMapping("/user/updatePw")
	public String updatePw(HttpSession session, Model model) {
		//사용자 정보가 없는 사람이 마이페이지 갈경우
		if(session.getAttribute("loginUser") == null) {
			model.addAttribute("errMsg","로그인 후 이용 가능합니다");
			return "index/login";
		}
		String userId = ((User)session.getAttribute("loginUser")).getUserId();
		
		// 유저의 가입정보 받아오기
		User userInfo = mypageService.getUserInfo(userId);
		model.addAttribute("userInfo", userInfo);
		
		return "/user/updatePw";
	}
	

}
