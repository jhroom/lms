package com.gd.lms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CalendarController {

	//달력1 테스트용
	@GetMapping("/calendar")
	public String calendar() {
		
		return "calendar";
	}
	
	//달력1 테스트용
	@PostMapping("/calendar")
	public String calendar2() {
		
		return "calendar";
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
