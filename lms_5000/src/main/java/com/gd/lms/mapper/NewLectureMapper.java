package com.gd.lms.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gd.lms.vo.Lecture;
import com.gd.lms.vo.Professor;
import com.gd.lms.vo.Semester;
import com.gd.lms.vo.Subject;
import com.gd.lms.vo.Week;

@Mapper
public interface NewLectureMapper {

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
		
		// 학기 리스트
		public List<Semester> getSemesterList();
		
		// 교수 리스트 가져오기
		public List<Professor> getProList();
		
		// 강의 생성시 출석 주차 자동생성
		public int addWeek(int lectureNo);
		
		//학기 정보 추출 쿼리
		public String selectSemesterStartDate(int semesterNo);
		
		//강의 생성시 주차 생성(김현준
		public int addWeekK(int week, int lectureNo, String startDate, String endDate);
}
