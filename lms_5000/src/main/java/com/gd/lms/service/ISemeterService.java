package com.gd.lms.service;

import java.util.List;
import java.util.Map;

import com.gd.lms.vo.Semester;

public interface ISemeterService {
	
	// 학기 리스트
	public List<Semester> getSemesterList();
	
	// 학기 추가
	public int addSemseter(Semester semester);
	
	// 학기 수정
	public int updateSemester(Semester semester);
	
	// 학기 삭제
	public int deleteSemester(int semesterNo);
	
	// 학기 상세보기
	public Map<String, Object> getSemesterOne(int semesterNo);
	
	
}	
