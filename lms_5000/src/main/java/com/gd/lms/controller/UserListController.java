package com.gd.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.service.IUserListService;
import com.gd.lms.vo.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class UserListController {
	@Autowired IUserListService userService;
	
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
	
	//유저 활성화값 변경
	@PostMapping("/user/userList")
	public String updateUserActive(User user) {
		//유저 계정승인여부를 Y , N로 
		
		int row= userService.updateUserActive(user);
		
		return "redirect:/user/userList";
	}
	
}
