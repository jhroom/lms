package com.gd.lms.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.mapper.LectureMapper;
import com.gd.lms.vo.Sign;
import com.gd.lms.vo.SignCancel;

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
		log.debug(TeamColor.YHW + "-- Lecturelist-service--"+ Lecturelist );
		return Lecturelist;
	}

	@Override
	// 학생 선택 과목 add
	public int addSign(Sign sign){
		int addSign = lecturemapper.insertSign(sign);
		//디버깅
		log.debug(TeamColor.YHW + "-- addSign-service -- "+ addSign );
		return addSign;
	}

	@Override
	// 학생 수강신청 목록
	public List<Map<String, Object>> signList(Sign userId) {
		List<Map<String, Object>> SignList = lecturemapper.selectSignList(userId);
		//디버깅
		log.debug(TeamColor.YHW + "-- SignList-service -- "+ SignList );
		return SignList;
	}

	@Override
	// 수강 취소
	public int removeSign(Sign sign) {
		int removeSign = lecturemapper.deleteSign(sign);
		//디버깅
		log.debug(TeamColor.YHW + "-- removeSign-service -- "+ removeSign );
		return removeSign;
	}
	
	@Override
	// 수강 취소 과목 입력
	public int addCancleSign(SignCancel signCancel) {
		int addCancleSign = lecturemapper.insertCancelSign(signCancel);
		//디버깅
		log.debug(TeamColor.YHW + "-- addCancleSign-service -- "+ addCancleSign );
		return addCancleSign;
	}

	@Override
	// 수강 취소 리스트
	public List<Map<String, Object>> selectCancelSignList(SignCancel userId) {
		List<Map<String, Object>> CancelList = lecturemapper.selectCancelSignList(userId);
		//디버깅
		log.debug(TeamColor.YHW + "-- CancelList-service -- "+ CancelList );
		return CancelList;
	}

}
