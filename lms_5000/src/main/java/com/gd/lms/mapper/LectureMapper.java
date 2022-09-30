package com.gd.lms.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gd.lms.vo.Sign;
import com.gd.lms.vo.SignCancel;


@Mapper
public interface LectureMapper {
	// 수강신청을 하기위한 개설 강좌 리스트 보기
	List<Map<String, Object>> selectLectureListForSign();
	// 수강 신청
	int insertSign(Sign sign);
	// 수강 신청 목록
	List<Map<String, Object>> selectSignList(Sign userId);
	// 수강 취소
	int deleteSign(Sign sign);
	// 취소 목록 등록
	int insertCancelSign(SignCancel signCancel);
	// 수강 취소 리스트
	List<Map<String, Object>> selectCancelSignList(SignCancel userId);
	
	//중복 신청 방지용 수강신청 정보 확인
	int selectSignHistory(Sign sign);
	
	//현재 신청 학점 확인 쿼리
	int selectSignTime(Sign sign);
	
	//학기 정보 확인
	String selectSemester(int year, int session);
		
	
}
