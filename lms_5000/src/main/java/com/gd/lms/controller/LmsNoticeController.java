package com.gd.lms.controller;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.service.ILmsNoticeService;
import com.gd.lms.service.IMypageService;
import com.gd.lms.vo.LmsNotice;
import com.gd.lms.vo.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LmsNoticeController {
	@Autowired ILmsNoticeService lmsNoticeService;
	@Autowired IMypageService mypageService;
	
	// 공지 리스트
	@GetMapping("/lmsNotice/LmsNoticeList")
	public String getLmsNoticeList(Model model) {
		
//		//페이징
//		int startPage=0;
//		int endPage=0;
//		
//		//마지막 페이지 구하기
//		int realEndPage = lmsNoticeService.getRealEndPage(lmsNoticeNo); 
//		
//		if(realEndPage%2==0) {
//			realEndPage = realEndPage/2;
//		} else {
//			realEndPage = realEndPage/2+1;
//		}
//		
//		// 페이지가 0보다 작으면 1로
//		if(currentPage <= 0) {
//			currentPage =1;
//		}
//		
//		//현 페이지가 마지막 페이지보다 크면 마지막 페이지로
//		if(currentPage >= realEndPage) {
//			currentPage = realEndPage;
//		}
//		
//		int startNo = currentPage * 2 - 2;
//		
//		startPage = currentPage / 2 * 2 + 1;
//		endPage = startPage+10;
//		
//		//마지막 페이지 세팅
//		if(endPage > realEndPage) {endPage=realEndPage;}
//		
//		//넘겨줄 배열값 세팅
//		int [] pages = new int[endPage - startPage+1];
//		
//		for(int i=0; i<pages.length; i++) {
//			pages[i] = startPage + i;
//		}
//		
//		//페이징 디버깅
//		log.debug(TeamColor.SSH + "startPage: " + startPage);
//		log.debug(TeamColor.SSH + "endPage" + endPage);
//		log.debug(TeamColor.SSH + "realEndPage" + realEndPage);
//		log.debug(TeamColor.SSH + "startNo : " + startNo);
//		log.debug(TeamColor.SSH + "pages : " + Arrays.toString(pages));
		
		
		
		//리스트 불러오기
		List<LmsNotice> LmsNoticeList = lmsNoticeService.getLmsNoticeList();
		model.addAttribute("lmsNoticeList", LmsNoticeList);
//		model.addAttribute("lmsNoticeNo", lmsNoticeNo);
//		model.addAttribute("currentPage", currentPage);
		
		return "/lmsNotice/LmsNoticeList";
		
	}

	//공지 추가
	@GetMapping("/lmsNotice/LmsNoticeAddBoard")
	public String LmsNoticeAddBoard(HttpSession session, Model model) throws Exception {
		
		// 이름값 세션으로 가져오기
		String userId = ((User)session.getAttribute("loginUser")).getUserId();
		String userName=((User)session.getAttribute("loginUser")).getUserName();
		
		// 잘 가지고 왔지? 디버깅
		log.debug(TeamColor.SSH + "userId : " + userId);
		log.debug(TeamColor.SSH + "userName : " + userName);
		
		// model로 구현
		model.addAttribute("userId", userId);
		model.addAttribute("userName", userName);
		
		return "/lmsNotice/LmsNoticeAddBoard";
		
	}
	
	
	
	
	//공지 추가 액션
	@PostMapping("/lmsNotice/LmsNoticeAddBoard//add")
	public String LmsNoticeAddboard(LmsNotice lmsNotice, MultipartFile[] lmsFile, HttpServletRequest request) throws UnsupportedEncodingException {
		
		//디버깅
		log.debug(TeamColor.SSH + "공지작성 : " + lmsNotice);
		log.debug(TeamColor.SSH + "파일확인 : " + lmsFile);
		
		
		
		
		lmsNoticeService.LmsAddNotice(lmsNotice, lmsFile, request);
			
		return "redirect:/lmsNotice/LmsNoticeList";
		
	}
	
	//공지 상세보기
	@GetMapping("/lmsNotice/LmsNoticeOne")
	public String getselectLmsNoticeOne(int lmsNoticeNo, String lmsNoticeTitle, Model model) {
		
	Map<String, Object> noticeOne = lmsNoticeService.getLmsNoticeOne(lmsNoticeNo);
	
	//이거 하나로 다 받아오고 있다.
	model.addAttribute("noticeOne", noticeOne);
	
	//수정 삭제를 위해서 이게 필요하다.
	model.addAttribute("lmsNoticeNo", lmsNoticeNo);
	model.addAttribute("lmsNoticeTitle", lmsNoticeTitle);
	
	log.debug(TeamColor.SSH + "값 확인/noticeOne" + noticeOne);
	log.debug(TeamColor.SSH + "결과확인 / 포워딩");
	
	
	return "lmsNotice/LmsNoticeOne";
	
	}
	
	//공지 삭제
	@GetMapping("/lmsNotice/deleteLmsNotice")
	public String deleteLmsNotice(int lmsNoticeNo) {
		int row = lmsNoticeService.deleteLmsNotice(lmsNoticeNo);
		
		//디버깅
		log.debug(TeamColor.SSH+ "삭제되는 값 :" + row);
		
		return "redirect:/lmsNotice/LmsNoticeList";
	}
	
	
	//공지 수정
	@GetMapping("/lmsNotice/UpdateLmsNotice/form")
	public String updateLmsNotice(int lmsNoticeNo,  Model model) {
		
		//lmsNoticeNo의 해당하는 One을 가지고온다.
		Map<String, Object> noticeOne = lmsNoticeService.getLmsNoticeOne(lmsNoticeNo);
		
		
		
		//받아온 값 출력
		model.addAttribute("noticeOne", noticeOne);
		model.addAttribute("lmsNoticeNo", lmsNoticeNo);
		
		
		//결과 디버깅
		log.debug(TeamColor.SSH + "넘겨주기 :" +noticeOne);
		log.debug(TeamColor.SSH + "게시판수정으로 가렴");
		
		return "lmsNotice/UpdateLmsNotice";
	}
	
 
	//수정 액숀
	@PostMapping("/lmsNotice/updateLmsNotice")
	public String updateLmsNotice(LmsNotice lmsNotice) throws UnsupportedEncodingException  {
		
		//디버깅
		log.debug(TeamColor.SSH + "번경 값 : " + lmsNotice);
//		log.debug(TeamColor.SSH + "제목수정 : " + lmsNoticeNo);
//		log.debug(TeamColor.SSH + "내용수정 : " + lmsNoticeContent);
		
	int row = lmsNoticeService.updateLmsNotice(lmsNotice);
		
		
		
		return "redirect:/lmsNotice/LmsNoticeList";
		
		
	}
	
	//파일 다운로드
	@GetMapping("lmsNotice/downloadFile")
	public ResponseEntity<Object> downloadFile(String fileName, int lmsNoticeNo, HttpServletRequest request) throws UnsupportedEncodingException{
		
		//파일 경로
		String realPath = request.getSession().getServletContext().getRealPath("/lmsFile/file") + "\\"+ fileName;
		
		//디버깅
		log.debug(TeamColor.SSH+ "값 확인 / realPath: " + realPath);
		
		//리턴값 세팅
		ResponseEntity<Object> returnVal = lmsNoticeService.douwnloadFile(fileName, realPath);
		
		//디버깅
		log.debug(TeamColor.SSH + "값 확인 / returnVal: " + returnVal);
		
		return returnVal;
	
}
}
