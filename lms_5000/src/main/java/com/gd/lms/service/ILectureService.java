package com.gd.lms.service;

import java.util.List;
import java.util.Map;

import com.gd.lms.vo.Sign;
import com.gd.lms.vo.SignCancel;


public interface ILectureService {
	// 개설강좌 수강신청 보기
	public List<Map<String, Object>> selectLectureListForSign();
	
	// 총 강좌 개수
	public int getTotal();
	
	// 학생 수강 강좌 insert
	public int addSign(Sign sign);
	
	// 학생 수강 신청 List
	public List<Map<String, Object>> signList(Sign userId);
	
	// 수강 취소 
	public int removeSign(Sign sign);
	
	// 수강 취소 과목 입력
	public int addCancleSign(SignCancel signCancel);
	
	// 수강 취소 리스트
	public List<Map<String, Object>> selectCancelSignList(SignCancel userId);
	
	//수강 신청 학점 추출 서비스
	public int getSignTime(Sign sign);
	
	//학기 정보 확인
	public boolean getSemesterCheck();
	
	
	
}
