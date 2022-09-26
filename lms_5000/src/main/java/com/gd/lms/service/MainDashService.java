package com.gd.lms.service;

import java.util.List;

import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.mapper.lcDashMapper;
import com.gd.lms.vo.Sign;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MainDashService implements IMainDashService {
	@Autowired lcDashMapper lcDashMapper;

	// 학생lms 페이지에 수강중 강좌 목록
	@Override
	public List<Map<String, Object>> selectStudentSignList(Sign userId) {
		List<Map<String,Object>> studentSignList = lcDashMapper.seletStudentSign(userId);
		// 강좌 내용 확인
		log.debug(TeamColor.YHW + "-- studentSignList-service -- "+ studentSignList );
		return studentSignList;
	}
	
	@Override
	public List<Map<String, Object>> getUserLectureList(String userId, int UserLevel) {
		 List<Map<String, Object>> userLectureList = null;
		switch(UserLevel) {
		
		case 2 : userLectureList = lcDashMapper.selectProfessorLectureList(userId);break;
		case 3 : userLectureList = lcDashMapper.selectStudentLectureList(userId);break;
		}
		
		return userLectureList;
	}
}
