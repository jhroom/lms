package com.gd.lms.service;

import java.util.List;
import java.util.Map;

import com.gd.lms.vo.MultiChoice;
import com.gd.lms.vo.Question;
import com.gd.lms.vo.Test;

public interface ITestService {

	
	//강좌별 시험 리스트 생성 기능
	List<Map<String, Object>> getTestList(int userLv,String userId, int lectureNo);
	
	//시험별 문제 리스트 생성 기능
	List<Question> getTestQuestionList(int testNo);
	
	//시험 별 문제 보기 리스트 생성 기능
	List<MultiChoice> getTestChoiceList(int testNo);
	
	//시험 추가 기능
	int addTest(Test test, Question question, MultiChoice multichoice);
	
	//시험 응시 여부 확인 기능
	boolean testCheck(String userId, int testNo);
	
	//학생 답안지 제출 기능
	int testSubmit(String userId, int testNo, int [] answers, int [] questions);
	
	//시험 응시 학생 리스트 생성 기능
	List<Map<String, Object>> getTestStudnet(int lectureNo, int testNo);
	
	//전체 학생 채점 기능
	int updateScore(int testNo);
	
	//수정용 문제 선택 기능
	List<Map<String, Object>> getTestModifyForm(int questionNo);
	
	//문제 수정 기능
	int modifyQuestion(String [] choiceContents, Question question);
	
	//학생 수강 여부 확인
	int getSignNo(String uesrId, int lectureNo);
	
	//교수 아이디 확인
	String getProId(int lectureNo);

}
