package com.gd.lms.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gd.lms.service.ILmsNoticeService;
import com.gd.lms.service.IMainDashService;
import com.gd.lms.service.IUserListService;
import com.gd.lms.service.IUserLoginService;
import com.gd.lms.vo.LmsNotice;
import com.gd.lms.vo.User;

@Controller
public class CalendarController {

	@Autowired IUserLoginService userLoginService;
	@Autowired IUserListService userListService;
	@Autowired IMainDashService mainDashService; //강좌 리스트 서비스
	@Autowired ILmsNoticeService lmsNoticeService; //공지사항 서비스
	
	//달력1 테스트용
	@GetMapping("/calendar")
		public String calendar() {

		return "calendar";
	}
	
	//달력1 테스트용
	@PostMapping("/calendar")
	public String calendar2(HttpSession session, Model model) {
		
		//세션 정보가 없을 시 로그인페이지로 이동
		if((User)session.getAttribute("loginUser") == null) {
			return "user/login";
		}

		//세션 로그인 정보 추출
		User user = (User)session.getAttribute("loginUser");
		
		
		//대시보드 강좌 리스트
		List<Map<String, Object>> lectureList = mainDashService.getUserLectureList(user.getUserId(), user.getUserLevel());
		
		//대시보드 lms 공지사항 리스트
		List<LmsNotice> LmsNoticeList = lmsNoticeService.getLmsNoticeList();

			
		//넘겨주기
		model.addAttribute("lectureList", lectureList);
		model.addAttribute("lmsNoticeList", LmsNoticeList);
		
		
		return "index";
	}
	
	
	//달력2 테스트용
	@GetMapping("/calendar2")
	public String calendar3() {
		
		return "calendar2";
	}
	
	//달력2 테스트용
	@PostMapping("/calendar2")
	public String calendar4() {
		
		return "calendar2";
	}
}
