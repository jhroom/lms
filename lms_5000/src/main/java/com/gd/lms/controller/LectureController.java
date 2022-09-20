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
import com.gd.lms.vo.SignCancel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LectureController {
  @Autowired ILectureService lectureService;
	
  @GetMapping ("/sign/openLectureList")
   public String selectLectureListForSign(Model model, Sign sign, SignCancel signCancel, HttpSession session) {
//	  // 로그인 상태가 아니면 로그인페이지
//	  if(session.getAttribute("user") == null) { 
//		  return "redirect:/lms/user/login";
//	  }
//	  // 권한이 학생 아니면 인덱스 페이지
//	  else if (Integer.parseInt((String) session.getAttribute("level")) != 3 || Integer.parseInt((String) session.getAttribute("level")) != 1) {
//		  return "redirect:/lms/index";
//	  }
	 
		
	  // 개설강좌 목록 불러오기
	  List<Map<String,Object>> lectureList = lectureService.selectLectureListForSign();
	  //디버깅
 	  log.debug(TeamColor.YHW + "-- lectureList-controller -- "+ lectureList );
 	  // view 전달을 위한 개설강좌 목록 model에 담기
 	  model.addAttribute("lectureList",lectureList);
	  
 	  
	  // 수강신청한 목록 불러오기
 	  //	  sign.setUserId((String)session.getAttribute("user"));
 	  sign.setUserId("son");
 	  List<Map<String,Object>> singList = lectureService.signList(sign);
 	  //디버깅
 	  log.debug(TeamColor.YHW + singList + "-- addSign-controller");
 	  // model에 담아 전달
 	  model.addAttribute("singList",singList);
 	  
 	  signCancel.setUserId("son");
 	  List<Map<String,Object>> cancelSignList = lectureService.selectCancelSignList(signCancel);
	   //디버깅
	   log.debug(TeamColor.YHW + "-- cancelSignList-controller -- "+ cancelSignList );
	   
	   // view에 전달
	   model.addAttribute("cancelSignList",cancelSignList);
	   
      return "/sign/openLectureList";
	  }
  
  
	   @GetMapping("/sign/addSign")
	   // 수강신청 추가
	   public String insertLecture(Sign sign, HttpSession session) {
		   // 임의 값 저장 실행확인///////////////////////////////////////////////////////////
		   //sign.setSignState(Integer.parseInt((String) session.getAttribute("level")));
		   sign.setSignNo(1);
		   //디버깅
		   log.debug(TeamColor.YHW + "-- sign-controller -- "+ sign );
		   int addSign = lectureService.addSign(sign);
		   //디버깅
		   log.debug(TeamColor.YHW + addSign + "-- addSign-controller");
		  
		   return "redirect:/sign/openLectureList";
	   }
	   
	   @GetMapping("/sign/cancelSign") 
	   // 수강신청 취소 이력 추가
	   public String cancelSign(SignCancel signCancel, HttpSession session) {
		   //signCancel.setUserId((String)session.getAttribute("user"));
		   signCancel.setUserId("son");
		   //디버깅
		   log.debug(TeamColor.YHW + "-- signCancel-controller -- "+ signCancel );
		   int addSignCancel = lectureService.addCancleSign(signCancel);
		   //디버깅
		   log.debug(TeamColor.YHW + "-- addSignCancel-controller -- "+ addSignCancel );
		   
		   int lectureNo = signCancel.getLectureNo();
		   int signNo = signCancel.getSignNo();
		   return "redirect:/sign/removeSign?lectureNo="+lectureNo+"&signNo="+signNo;
	   }
	   
	   @GetMapping("/sign/removeSign")
	   // 수강신청 취소(수강 신청 list에서 제거)
	   public String removeSign(Sign sign, SignCancel signCancel) {
		   //디버깅
		   log.debug(TeamColor.YHW + "-- sign-controller -- "+ sign );
		   int removeSign = lectureService.removeSign(sign); 
		   //디버깅
		   log.debug(TeamColor.YHW + "-- removeSign-controller -- "+ removeSign );
		   
		   int lectureNo = signCancel.getLectureNo();
		   int signNo = signCancel.getSignNo();
//		   return "redirect:/sign/cancelSignList?lectureNo="+lectureNo+"&signNo="+signNo;
		   return "redirect:/sign/openLectureList?lectureNo="+lectureNo+"&signNo="+signNo;
	   }
	   
	   
	   
//	   @GetMapping("/sign/cancelSignList")
//	   // 수강 취소 list 출력
//	   public String cancelSignList(SignCancel signCancel, Model model) {
//		   //signCancel.setUserId((String)session.getAttribute("user"));
//		   signCancel.setUserId("son");
//		   
//		   List<Map<String,Object>> cancelSignList = lectureService.selectCancelSignList(signCancel);
//		   //디버깅
//		   log.debug(TeamColor.YHW + "-- cancelSignList-controller -- "+ cancelSignList );
//		   
//		   // view에 전달
//		   model.addAttribute("cancelSignList",cancelSignList);
//		   return "redirect:/sign/openLectureList";
//	   }
	   
	   
	   
	   
  
}
