package com.gd.lms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LectureDashBoad {
	
	@GetMapping("/stdashboard/lectureDashBoard")
	public String lectureBoardList() {
		
		return "/stdashboard/lectureDashBoard";
	}
}
