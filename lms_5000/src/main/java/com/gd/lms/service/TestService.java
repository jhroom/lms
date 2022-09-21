package com.gd.lms.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.mapper.TestMapper;

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

}
