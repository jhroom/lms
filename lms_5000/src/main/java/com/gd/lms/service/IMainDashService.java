package com.gd.lms.service;

import java.util.List;

import java.util.Map;


import com.gd.lms.vo.Sign;

public interface IMainDashService {
	
	
	// 학생 lms에 수강중인 과목 리스트 출력
	List<Map<String, Object>> selectStudentSignList(Sign userId);
	
	// 교수/학생 강의 리스트 출력
	List<Map<String, Object>> getUserLectureList(String userId, int UserLevel);
	
}
