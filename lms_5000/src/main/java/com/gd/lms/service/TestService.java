package com.gd.lms.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.mapper.TestMapper;
import com.gd.lms.vo.MultiChoice;
import com.gd.lms.vo.Question;

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
	public List<Map<String, Object>> getTestList(int lectureNo) {
		//파라미터 값 확인 디버깅
		log.debug(TeamColor.KHJ + "파라미터 값 확인 리스트 lectureNo : "+ lectureNo );
		
		//리턴 값 세팅
		List<Map<String,Object>> list = testMapper.selectTestList(lectureNo);
		
		//리턴
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

	@Override
	public List<MultiChoice> getTestChoiceList() {
		//리턴 값 세팅
		List<MultiChoice> list = testMapper.selectTestChoice();
				
		//리턴
		return list;
	}

}
