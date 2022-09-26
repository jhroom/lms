package com.gd.lms.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.service.ISignListforAdminService;
import com.gd.lms.vo.Sign;

import lombok.extern.slf4j.Slf4j;
	

@Slf4j
@Controller
public class SignListForAdminController {
	@Autowired ISignListforAdminService signListforAdminService;
	
	// 강좌 리스트 출력
	@GetMapping("/sign/SignListForAdmin")
		public String selectureList(Model model){
			List<Map<String, Object>> slectureList = signListforAdminService.StudentSignList();
		// 서비스에서 넘어온 값 확인
		log.debug(TeamColor.YHW + "-- lectureList - Controller--"+ slectureList );
		// 뷰로 넘길 값 model에 대입
		model.addAttribute("slectureList",slectureList);
		return "/sign/SignListForAdmin";
	}
	
	// 각 강좌 별 수강 신청 현황
	@GetMapping("/sign/SignListByLecture")
	public String SignList(Sign sign, Model model) {
		List<Map<String, Object>> getStudentList = signListforAdminService.getStudentListByLecture(sign);
		// 서비스에서 넘어온 값 확인
		log.debug(TeamColor.YHW + "-- getStudentList - Controller--"+ getStudentList );
		model.addAttribute("getStudentList",getStudentList);
		return "/sign/SignListByLecture";
		
	}
}
