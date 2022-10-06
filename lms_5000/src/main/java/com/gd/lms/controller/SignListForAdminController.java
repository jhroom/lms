package com.gd.lms.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gd.lms.commons.PageUtil;
import com.gd.lms.commons.TeamColor;
import com.gd.lms.service.ISignListforAdminService;
import com.gd.lms.vo.Sign;
import com.gd.lms.vo.SignCancel;

import lombok.extern.slf4j.Slf4j;
	

@Slf4j
@Controller
public class SignListForAdminController {
	@Autowired ISignListforAdminService signListforAdminService;
	PageUtil PageUtil = new PageUtil();
	 
	// 강좌 리스트 출력
	@GetMapping("/sign/SignListForAdmin")
	public String selectureList(Model model,  @RequestParam(required=false, value="currentPage", defaultValue="1")int currentPage){
		// 페이징 변수
		Map<String, Object> pageVariable=PageUtil.pageVariable(currentPage, signListforAdminService.getTotal());
		// 강좌 갯수
		List<Map<String, Object>> lectureList = signListforAdminService.StudentSignList((int)pageVariable.get("beginRow"),(int)pageVariable.get("rowPerPage"));
		
		// 서비스에서 넘어온 값 확인
		log.debug(TeamColor.YHW + "-- lectureList - Controller--"+ lectureList );
		// 강좌 넘기기
		model.addAttribute("lectureList",lectureList);
		//페이징 넘겨주는 값
	 	  model.addAttribute("pages",pageVariable.get("pages"));
	 	  model.addAttribute("currentPage",pageVariable.get("currentPage"));
	 	  model.addAttribute("realLastPage",pageVariable.get("realLastPage"));
	 	 // 포워딩
		return "/sign/SignListForAdmin";
	}
	
	// 각 강좌 별 수강 신청 리스트 , 과목 정보
	@GetMapping("/sign/SignListByLecture")
	public String SignList(Sign sign, Model model) {
		List<Map<String, Object>> getStudentList = signListforAdminService.getStudentListByLecture(sign);
		List<Map<String, Object>> sbInfo = signListforAdminService.getSubjectInfo();
		// 리스트 확인
		log.debug(TeamColor.YHW + "-- 학생정보 - Controller--"+ getStudentList );
		// 강좌 정보
		log.debug(TeamColor.YHW + "-- 과목정보 - Controller--"+ sbInfo );
		// 뷰로 넘길 값 model에 대입
		model.addAttribute("getStudentList",getStudentList);
		model.addAttribute("sbInfo",sbInfo);
		return "/sign/SignListByLecture";
	}
	
	// 학생 수강상태 변경
	@PostMapping("/sign/SignListByLecture")
	public String modyfySignState(Sign sign, SignCancel signCancel, HttpSession session) {
		//파라미터 확인
		log.debug(TeamColor.KHJ + "파라미터값 확인 / sign : "+ sign );
		log.debug(TeamColor.KHJ + "파라미터값 확인 / signCancel : "+ signCancel );
		
		//돌아갈 구멍 만들기
		int lectureNo = sign.getLectureNo();
		
		int	signState = signListforAdminService.modifySignState(sign, signCancel);
		// 서비스에서 넘어온 값 확인
		log.debug(TeamColor.YHW + "-- signState - Controller--"+ signState );
		return "redirect:/sign/SignListByLecture?lectureNo="+lectureNo;
		
	}
}
