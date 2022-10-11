package com.gd.lms.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.service.IMypageService;
import com.gd.lms.vo.Paging;
import com.gd.lms.vo.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MypageController {
	
	@Autowired IMypageService mypageService;
	
	@GetMapping("/index/mypage")
	public String mypage(HttpSession session, Model model) {
		//사용자 정보가 없는 사람이 마이페이지 갈경우
		if(session.getAttribute("loginUser") == null) {
			model.addAttribute("errMsg","로그인 후 이용 가능합니다");
			return "index/login";
		}
		
		return "user/mypage";
	}
	
	@GetMapping("index/mypage/info")
	public String myInfo(String msg, HttpSession session, Model model) {
		
		//사용자 정보가 없는 사람이 마이페이지 갈경우
		if(session.getAttribute("loginUser") == null) {
			model.addAttribute("errMsg","로그인 후 이용 가능합니다");
			return "index/login";
		}
		LocalTime now = LocalTime.now();
		log.debug(TeamColor.AJH + "현재 시간 : " + now);
		//세션의 유저 아이디
		String userId = ((User)session.getAttribute("loginUser")).getUserId();
		//세션의 유저 레벨
		int userLevel = ((User)session.getAttribute("loginUser")).getUserLevel();
		
		// 유저의 가입정보 받아오기
		Map<String, Object> userInfo = mypageService.getUserInfo(userId, userLevel);
		
		// 디버깅
		log.debug(TeamColor.AJH + "userId의 가입정보 : "+ userInfo);
		
		model.addAttribute("userInfo", userInfo);
		
		//주소창 파라미터 값 뷰로 넘겨주기
		model.addAttribute("msg", msg);
		
		return "user/passwordCheck";
	}
	
	@GetMapping("index/mypage/pwCheck")
	public String passwordCheck(User user) {
		log.debug(TeamColor.AJH+"user 파라미터 : " + user);
		
		
		return "user/myInfo";
	}
	
	@PostMapping("index/mypage/pwCheck")
	public String passwordCheck(HttpSession session, Model model, User user) {
		log.debug(TeamColor.AJH + "파라미터 user : " + user);
		
		//사용자 정보가 없는 사람이 마이페이지 갈경우
		if(session.getAttribute("loginUser") == null) {
			model.addAttribute("errMsg","로그인 후 이용 가능합니다");
			return "index/login";
		}
		
		//입력한 비밀번호로 조회사 정보가 없다면 다시 확인 페이지로
		if(mypageService.getPasswordCheck(user)) {
			model.addAttribute("msg","비밀번호를 다시 확인해주세요");
			return "user/passwordCheck";
		}
		//세션의 유저 아이디
		String userId = ((User)session.getAttribute("loginUser")).getUserId();
		//세션의 유저 레벨
		int userLevel = ((User)session.getAttribute("loginUser")).getUserLevel();
		
		// 유저의 가입정보 받아오기
		Map<String, Object> userInfo = mypageService.getUserInfo(userId, userLevel);
		
		// 디버깅
		log.debug(TeamColor.AJH + "userId의 가입정보 : "+ userInfo);
		
		model.addAttribute("userInfo", userInfo);
		
		return "user/myInfo";
	}
	
	@PostMapping("index/mypage/changeUserInfo")
	public String modifyUserInfo(HttpSession session, @RequestParam (value="userInfo") String userInfo) throws UnsupportedEncodingException {
		log.debug(TeamColor.AJH+"유저정보번경 메서드 파라미터 : " + userInfo);
		
		//세션에 저장된 UserInfo 의 아이디
		String userId = ((User)session.getAttribute("loginUser")).getUserId();
		int userLevel = ((User)session.getAttribute("loginUser")).getUserLevel();
		
		Map<String, Object> map = new HashMap<>();
		map.put("userInfo", userInfo);
		map.put("userLevel", userLevel);
		map.put("userId", userId);
		
		int result = mypageService.modifyUserInfo(map);
		String msg = null;
		
		if(result != 1) {
			return "index/mypage/info";
		}
		msg = "정보가 변경 되었습니다";
		
		String encodedParam = URLEncoder.encode(msg, "UTF-8"); 
		//index 뷰페이지 msg 출력 추가해야함
		
		return "redirect:/index/mypage/info?msg="+encodedParam;
	}
	// 마이페이지 글쓴 목록 페이지
	@GetMapping("index/mypage/postList")
	public String myPostList(HttpSession session, Model model, Paging paging,
			@RequestParam(value="nowPage", required=false) Integer paramNowPage,
			@RequestParam(value="rowPerPage", required=false) Integer ParamRowPerPage) {
		
		//현재 페이지나 페이지당 보여줄 개수가 있다면 셋팅
		if(paramNowPage != null) {
			paging.setNowPage(paramNowPage);
		}
		if(ParamRowPerPage != null) {
			paging.setRowPerPage(ParamRowPerPage);
		}
		paging.setUserId( ((User)session.getAttribute("loginUser")).getUserId() );
		int userLevel = ((User)session.getAttribute("loginUser")).getUserLevel();
		
		log.debug(TeamColor.AJH + "파라미터 nowPage : " + paging.getNowPage());
		log.debug(TeamColor.AJH + "파라미터 rowPerPage : " + paging.getRowPerPage());
		
		//게시글 리스트
		List<Map<String, Object>> boardList = mypageService.getboardWriteList(userLevel, paging);
		log.debug(TeamColor.AJH + "게시글 리스트 값 : " + boardList.toString());
		model.addAttribute("boardList", boardList);
		
		//현재 페이지와 페이지당 출력할 줄 개수로 페이징 서비스 처리하기
		Paging getPaging = mypageService.getPostCount(userLevel, paging);
		log.debug(TeamColor.AJH + "서비스결과 Paging : " + getPaging.toString());
		model.addAttribute("pg",getPaging);
		
		return "user/postList";
	}
	
	// 마이페이지 댓글 목록 페이지
	@GetMapping("index/mypage/commentList")
	public String myCommentList(HttpSession session, Model model, Paging paging,
			@RequestParam(value="nowPage", required=false) Integer paramNowPage,
			@RequestParam(value="rowPerPage", required=false) Integer ParamRowPerPage) {
		
		//현재 페이지나 페이지당 보여줄 개수가 있다면 셋팅
		if(paramNowPage != null) {
			paging.setNowPage(paramNowPage);
		}
		if(ParamRowPerPage != null) {
			paging.setRowPerPage(ParamRowPerPage);
		}
		//세션아이디 부여
		paging.setUserId( ((User)session.getAttribute("loginUser")).getUserId() );
		
		//댓글 리스트
		List<Map<String, Object>> commentList = mypageService.getCommentWriteList(paging);
		log.debug(TeamColor.AJH + "댓글 리스트 값 : " + commentList.toString());
		model.addAttribute("commentList", commentList);
		
		//댓글 리스트 페이징
		Paging getPaging = mypageService.getCommentCount(paging);
		log.debug(TeamColor.AJH + "서비스결과 Paging : " + getPaging.toString());
		model.addAttribute("pg",getPaging);
		
		return "user/commentList";
	}
	
	@PostMapping("rest/pwCheck")
	@ResponseBody
	public int pwCheck(Model model, User user) {
		log.debug("파라미터 값 확인 : " + user.getUserId() + " " + user.getUserPw());
		// 현재 비밀번호가 db에있는 user id의 pw가 일치하면 1 틀리면 0
		User result = mypageService.getPwCheck(user);
		
		if( result != null) {
			log.debug("db결과 값 확인 : " + result);
			return 1;
		}
		return 0;
	}
	@PostMapping("index/mypage/updatePw")
	public String updatePw(User user, @RequestParam (value="userPw1") String userPw1) {
		
		log.debug("뷰에서 넘어온 파라미터 값 확인 : " + user + " " + userPw1);
		// 변경할 비밀번호를 user 객체에
		user.setUserPw(userPw1);
		
		int result = mypageService.modifyUserPw(user);
		log.debug("db결과 확인 : " + result);
		
		return "redirect:/index/login";
	}

}
