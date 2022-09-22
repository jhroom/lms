package com.gd.lms.service;

import java.util.List;
import java.util.Map;

import com.gd.lms.vo.MultiChoice;
import com.gd.lms.vo.Question;

public interface ITestService {
	// 시험과목 리스트 
	List<Map<String, Object>> testLecture();
	
	//강좌별 시험 리스트 생성 기능
	List<Map<String, Object>> getTestList(int lectureNo);
	
	//시험별 문제 리스트 생성 기능
	List<Question> getTestQuestionList(int testNo);
	
	//시험 별 문제 보기 리스트 생성 기능
	List<MultiChoice> getTestChoiceList();
	
	
	
}
