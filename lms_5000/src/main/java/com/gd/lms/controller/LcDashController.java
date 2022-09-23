package com.gd.lms.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.service.IMainDashService;
import com.gd.lms.vo.Sign;
import com.gd.lms.vo.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LcDashController {
	@Autowired IMainDashService studentService;
	
	// 강의중 수강 목록 출력
	@GetMapping("/dashBoard/stDash")
	public String dashboard(Sign sign, Model model, HttpSession session){
		  String userId = ((User)session.getAttribute("loginUser")).getUserId();
	 	  sign.setUserId(userId);
	 	  List<Map<String,Object>> signList = studentService.selectStudentSignList(sign);
	 	  // 수강신청 목록 확인
	 	  log.debug(TeamColor.YHW + signList + "-- addSign-controller");
	 	  // model에 담아 전달
	 	  model.addAttribute("signList",signList);
		 return "/dashBoard/stDash";
		
	}
	
}
