package com.gd.lms.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gd.lms.vo.Sign;
import com.gd.lms.vo.SignCancel;


@Mapper
public interface LectureMapper {
	// 수강신청을 하기위한 개설 강좌 리스트 보기
	public List<Map<String, Object>> selectLectureListForSign(int beginRow, int rowPerPage);
	
	// 수강 신청
	public int insertSign(Sign sign);
	
	// 수강 신청 목록
	public List<Map<String, Object>> selectSignList(Sign userId);
	
	// 수강 취소
	public int deleteSign(Sign sign);
	
	// 취소 목록 등록
	public int insertCancelSign(SignCancel signCancel);
	
	// 수강 취소 리스트
	public List<Map<String, Object>> selectCancelSignList(SignCancel userId);
	
	//중복 신청 방지용 수강신청 정보 확인
	public int selectSignHistory(Sign sign);
	
	//현재 신청 학점 확인 쿼리
	public int selectSignTime(Sign sign);
	
	//학기 정보 확인
	public String selectSemester(int year, int session);
	
	// 개설 강좌 총 개수
	public int getTotal();
	
	// 중복 과목 신청 여부 확인
	public int selectSignHistoryForSubject(Sign sign);
	
	// 시간 / 요일에 따른 제약 조건
	public int selectSignHistoryForTime(Sign sign);
}
