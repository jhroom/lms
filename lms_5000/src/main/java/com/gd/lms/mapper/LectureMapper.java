package com.gd.lms.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gd.lms.vo.Lecture;
import com.gd.lms.vo.Sign;
import com.gd.lms.vo.SignCancel;
import com.gd.lms.vo.Subject;


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
	
	///////////////////////////////////////////////////////// 승현 등장
	
	// 강의 리스트
	public List<Lecture> selectLectureList();
	
	// 강의 추가
	public int addLecture(Lecture lecture);
	
	// 강의 수정
	public int updateLecture(Lecture lecture);
	
	// 강의 삭제
	public int deleteLecture(int lectureNo);
	
	// 강의 상세보기
	public Map<String, Object> selectLectureOne(int selectNo);
	
	// 강좌 리스트 받아오기
	public List<Subject> getSubjectList();
	
}
