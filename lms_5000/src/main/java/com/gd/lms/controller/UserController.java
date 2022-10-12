package com.gd.lms.controller;


import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.service.ILmsNoticeService;
import com.gd.lms.service.IMainDashService;
import com.gd.lms.service.IUserListService;
import com.gd.lms.service.IUserLoginService;
import com.gd.lms.vo.LmsNotice;
import com.gd.lms.vo.Major;
import com.gd.lms.vo.Position;
import com.gd.lms.vo.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class UserController {
	
	@Autowired IUserLoginService userLoginService;
	@Autowired IUserListService userListService;
	@Autowired IMainDashService mainDashService; //강좌 리스트 서비스
	@Autowired ILmsNoticeService lmsNoticeService; //공지사항 서비스
	
	//메인페이지
	@GetMapping("/index")
	public String index(HttpSession session, Model model) {
		
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
		
		//사이드바로 넘기기
		session.setAttribute("sidebarList", lectureList);
		
		
		return "index";
	}
	
	//로그인 페이지
	@GetMapping("/index/login")
	public String userLogin() {
		
		return "user/login";
	}
	
	//로그인 액션
	@PostMapping("/index/login")
	public String userLogin(Model model, HttpSession session, User user) {
		
		//디버깅
		log.debug(TeamColor.AJH + "로그인 페이지 파라미터 확인 : " + user  );
		
		//입력한 id ,pw로 서비스 호출
		User loginUser = userLoginService.getUserLogin(user);
		
		//디버깅
		log.debug(TeamColor.AJH + "세션저장될 값 확인 loginUser : " + loginUser );
		
		// id pw가 user정보에 없다면(로그인실패)시 실패메세지 알림
		if(loginUser == null) {
			model.addAttribute("errMsg","로그인 정보를 다시 확인해주세요");
			return "user/login";
		}
		// 유저 정보는 있지만 승인대기상태(N) 일 떄 메세지출력
		if("N".equals(loginUser.getUserActive())) {
			model.addAttribute("errMsg","승인 대기 상태입니다");
			return "user/login";
		}
		if("H".equals(loginUser.getUserActive())) {
			model.addAttribute("errMsg","휴먼 계정 입니다");
			return "user/restUser";
		}
		//마지막 로그인 날짜 업데이트
		userLoginService.modifyUserLastLogin(user.getUserId());
		
		// user 정보가 일치하고 계정 활성화(Y)인 계정에 세션부여
		session.setAttribute("loginUser", loginUser);
		
		return "redirect:/index";
	}
	
	@GetMapping("/index/restUser")
	public String restUser() {
		return "user/restUser";
	}
	
	@PostMapping("/index/restUser")
	public String resUserCheck(Model model, User user) {
		//디버깅
		log.debug(TeamColor.AJH + "휴면계정 페이지 파라미터 확인 : " + user  );
		//서비스호출
		String restUserId = userLoginService.getRestUserCheck(user);
		if(restUserId == null) {
			model.addAttribute("errMsg","잘못된 정보 입니다");
			return "user/restUser";
		} else {
			int row = userLoginService.modifyRestUserActive(user.getUserId());
			log.debug("휴면계정 활성화 결과 : " + row);
			model.addAttribute("errMsg","휴면 해제 처리되었습니다 다시 로그인해주세요");
		}
		
		return "user/login";
	}
	
	
	//로그아웃
	@GetMapping("/index/logout")			
	public String logout(HttpSession session) {			
		log.debug(TeamColor.AJH + "로그아웃 액션");
		
		// 세션 무효화			
		session.invalidate();			
					
		return "redirect:/index/login";			
	}
	
	// 운영자 가입 폼으로가기
	@GetMapping("/user/addAdmin")
	public String addUser(Model model) {
		List<Position> positionList = userLoginService.getPositionList();
		log.debug(TeamColor.AJH  + "직책 리스트 : " + positionList);
		model.addAttribute("positionList" ,positionList);
		
		return "user/addAdmin";
	}
	
	// 운영자 가입 액션
	@PostMapping("/user/addAdmin")
	public String addUser(Model model, User user, @RequestParam (value="positionNo") int positionNo) {
		
		log.debug(TeamColor.JCH + " addUser 파라미터 값 "+ user);
		
		//addUser 회원가입 페이지에서 입력한정보가 성공적으로 들어갔을 떄 로그인 폼, 확인메세지 출력
		if(userLoginService.addAdmin(user, positionNo)) {
			model.addAttribute("errMsg","회원가입 완료되었습니다");
			System.out.println("회원가입완료");
		}
		//회원가입 로직중 에러발생시 404페이지로 이동 추가 할 예정
		
		return "user/login";
	}
	
	// 학생,교수 가입 폼으로가기
	@GetMapping("/user/addUser")
	public String addStudent(Model model) {
		
		//회원가입시 학과리스트
		List<Major> majorList =  userLoginService.getMajorList();
		log.debug(TeamColor.AJH + "학과리스트 : " + majorList);
		model.addAttribute("majorList",majorList);
		
		return "user/addUser";
	}
	
	// 학생,교수 가입 액션
	@PostMapping("/user/addUser")
	public String addStudent(Model model, User user , @RequestParam (value="majorNo") int majorNo) {
		log.debug(TeamColor.AJH+"Student / Professro 파라미터 user 값 "+ user);
		log.debug(TeamColor.AJH+"Student / Professro 파라미터 majorNo 값 "+ majorNo);
		if(userLoginService.addStudentOrPro(user, majorNo)) {
			log.debug(TeamColor.AJH + "학생/교수 회원가입 성공");
			model.addAttribute("errMsg","회원가입 완료되었습니다");
		}
		return "user/login";
	}
	
	
	//회원가입시 아이디 중복체크
	@PostMapping("/user/idCheck")
	@ResponseBody
	public String userIdCkeck(@RequestParam (value="userId") String userId) {
		// 회원가입 id 정규표현식 영문이나 숫자로 4자 이상 10자이하
		String idReg = "^[A-za-z0-9]{4,10}$";
		log.debug(TeamColor.AJH + "아이디 중복검사 파라미터 값 : " + userId);
		
		boolean regResult = Pattern.matches(idReg, userId);
		log.debug(TeamColor.AJH + "아이디 표현식 결과 값 : " + regResult);
		if(!regResult) {
			return "false";
		}
		//Id 중복검사 서비스 호출
		if(userLoginService.getUserIdCheck(userId)) {
			log.debug(TeamColor.AJH + "아이디 중복검사 결과 값 : true" );
			return "true";
		}
		else {
			log.debug(TeamColor.AJH + "아이디 중복검사 결과 값 : false" );
			return "false";
		}
		
	}
	
		
}
