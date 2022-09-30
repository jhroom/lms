package com.gd.lms.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gd.lms.vo.Lecture;
import com.gd.lms.vo.Professor;
import com.gd.lms.vo.Semester;
import com.gd.lms.vo.Subject;

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
		
}