package com.gd.lms.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gd.lms.mapper.LectureMapper;
import com.gd.lms.vo.Sign;


@Service
public class LectureService implements ILectureService {
	@Autowired LectureMapper lecturemapper;
	
	@Override
	// 수강신청을 위한 개설강좌 목록
	public List<Map<String, Object>> selectLectureListForSign() {
		List<Map<String, Object>> Lecturelist = lecturemapper.selectLectureListForSign();
		System.out.println("개설강좌 목록 service : " + Lecturelist);
		return Lecturelist;
	}

	@Override
	// 학생 선택 과목 add
	public int addSign(Sign sign){
		int addSign = lecturemapper.insertSign(sign);
		System.out.println("\r\n addSign service : " + addSign);
		return addSign;
	}

	@Override
	// 학생 수강신청 목록
	public List<Map<String, Object>> signList(Sign userId) {
		List<Map<String, Object>> SignList = lecturemapper.selectSignList(userId);
		System.out.println("해당 아이디 수강 신청 목록 service : " + SignList);
		return SignList;
	}

}
