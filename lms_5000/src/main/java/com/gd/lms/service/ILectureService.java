package com.gd.lms.service;

import java.util.List;
import java.util.Map;

import com.gd.lms.vo.Sign;


public interface ILectureService {
	// 개설강좌 수강신청 보기
	List<Map<String, Object>> selectLectureListForSign();
	// 학생 수강 강좌 insert
	int addSign(Sign sign);
	// 학생 수강 신청 List
	List<Map<String, Object>> signList(Sign userId);
}
