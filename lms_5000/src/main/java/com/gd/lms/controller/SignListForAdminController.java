package com.gd.lms.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.service.ISignListForAdminService;

import lombok.extern.slf4j.Slf4j;
	

@Slf4j
@Controller
public class SignListForAdminController {
	@Autowired ISignListForAdminService signListForAdminService;
	
	// 강좌 리스트 출력
	@GetMapping("sign/SignListForAdmin")
		public String slectureList(Model model){
			List<Map<String, Object>> slectureList = signListForAdminService.list();
		// 서비스에서 넘어온 값 확인
		log.debug(TeamColor.YHW + "-- lectureList - Controller--"+ slectureList );
		// 뷰로 넘길 값 model에 대입
		model.addAttribute("lectureList",slectureList);
		return "sign/SignListForAdmin";
	}
}
