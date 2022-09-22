package com.gd.lms.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gd.lms.vo.MultiChoice;
import com.gd.lms.vo.Question;

@Mapper
public interface TestMapper {
	// 시험볼 과목 리스트
	List<Map<String, Object>> selectTestLecture();
	
	
	//강좌 시험 리스트 생성 쿼리
	List<Map<String, Object>> selectTestList(int lectureNo);
	
	//시험문제 생성 쿼리
	List<Question> selectTestQuestion(int testNo);
	
	//시험 문제 보기 리스트 생성 쿼리
	List<MultiChoice> selectTestChoice();
		
}
