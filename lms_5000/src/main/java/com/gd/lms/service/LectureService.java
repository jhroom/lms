package com.gd.lms.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.mapper.LectureMapper;
import com.gd.lms.vo.Sign;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class LectureService implements ILectureService {
	@Autowired LectureMapper lecturemapper;
	
	@Override
	// 수강신청을 위한 개설강좌 목록
	public List<Map<String, Object>> selectLectureListForSign() {
		List<Map<String, Object>> Lecturelist = lecturemapper.selectLectureListForSign();
		//디버깅
		log.debug(TeamColor.YHW + Lecturelist + "-- Lecturelist-service");
		return Lecturelist;
	}

	@Override
	// 학생 선택 과목 add
	public int addSign(Sign sign){
		int addSign = lecturemapper.insertSign(sign);
		//디버깅
		log.debug(TeamColor.YHW + addSign + "-- addSign-service");
		return addSign;
	}

	@Override
	// 학생 수강신청 목록
	public List<Map<String, Object>> signList(Sign userId) {
		List<Map<String, Object>> SignList = lecturemapper.selectSignList(userId);
		//디버깅
		log.debug(TeamColor.YHW + SignList + "-- SignList-service");
		return SignList;
	}

}
