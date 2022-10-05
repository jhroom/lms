package com.gd.lms.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String messageList(Model model, HttpSession session , User user,
			@RequestParam(value="currentPage", required=false) Integer paramcurrentPage,
			@RequestParam(value="rowPerPage", required=false) Integer ParamRowPerPage) {
		//id값 받아오기
		String id = ((User)session.getAttribute("loginUser")).getUserId();
		user.setUserId(id);
		
		
		System.out.println(id);
		
		//페이징
		int currentPage = 1;
		
		if(paramcurrentPage != null) {
			currentPage = paramcurrentPage;
			log.debug(TeamColor.JCH + " 현재페이지 currentPage" + currentPage);
		}
		
		model.addAttribute("currentPage",currentPage);
		
		int rowPerPage = 10;
		if(ParamRowPerPage !=null) {
			rowPerPage = ParamRowPerPage;
			log.debug(TeamColor.JCH + "보여지는 페이지 rowPerPage " + rowPerPage);
		}
		
		//마지막 페이지
		int total = messageService.lastPageMessage(id, id);
		int lastPage =0;
		
		lastPage = total / rowPerPage;
		if( total % rowPerPage != 0) {
			lastPage+=1;
			System.out.println("sendMessage"+total);
		}
		model.addAttribute("lastPage" , lastPage);
		
		System.out.println(currentPage +"현재페이지");
		System.out.println(rowPerPage + "페이지보여질갯수");
		System.out.println(lastPage + "마지막 페이지");
		
		//리스트 불러오기
		List<Message> list = messageService.selectMessageList(id , id , currentPage , rowPerPage);
		model.addAttribute("list",list);
		
		//디버그
		log.debug(TeamColor.JCH + this.getClass() + "메시지 리스트 출력");
		
		return "user/messageList";
	}
	
	// 메시지 리스트 ( 내가보낸거 )
	@GetMapping("/user/sendmessageList")
	public String sendmessageList(Model model, HttpSession session , User user,
			@RequestParam(value="currentPage", required=false) Integer paramcurrentPage,
			@RequestParam(value="rowPerPage", required=false) Integer ParamRowPerPage) {
		
		//id값 받아오기
		String sendId = ((User)session.getAttribute("loginUser")).getUserId();
		user.setUserId(sendId);
				
		System.out.println(sendId);
		
		//페이징
		int currentPage = 1;
		
		if(paramcurrentPage != null) {
			currentPage = paramcurrentPage;
			log.debug(TeamColor.JCH + " 현재페이지 currentPage" + currentPage);
		}
		
		model.addAttribute("currentPage",currentPage);
		
		int rowPerPage = 10;
		if(ParamRowPerPage !=null) {
			rowPerPage = ParamRowPerPage;
			log.debug(TeamColor.JCH + "보여지는 페이지 rowPerPage " + rowPerPage);
		}
		
		//마지막 페이지
		int total = messageService.lastPageSendMessage(sendId);
		int lastPage =0;
		
		lastPage = total / rowPerPage;
		if( total % rowPerPage != 0) {
			lastPage+=1;
			System.out.println("sendMessage"+total);
		}
		model.addAttribute("lastPage" , lastPage);
		
		System.out.println(currentPage +"현재페이지");
		System.out.println(rowPerPage + "페이지보여질갯수");
		System.out.println(lastPage + "마지막 페이지");
		//리스트 불러오기
		List<Message> list = messageService.selectSendMessageList(sendId , currentPage , rowPerPage);
		model.addAttribute("list",list);
		
		//디버그
		log.debug(TeamColor.JCH + this.getClass() + "메시지 리스트 출력");
		
		return "user/sendmessageList";
	}
	
	// 메시지 리스트 ( 내가받은거 )
	@GetMapping("/user/receivemessageList")
	public String receivemessageList(Model model, HttpSession session , User user,
			@RequestParam(value="currentPage", required=false) Integer paramcurrentPage,
			@RequestParam(value="rowPerPage", required=false) Integer ParamRowPerPage) {
		//id값 받아오기
		String receiveId = ((User)session.getAttribute("loginUser")).getUserId();
		user.setUserId(receiveId);

		//페이징
		int currentPage = 1;
		
		if(paramcurrentPage != null) {
			currentPage = paramcurrentPage;
			log.debug(TeamColor.JCH + " 현재페이지 currentPage" + currentPage);
		}
		
		model.addAttribute("currentPage",currentPage);
		
		int rowPerPage = 10;
		if(ParamRowPerPage !=null) {
			rowPerPage = ParamRowPerPage;
			log.debug(TeamColor.JCH + "보여지는 페이지 rowPerPage " + rowPerPage);
		}
		
		//마지막 페이지
		int total = messageService.lastPageReceiveMessage(receiveId);
		int lastPage =0;
		
		lastPage = total / rowPerPage;
		if( total % rowPerPage != 0) {
			lastPage+=1;
			System.out.println("sendMessage"+total);
		}
		model.addAttribute("lastPage" , lastPage);
		
		System.out.println(currentPage +"현재페이지");
		System.out.println(rowPerPage + "페이지보여질갯수");
		System.out.println(lastPage + "마지막 페이지");
		
		//리스트 불러오기
		List<Message> list = messageService.selectReceiveMessageList(receiveId, currentPage , rowPerPage);
		model.addAttribute("list",list);
		
		//디버그
		log.debug(TeamColor.JCH + this.getClass() + "메시지 리스트 출력");
		
		return "user/receivemessageList";
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
