package com.gd.lms.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.service.ILectureService;
import com.gd.lms.vo.Sign;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LectureController {
  @Autowired ILectureService lectureService;
	
  @GetMapping ("/sign/openLectureList")
   public String selectLectureListForSign(Model model, Sign sign, HttpSession session) {
//	  // 로그인 상태가 아니면 로그인페이지
//	  if(session.getAttribute("user") == null) { 
//		  return "redirect:/user/login";
//	  }
//	  // 권한이 학생 아니면 인덱스 페이지
//	  else if (Integer.parseInt((String) session.getAttribute("level")) != 3) {
//		  return "redirect:/index";
//	  }
	 
		
	  // 개설강좌 목록 불러오기
	  List<Map<String,Object>> lectureList = lectureService.selectLectureListForSign();
	  //디버깅
 	  log.debug(TeamColor.YHW + lectureList + "-- lectureList-controller");
	  
	  // 수강신청한 목록 불러오기
 	  // 이걸 사용하면 됨
//	  sign.setUserId((String)session.getAttribute("user"));
 	  // 로그인상태로 접근을 못하므로 임의 아이디 설정/////////////////////////////////////////////////////////
 	  sign.setUserId("son");
 	  List<Map<String,Object>> singList = lectureService.signList(sign);
 	  //디버깅
 	  log.debug(TeamColor.YHW + singList + "-- addSign-controller");
	  // view 전달을 위한 개설강좌 목록 model에 담기
	  model.addAttribute("lectureList",lectureList);
	  model.addAttribute("singList",singList);
	  
	  
      return "/sign/openLectureList";
   }
  
   @GetMapping("/sign/addSign")
   // 수강신청 추가
   public String insertLecture(Sign sign) {
	   // 임의 값 저장 실행확인///////////////////////////////////////////////////////////
	   sign.setSignState(1);
	   //디버깅
	   log.debug(TeamColor.YHW + sign + "-- sign-controller");
	   int addSign = lectureService.addSign(sign);
	   //디버깅
	   log.debug(TeamColor.YHW + addSign + "-- addSign-controller");
	  
	   return "redirect:/sign/openLectureList";
   }
   
   @GetMapping("/sign/removeSign")
   // 수강신청 취소
   public String removeSign(Sign sign) {
	  //디버깅
	  log.debug(TeamColor.YHW + sign + "-- sign-controller");
	  int removeSign = lectureService.removeSign(sign); 
	  //디버깅
	  log.debug(TeamColor.YHW + removeSign + "-- removeSign-controller");
	  return "redirect:/sign/openLectureList";
   }
//  @GetMapping  -- insert를 사용하여 수강 신청 목록 가져오기
  
  
  
}
