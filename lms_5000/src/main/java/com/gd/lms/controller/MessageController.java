package com.gd.lms.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.service.IMessageService;
import com.gd.lms.service.IUserListService;
import com.gd.lms.service.IUserLoginService;
import com.gd.lms.vo.Message;
import com.gd.lms.vo.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MessageController {
	@Autowired IMessageService messageService;
	@Autowired IUserListService userListService;
	@Autowired IUserLoginService  userLoginService;
	
	// 메시지 리스트 (전체)
	@GetMapping("/user/messageList")
	public String messageList(Model model, HttpSession session , User user) {
		//id값 받아오기
		String id = ((User)session.getAttribute("loginUser")).getUserId();
		user.setUserId(id);
		
		
		System.out.println(id);
		//리스트 불러오기
		List<Message> list = messageService.selectMessageList(id);
		model.addAttribute("list",list);
		
		//디버그
		log.debug(TeamColor.JCH + this.getClass() + "메시지 리스트 출력");
		
		return "user/messageList";
	}
	
	// 메시지 리스트 ( 내가보낸거 )
	@GetMapping("/user/sendmessageList")
	public String sendmessageList(Model model, HttpSession session , User user) {
		//id값 받아오기
		String id = ((User)session.getAttribute("loginUser")).getUserId();
		user.setUserId(id);
		
		System.out.println(id);
		//리스트 불러오기
		List<Message> list = messageService.selectSendMessageList(id);
		model.addAttribute("list",list);
		
		//디버그
		log.debug(TeamColor.JCH + this.getClass() + "메시지 리스트 출력");
		
		return "user/messageList";
	}
	
	// 메시지 리스트 ( 내가받은거 )
	@GetMapping("/user/receivemessageList")
	public String receivemessageList(Model model, HttpSession session , User user) {
		//id값 받아오기
		String id = ((User)session.getAttribute("loginUser")).getUserId();
		user.setUserId(id);
		
		//리스트 불러오기
		List<Message> list = messageService.selectReceiveMessageList(id);
		model.addAttribute("list",list);
		
		//디버그
		log.debug(TeamColor.JCH + this.getClass() + "메시지 리스트 출력");
		
		return "user/messageList";
	}
	
	//메시지 상세보기 ( 내용보기 )
	@GetMapping("/user/messageOne")
	public String messageOne(Model model , HttpSession session , int messageNo , User user , Message message) {
		//id값 받아오기
		String id = ((User)session.getAttribute("loginUser")).getUserId();
		user.setUserId(id);
		
		message.setReceiveId(id);
		
		List<Message> list = messageService.selectMessageOne(messageNo);
		model.addAttribute("list", list);
		
		int row = messageService.updateMessageState(message);
		
		return "user/messageOne";
	}
	
	//메시지 보내는 페이지.
	@GetMapping("/user/message")
	public String message(Model model) {
		//메시지 리스트 출력하기
		
		
		return "user/message";
	}
	
	//메시지 보내는 기능.
	@PostMapping("user/message")
	public String insertMessage(Model model , Message message) {	
		
				
		int row = messageService.insertMessage(message);

		return "redirect:/user/messageList";
	}
	


	
}
