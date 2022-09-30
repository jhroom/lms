package com.gd.lms.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.service.INewLectureService;
import com.gd.lms.service.ISemeterService;
import com.gd.lms.service.ISubjectService;
import com.gd.lms.vo.Lecture;
import com.gd.lms.vo.Professor;
import com.gd.lms.vo.Semester;
import com.gd.lms.vo.Subject;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class NewLectureController {
	  @Autowired INewLectureService newlectureService;
	  @Autowired ISubjectService subjectService;
	  @Autowired ISemeterService semesterService;
	
	// 강의 리스트
	   @GetMapping("lmsLecture/LectureList")
	   public String getLectureList(Model model) {
		   
		   //리스트 불러오기
		   List<Lecture> LectureList = newlectureService.getLectureList();
		   //구현
		   model.addAttribute("LectureList", LectureList);
		   //디버깅
		   log.debug(TeamColor.SSH + "강의 리스트 : " + LectureList);
		   
		   //subject 값 가지고오기
		   List<Subject> getSubjectList = subjectService.getSubjectList();
		   //리스트 구현
		   model.addAttribute("getSubjectList", getSubjectList);
		   //디버깅
		   log.debug(TeamColor.SSH + "강좌리스트 : " + getSubjectList);
		  
		   //교수 리스트 가져오기
		   List<Professor> getProList = newlectureService.getProList();
		   //리스트 구현
		   model.addAttribute("getProList", getProList);
		   //디버깅
		   log.debug(TeamColor.SSH + "교수 리스트 : " + getProList);
		   
		   //학기 값 가져오기
		   List<Semester> getSemesterList = semesterService.getSemesterList();
		   model.addAttribute("getSemesterList", getSemesterList);
		   log.debug(TeamColor.SSH + "학기 리스트 : " + getSemesterList);
		   
		   return "/lecture/LectureList";
	   }
	 
	   // 강의 추가
	   @GetMapping("lmsLecture/addLecture")
	   public String addLecture(Model model) {
		   
		   //subject 값 가지고오기
		   List<Subject> getSubjectList = subjectService.getSubjectList();
		   //리스트 구현
		   model.addAttribute("getSubjectList", getSubjectList);
		   //디버깅
		   log.debug(TeamColor.SSH + "강좌리스트 : " + getSubjectList);
		  
		   //교수 리스트 가져오기
		   List<Professor> getProList = newlectureService.getProList();
		   //리스트 구현
		   model.addAttribute("getProList", getProList);
		   //디버깅
		   log.debug(TeamColor.SSH + "교수 리스트 : " + getProList);
		   
		   //학기 값 가져오기
		   List<Semester> getSemesterList = semesterService.getSemesterList();
		   model.addAttribute("getSemesterList", getSemesterList);
		   log.debug(TeamColor.SSH + "학기 리스트 : " + getSemesterList);
		   
		   
		return "/lecture/addLecture";
		   
	   }
	   
	   // 강의 추가 액션
	   @GetMapping("/lmsLecture/addLecture/add")
	   public String addLecture(Lecture lecture) {
		   
		   newlectureService.addLecture(lecture);
		   
		   log.debug(TeamColor.SSH + "강의 추가 : " + lecture);
		   
		   return "redirect:/lmsLecture/LectureList";
	   }
	   
	   // 강의 상세보기
	   @GetMapping("/lmsLecture/lectureOne")
	   public String getselectLectureOne(int lectureNo, Model model) {
		   
		   //상세값 가져오기
		   Map<String, Object> lectureOne = newlectureService.getLectureOne(lectureNo);
		   //subject 가져오기
		   List<Subject> getSubjectList = subjectService.getSubjectList();
		   //professor 가져오기
		   
		   model.addAttribute("lectureOne", lectureOne);
		   model.addAttribute("getSubjectList", getSubjectList);
		   //model.addAttribute("lectureDay", lectureDay);
		   
		   
		   
//		   String lectureDays=Integer.toString(lectureDay);
//		   
//		   switch (lectureDays) {
//		  case "1":
//			lectureDay="월";
//			break;
//		  case "2":
//			lectureDay="화";
//			break;
//		  case "3":
//			lectureDay="수";
//			break;
//		  case "4":
//			lectureDay="목";
//			break;
//		  case "5":
//			lectureDay="금";
//			break;
//		
//		}
		   
		   
		   
		   
		   return "lecture/LectureOne"; 
	   }
	   
	   //강의 수정 폼
	   @GetMapping("/lmsLecture/updateLecture/form")
	   public  String updateLecture(int lectureNo, Model model) {
		   //먼저 상세값을 가지고 오기
		   Map<String, Object> lectureOne = newlectureService.getLectureOne(lectureNo);
		   //값 구현
		   model.addAttribute("lectureOne", lectureOne);
		   //디버깅
		   log.debug(TeamColor.SSH + "수정 넘겨주기 : " + lectureOne);
		   
		   
		   //교수 리스트 가져오기
		   List<Professor> getProList = newlectureService.getProList();
		   //리스트 구현
		   model.addAttribute("getProList", getProList);
		   //디버깅
		   log.debug(TeamColor.SSH + "교수 리스트 : " + getProList);
		   
		   //학기 값 가져오기
		   List<Semester> getSemesterList = semesterService.getSemesterList();
		   model.addAttribute("getSemesterList", getSemesterList);
		   log.debug(TeamColor.SSH + "학기 리스트 : " + getSemesterList);
		   
		   //강좌 값 가져오기
		   List<Subject> getSubjectList = subjectService.getSubjectList();
		   //리스트 구현
		   model.addAttribute("getSubjectList", getSubjectList);
		   //디버깅
		   log.debug(TeamColor.SSH + "강좌리스트 : " + getSubjectList);
		   log.debug(TeamColor.SSH + "게시판 수정으로 가세요.");
		  
		   
		   
		   return "lecture/updateLecture";
	   }
	   
	   
	   
	   
	   
	   
	   
	   
	   
}
