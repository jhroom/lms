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
import com.gd.lms.service.ISignListforAdminService;
import com.gd.lms.vo.Sign;
import com.gd.lms.vo.SignCancel;
import com.gd.lms.vo.User;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LectureController {
  @Autowired ILectureService lectureService;
  @Autowired ISignListforAdminService signListforAdminService;
	
  @GetMapping ("/sign/openLectureList")
   public String selectLectureListForSign(Model model, Sign sign, SignCancel signCancel, HttpSession session) {
//		  // 로그인 상태가 아니면 로그인페이지
//		  if(session.getAttribute("user") == null) { 
//			  return "redirect:/lms/user/login";
//		  }
//		  // 권한이 학생 아니면 인덱스 페이지
//		  else if (Integer.parseInt((String) session.getAttribute("level")) != 3 || Integer.parseInt((String) session.getAttribute("level")) != 1) {
//			  return "redirect:/lms/index";
//		  }z
	 
	  	
	  // 개설강좌 목록 불러오기
	  List<Map<String,Object>> lectureList = lectureService.selectLectureListForSign();
	  // 개설강좌 목록 확인
 	  log.debug(TeamColor.YHW + "-- lectureList - controller -- "+ lectureList );
 	  //개설강좌 목록 model에 담기
 	  model.addAttribute("lectureList",lectureList);
	  
 	  
	  // 수강신청 리스트
 	  String userId = ((User)session.getAttribute("loginUser")).getUserId();
 	  sign.setUserId(userId);
 	  List<Map<String,Object>> singList = lectureService.signList(sign);
 	  // 수강신청 목록 확인
 	  log.debug(TeamColor.YHW + singList + "-- addSign-controller");
 	  // model에 담아 전달
 	  model.addAttribute("singList",singList);
 	  
 	  
 	  // 수강 취소 리스트 
 	  signCancel.setUserId(userId);
 	  List<Map<String,Object>> cancelSignList = lectureService.selectCancelSignList(signCancel);
	   //디버깅
	  log.debug(TeamColor.YHW + "-- cancelSignList-controller -- "+ cancelSignList );
	   
	  // view에 전달
	  model.addAttribute("cancelSignList",cancelSignList);
	   
      return "/sign/openLectureList";
	  }
  
  
	  // 수강신청 추가
  	   @GetMapping("/sign/addSign")
  	   public String insertLecture(Sign sign, HttpSession session) {
		   // 수강신청 추가 내용
		   log.debug(TeamColor.YHW + "-- sign-controller -- "+ sign );
		   int addSign = lectureService.addSign(sign);
		   // 수강신청 등록 확인
		   log.debug(TeamColor.YHW + addSign + "-- addSign-controller");
		  
		   return "redirect:/sign/openLectureList";
  	   } 
  	   
  	   
	  // 수강신청 취소 이력 추가
	   @GetMapping("/sign/cancelSign") 
	   public String cancelSign(SignCancel signCancel, HttpSession session) {
		   String userId = ((User)session.getAttribute("loginUser")).getUserId();
		   signCancel.setUserId(userId);
		   int addSignCancel = lectureService.addCancleSign(signCancel);
		   int SignCancel = signListforAdminService.modifySignState(null, signCancel);
		   //디버깅
		   log.debug(TeamColor.YHW + "-- addSignCancel-controller -- "+ addSignCancel );
		   //디버깅
		   log.debug(TeamColor.YHW + "-- SignCancel-controller -- "+ SignCancel );
		   
		   int lectureNo = signCancel.getLectureNo();
		   int signNo = signCancel.getSignNo();
		   return "redirect:/sign/removeSign?lectureNo="+lectureNo+"&signNo="+signNo+"&userId="+userId;
	   }

	   
	   // 수강신청 취소(수강 신청 list에서 제거)
	   @GetMapping("/sign/removeSign")
	   public String removeSign(Sign sign, SignCancel signCancel, HttpSession session) {
		   String userId = ((User)session.getAttribute("loginUser")).getUserId();
		   sign.setUserId(userId);
		   int removeSign = lectureService.removeSign(sign); 
		   // 수강신청 목록
		   log.debug(TeamColor.YHW + "-- removeSign-controller -- "+ removeSign );
		   
		   int lectureNo = signCancel.getLectureNo();
		   int signNo = signCancel.getSignNo();
		   return "redirect:/sign/openLectureList?lectureNo="+lectureNo+"&signNo="+signNo+"&userId="+userId;
	   }
}