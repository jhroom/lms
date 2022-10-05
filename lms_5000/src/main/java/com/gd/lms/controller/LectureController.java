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
import com.gd.lms.vo.Subject;
import com.gd.lms.vo.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LectureController {
  @Autowired ILectureService lectureService;
  
	
  @GetMapping ("/sign/openLectureList")
   public String selectLectureListForSign(Model model, Sign sign, SignCancel signCancel, HttpSession session, int currentPage) {
//		  // 로그인 상태가 아니면 로그인페이지
//		  if(session.getAttribute("user") == null) { 
//			  return "redirect:/lms/user/login";
//		  }
//		  // 권한이 학생 아니면 인덱스 페이지
//		  else if (Integer.parseInt((String) session.getAttribute("level")) != 3 || Integer.parseInt((String) session.getAttribute("level")) != 1) {
//			  return "redirect:/lms/index";
//		  }
	 
	  // 학기 확인하기
	  boolean test = lectureService.getSemesterCheck();
	  
	  //수강신청 기간이 아닐 시
	  if(!test) {
		  log.debug(TeamColor.KHJ + "수강신청 일자가 아닙니다 -- "+ test );
		  
		  //수강신청 오류 페이지로 보내기
// 		  return "/sign/outOfSignDate";
	  }
	  log.debug(TeamColor.KHJ + "test -- "+ test );
 	  
	  	
	  // 개설강좌 목록 불러오기
	  List<Map<String,Object>> lectureList = lectureService.selectLectureListForSign();
	  // 개설강좌 목록 확인
 	  log.debug(TeamColor.YHW + "-- lectureList - controller -- "+ lectureList );
 	  
 	  /******페이징******/
 	  // 한 페이지에 나타낼 강좌 수 
 	  int num = 10;
 	  
 	  // 개설강좌 총 개수
 	  int getTotal = lectureService.getTotal();
 	  
 	  // 총 개수에 따른 페이지 수 
 	  int page;
 	  if (getTotal%num == 0) {
		page = getTotal/num;
 	  }else {
 		page = getTotal/num+1;
 	  }
 	  
 	  // 현재 페이지 설정 ( 0보다 작으면 1로 표시 )
 	  if (currentPage <= 0) {
		currentPage = 1;
 	  }
 	  
 	  // 쿼리 시작 수 설정
 	  int startNo = currentPage*num-num;
 	  if(startNo < 0) {
 		  startNo=0;
 	  }
 	  
 	  // 페이지 셋팅
 	  int startPage = page/10*10+1;
 	  int endPage = startPage+10;
 	  
 	  // 마지막 페이지 세팅
 	  if(endPage> page) {
 		  endPage = page;
 	  }
 	  
 	  // 넘겨줄 배열 값 셋팅
 	  int [] arrPage = new int[endPage - startPage+1];
 	  
 	  for(int i=0;i<arrPage.length;i++) {
 		  arrPage[i] = startPage+i;
 		  
 	  }
 	  
 	  // 페이징 변수값 디버깅
 	 log.debug(TeamColor.YHW + "-- startPage-controller -- "+ startPage );
 	 log.debug(TeamColor.YHW + "-- endPage-controller -- "+ endPage );
 	 log.debug(TeamColor.YHW + "-- page-controller -- "+ page );
 	 log.debug(TeamColor.YHW + "-- startNo-controller -- "+ startNo );
 	 log.debug(TeamColor.YHW + "-- arrPage-controller -- "+ arrPage.toString() );
 	  
 	  /***************/
 	  // 포워딩
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
	  
	  //신청 학점 조회
	  int signTime = lectureService.getSignTime(sign);
	  //신청 학점 model에 담기
 	  model.addAttribute("signTime",signTime);
	  
 	  // 포워딩
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
		   // 포워딩
		   return "redirect:/sign/openLectureList";
  	   } 
  	   
  	   
	  // 수강신청 취소 이력 추가
	   @GetMapping("/sign/cancelSign") 
	   public String cancelSign(SignCancel signCancel, HttpSession session, Model model) {
		   String userId = ((User)session.getAttribute("loginUser")).getUserId();
		   signCancel.setUserId(userId);
		   int addSignCancel = lectureService.addCancleSign(signCancel);
		   //디버깅
		   log.debug(TeamColor.YHW + "-- addSignCancel-controller -- "+ addSignCancel );
		   //디버깅
		   int lectureNo = signCancel.getLectureNo();
		   int signNo = signCancel.getSignNo();
		   // 포워딩
		   return "redirect:/sign/removeSign?lectureNo="+lectureNo+"&signNo="+signNo+"&userId="+userId+"&cancelId"+userId;
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