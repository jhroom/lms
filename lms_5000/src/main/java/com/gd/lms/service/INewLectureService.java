package com.gd.lms.service;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import com.gd.lms.vo.Lecture;
import com.gd.lms.vo.Professor;

public interface INewLectureService {
	// 생성 강의 리스트 (수강신청할 수 있는)
		public List<Lecture> getLectureList();
		
		// 강의 추가
		public int addLecture(Lecture lecture);
		
		// 강의 수정
		public int updateLecture(Lecture lecture);
		
		// 강의 삭제
		public int deleteLecture(int lectureNo);
		
		// 강의 상세보기 
		public Map<String, Object> getLectureOne(int lectureNo);
		
		// 교수 리스트 가지고 오기
		public List<Professor> getProList();
		
		// 강의 추가시 출석 그거 어어
		public int addWeek(Lecture lecture) throws ParseException;
	}
