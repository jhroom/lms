package com.gd.lms.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gd.lms.vo.Semester;

@Mapper
public interface SemesterMapper {
	// 학기 리스트
	public List<Semester> selectSemesterList();
	
	// 학기 추가
	public int addSemester(Semester semester);
	
	// 학기 수정
	public int updateSemester(Semester semester);
	
	// 학기 삭제
	public int deleteSemester(int semesterNo);
	
	// 학기 상세보기
	public Map<String, Object> selectSemesterOne(int semesterNo);
	
	
}
