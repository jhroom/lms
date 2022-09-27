package com.gd.lms.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gd.lms.vo.MultiChoice;
import com.gd.lms.vo.Question;
import com.gd.lms.vo.Test;

@Mapper
public interface TestMapper {

	
	//강좌 시험 리스트 생성 쿼리_학생
	List<Map<String, Object>> selectTestList(int lectureNo, int signNo);
	
	//강좌 시험 리스트 생성 쿼리_운영자
	List<Map<String, Object>> selectTestListAdmin(int lectureNo);
	
	
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
	
	//testNo로 학생 수강번호 추출 쿼리
	int selectSignNoByTest(String userId, int testNo);
	
	//lectureNo로 학생 수강번호 추출 쿼리
	int selectSignNoByLecture(String userId, int lectureNo);
	
	//교수 여부 확인 쿼리
	String selectPro(int lectureNo);
		
	
	//학생 답안지 제출 쿼리
	int insertAnswer(int answerSelect, int questionNo, int signNo);
	
	//시험 응시 학생 리스트 생성 쿼리
	List<Map<String, Object>> selectTestStudnet(int lectureNo, int testNo);
	
	//응시 학생 전체 채점 쿼리_정답 처리
	int updateTestScoreCorrect(int testNo);
	
	//응시 학생 전체 채점 쿼리_오답 처리
	int updateTestScoreWrong(int testNo);
	
	
	//수정 폼을 위한 선택 쿼리
	List<Map<String, Object>> selectTestModifyForm(int questionNo);
	
	//문제 수정 쿼리
	int updateQuestion(Question question);
	
	//보기 수정 쿼리
	int updateMultiChoice(MultiChoice multichoice);
		
}
