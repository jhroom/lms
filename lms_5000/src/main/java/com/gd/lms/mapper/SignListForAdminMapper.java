package com.gd.lms.mapper;

import java.util.List;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gd.lms.vo.Sign;
import com.gd.lms.vo.SignCancel;

@Mapper
public interface SignListForAdminMapper {
	// 강좌 리스트 
	List<Map<String, Object>> selectLectureList();
	
	// 강좌별 수강신청 인원 리스트
	List<Map<String, Object>> selectStudentListByLecture(Sign sign);
	
	// 과목 정보
	List<Map<String, Object>> selectSubjectInfo();
	
	// 학생 수강신청 상태 변경
	int updateSignState(Sign sign);
	
	// 취소된 내용 signcancel테이블에 담기
	int insertSignCancel(SignCancel userId);
	
	//취소가 아닐 경우 signcancel테이블 삭제
	int deleteSignCancel(SignCancel userId);
	
	//관리자가 수강신청으로 변경시 해당 강의 주차 조회
	int[] selectLectureWeek(int lectureNo);
	
	int insertAttendance(int week, int signNo);
	
}