package com.gd.lms.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gd.lms.vo.MultiChoice;
import com.gd.lms.vo.Question;
import com.gd.lms.vo.Test;

@Mapper
public interface TestMapper {
	// 시험볼 과목 리스트
	List<Map<String, Object>> selectTestLecture();
	
	
	//강좌 시험 리스트 생성 쿼리
	List<Map<String, Object>> selectTestList(int lectureNo, int signNo);
	
	//시험문제 생성 쿼리
	List<Question> selectTestQuestion(int testNo);
	
	//시험 문제 보기 리스트 생성 쿼리
	List<MultiChoice> selectTestChoice(int testNo);
	
	//시험 추가 쿼리
	int insertTest(Test test);
	
	//시험 문제 추가 쿼리
	int insertTestQuestion(Question question);
	
	//시험 보기 추가 쿼리
	int insertTestChoice(MultiChoice multichoice);
	
	//시험 응시 여부 확인 쿼리
	int selectTestCheck(String userId, int TestNo);
	
	//학생 수강번호 추출 쿼리
	int selectSignNo(String userId, int testNo);
	
	//학생 답안지 제출 쿼리
	int insertAnswer(int answerSelect, int questionNo, int signNo);
	
	//시험 응시 학생 리스트 생성 쿼리
	List<Map<String, Object>> selectTestStudnet(int lectureNo, int testNo);
	
	//응시 학생 전체 채점 쿼리
	int updateTestScore();
	
		
}
