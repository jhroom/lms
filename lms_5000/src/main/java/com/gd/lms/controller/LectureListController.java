package com.gd.lms.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gd.lms.service.LectureService;

@Controller
public class LectureListController {
  @Autowired LectureService lectureService;
	
  @GetMapping ("/openLectureList")
   public String selectLectureListForSign(Model model) {
	  List<Map<String,Object>> lectureList = lectureService.selectLectureListForSign();
	  System.out.println("selectLectureListForSign controller 은 : "+lectureList);
	  model.addAttribute("lectureList",lectureList);
	  System.out.println("why?");
      return "openLectureList";
   }
}
