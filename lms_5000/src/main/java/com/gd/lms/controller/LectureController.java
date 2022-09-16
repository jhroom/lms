package com.gd.lms.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gd.lms.service.ILectureService;
import com.gd.lms.vo.Sign;


@Controller
public class LectureController {
  @Autowired ILectureService lectureService;
	
  @GetMapping ("/sign/openLectureList")
   public String selectLectureListForSign(Model model, Sign sign) {
	  //로그인 여부를 체크하기 위해 세션에 저장된 아이디 확인
//      String userid=(String)session.getAttribute("userid");
//      if(userid==null) { 
      //로그인하지 않은 상태이면 로기인 화면으로 이동
//          return "redirect:/member/login.do";
          
	  // 개설강좌 목록 불러오기
	  List<Map<String,Object>> lectureList = lectureService.selectLectureListForSign();
	  System.out.println("selectLectureListForSign controller 은 : "+lectureList);
	  
	  // 수강신청한 목록 불러오기
 	  List<Map<String,Object>> singList = lectureService.signList(sign);
 	  System.out.println("addSign controller 은 : "+singList);
 	  
	  // view 전달을 위한 개설강좌 목록 model에 담기
	  model.addAttribute("lectureList",lectureList);
	  model.addAttribute("singList",singList);
	  
	  // 디버깅
      return "/sign/openLectureList";
   }
  
   @GetMapping("/sign/addSign")
   // sign에 insert
   public String insertLecture(Sign sign) {
	   // 임의 값 저장 실행확인
	   sign.setSignState(1);
	   System.out.println("sign 은 : "+sign);	   
	   int addSign = lectureService.addSign(sign);
	   System.out.println("addSign controller 은 : "+addSign);
	   return "redirect:/sign/openLectureList";
   }
   
  
//  @GetMapping  -- insert를 사용하여 수강 신청 목록 가져오기
  
  
  
}
