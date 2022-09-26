package com.gd.lms.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.mapper.TestMapper;
import com.gd.lms.vo.MultiChoice;
import com.gd.lms.vo.Question;
import com.gd.lms.vo.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TestService implements ITestService {
	@Autowired TestMapper testMapper;
	@Override
	// 시험 볼 과목 리스트
	public List<Map<String, Object>> testLecture() {
		List<Map<String,Object>> testLecture = testMapper.selectTestLecture();
		//디버깅
		log.debug(TeamColor.YHW + "-- testLecture -controller --    "+ testLecture );
		return testLecture;
	}
	
	//강좌별 시험 리스트 생성 메서드 
	@Override
	public List<Map<String, Object>> getTestList(int userLv, String userId, int lectureNo) {
		//파라미터 값 확인 디버깅
		log.debug(TeamColor.KHJ + "파라미터 값 확인 리스트 lectureNo : "+ lectureNo );
		log.debug(TeamColor.KHJ + "파라미터 값 확인 리스트 userLv : "+ userLv );
		

		//리턴값 세팅
		List<Map<String,Object>> list = null;
		
		//유저가 학생일 경우
		if(userLv == 3) {
		
		//수강 정보 확인
		int signNo = testMapper.selectSignNo(userId, lectureNo);
		
		
		//리턴 값 세팅
		list = testMapper.selectTestList(lectureNo, signNo);
		
		//리턴
		return list;
		
		//유저가 학생이 아닐 경우
		} else if(userLv != 3) {
			
			//리턴 값 세팅
			list = testMapper.selectTestListAdmin(lectureNo);
			
			//리턴
			return list;
			
		}
		
		return list;
	}

	//시험별 문제 리스트 생성 메서드
	@Override
	public List<Question> getTestQuestionList(int testNo) {
		//파라미터 값 확인 디버깅
		log.debug(TeamColor.KHJ + "파라미터 값 확인 리스트 testNo : "+ testNo );
		
		//리턴 값 세팅
		List<Question> list = testMapper.selectTestQuestion(testNo);
				
		//리턴
		return list;
	}

	//시험별 보기 리스트 생성 메서드
	@Override
	public List<MultiChoice> getTestChoiceList(int testNo) {
		
		//리턴 값 세팅
		List<MultiChoice> list = testMapper.selectTestChoice(testNo);
				
		//리턴
		return list;
	}

	//시험 추가 메서드
	@Override
	public int addTest(Test test, Question question, MultiChoice multichoice) {
		//파라미터 값 확인 디버깅
		log.debug(TeamColor.KHJ + "파라미터 값 확인 리스트 test : "+ test );
		log.debug(TeamColor.KHJ + "파라미터 값 확인 리스트 question : "+ question );
		log.debug(TeamColor.KHJ + "파라미터 값 확인 리스트 multichoice : "+ multichoice );
		
		//배열값 추출
		String [] questionContents = question.getQuestionContents();
		int [] questionAnswers = question.getQuestionAnswers();
		String [] choiceContents = multichoice.getChoiceContents();
		
		//반복문을 위한 배열 생성
		int [] arr = new int [questionAnswers.length];
		
		//배열값 세팅
		for(int i = 0 ; i<questionAnswers.length;i++) {
			arr[i] = i;
		}
		
		
		//배열 값 확인 디버깅
		log.debug(TeamColor.KHJ + "배열 값 확인 리스트 questionContents : "+ Arrays.toString(questionContents) );
		log.debug(TeamColor.KHJ + "배열 값 확인 리스트 questionAnswers : "+ Arrays.toString(questionAnswers) );
		log.debug(TeamColor.KHJ + "배열 값 확인 리스트 choiceContents : "+ Arrays.toString(choiceContents));
		log.debug(TeamColor.KHJ + "배열 값 확인 리스트 arr : "+ Arrays.toString(arr) );
				
		
		
		
		//시험 추가
		int row = testMapper.insertTest(test);
		
		//디버깅
		log.debug(TeamColor.KHJ + "시험 쿼리 실행 값 확인 row  : "+ row );
		
		//시험 번호 변수 설정
		int testNo = test.getTestNo();
		

		
		for(int a : arr) {
			
			//시험 문제 객체 세팅
			Question temp = new Question();
			temp.setQuestionContent(questionContents[a]);
			temp.setQuestionAnswer(questionAnswers[a]);
			temp.setTestNo(testNo);
			
			//시험문제 쿼리 실행
			int row2 = testMapper.insertTestQuestion(temp);
			
			//디버깅
			log.debug(TeamColor.KHJ + "시험 문제 쿼리 실행 값 확인 row2  : "+ row2 );
			
			
			//문제 번호 변수 설정
			int qustionNo = temp.getQuestionNo();
			
			//for문 실행을 위한 시작 변수 설정
			int startInt = a * 4;
			
			//문제 번호 입력을 위한 변수
			int cn = 1;
			
			
			//문제 입력
			for(int i = startInt;i<startInt+4;i++) {
				
				
				//객체 설정
				MultiChoice temp2 = new MultiChoice();
				temp2.setChoiceContent(choiceContents[i]);
				temp2.setQuestionNo(qustionNo);
				temp2.setChoiceNo(cn);
				
				//문제 보기 입력 입력
				int row3 = testMapper.insertTestChoice(temp2);
				
				//디버깅
				log.debug(TeamColor.KHJ + "시험 쿼리 실행 값 확인 row3  : "+ row3 );
				
				//보기 번호 추가
				cn++;

			}
			
		}
		
		
		
		
		return 0;
	}

	//학생 시험 응시여부 확인 기능
	@Override
	public boolean testCheck(String userId, int testNo) {
		//파라미터 값 확인 디버깅
		log.debug(TeamColor.KHJ + "파라미터 값 확인 리스트 userId : "+ userId );
		log.debug(TeamColor.KHJ + "파라미터 값 확인 리스트 TestNo : "+ testNo );
		
		//리턴값 세팅
		boolean result = false;
		
		//확인 실행
		int row = testMapper.selectTestCheck(userId, testNo);
		
		if(row > 0) {
			result = true;
		}
		
		return result;
	}

	//학생 답안 제출 기능
	@Override
	public int testSubmit(String userId, int testNo, int[] answers, int[] questions) {
		//파라미터 값 확인 디버깅
		log.debug(TeamColor.KHJ + "파라미터 값 확인 리스트 userId : "+ userId );
		log.debug(TeamColor.KHJ + "파라미터 값 확인 리스트 TestNo : "+ testNo );
		log.debug(TeamColor.KHJ + "파라미터 값 확인 리스트 answers : "+ Arrays.toString(answers) );
		log.debug(TeamColor.KHJ + "파라미터 값 확인 리스트 questions : "+ Arrays.toString(questions) );
		

		//리턴 값 선언
		int row = 0;
		
		//학생의 수강 번호 불어오기
		int signNo = testMapper.selectSignNo(userId, testNo);
		
		
		//반복문 배열 생성
		int [] arr = new int[questions.length];
		
		//반복문 배열 
		for(int i = 0; i<arr.length;i++) {
			arr[i] = i;
		}
		
		//파라미터 값 확인 디버깅
		log.debug(TeamColor.KHJ + "파라미터 값 확인 리스트 userId : "+ userId );
				
		
		//반복문 돌리기
		for(int a : arr) {
			row += testMapper.insertAnswer(answers[a], questions[a], signNo);
		}
		
		//파라미터 값 확인 디버깅
		log.debug(TeamColor.KHJ + "결과 값 확인 리스트 row : "+ row );
				
		return row;
	}

	@Override
	public List<Map<String, Object>> getTestStudnet(int lectureNo, int testNo) {
		
		//파라미터 값 확인 디버깅
		log.debug(TeamColor.KHJ + "파라미터 값 확인 리스트 lectureNo : "+ lectureNo );
		log.debug(TeamColor.KHJ + "파라미터 값 확인 리스트 testNo : "+ testNo );
				
		
		//값 세팅
		List<Map<String, Object>> list = testMapper.selectTestStudnet(lectureNo, testNo);
		
		
		//리턴
		return list;
	}

	@Override
	public int updateScore(int testNo) {
		
		//파라미터 값 확인 디버깅
		log.debug(TeamColor.KHJ + "파라미터 값 확인 리스트 testNo : "+ testNo );
				
		
		//쿼리 실행
		int row = testMapper.updateTestScoreCorrect(testNo);
		row =+ testMapper.updateTestScoreWrong(testNo);
		
		//리턴
		return row;
	}

	@Override
	public List<Map<String, Object>> getTestModifyForm(int questionNo) {
		//파라미터 값 확인 디버깅
		log.debug(TeamColor.KHJ + "파라미터 값 확인 리스트 questionNo : "+ questionNo );
		
		//쿼리 실행		
		List<Map<String, Object>> list = testMapper.selectTestModifyForm(questionNo);
		
		
		return list;
	}

	@Override
	public int modifyQuestion(String []  choiceContents, Question question) {
		//파라미터 값 확인 디버깅
		log.debug(TeamColor.KHJ + "파라미터 값 확인 리스트 choiceContents : "+ choiceContents );
		log.debug(TeamColor.KHJ + "파라미터 값 확인 리스트 question : "+ question );
				
		
		//문제 수정 쿼리 실행
		int row = testMapper.updateQuestion(question);
		
		//문제 번호 추출
		int qusetionNo = question.getQuestionNo();
		
		for(int i = 0;i<4;i++) {
			//임시 객체 생성
			MultiChoice temp = new MultiChoice();
			temp.setQuestionNo(qusetionNo);
			temp.setChoiceNo(i+1);
			temp.setChoiceContent(choiceContents[i]);
			
			//임시 객체 디버깅
			log.debug(TeamColor.KHJ + "임시 객체 값 확인 리스트 temp : "+ temp );
			
			//객체
			row += testMapper.updateMultiChoice(temp);
		}
		
		//리턴
		return row;
	}

}
