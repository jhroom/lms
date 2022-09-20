package com.gd.lms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*
 * 템플릿으로 보내주는 컨트롤러
 * 포폴 완성시 지워야함!
 */

@Controller
public class TempController {
	
	@GetMapping("/starter")
	public String temp() {
		
		return "/template/starter";
	}
	
	@GetMapping("/index1")
	public String temp1() {
		
		return "/template/index";
	}
	
	@GetMapping("/index2")
	public String temp2() {
		
		return "/template/index2";
	}
	
	@GetMapping("/index3")
	public String temp3() {
		
		return "/template/index3";
	}
	
	
}
