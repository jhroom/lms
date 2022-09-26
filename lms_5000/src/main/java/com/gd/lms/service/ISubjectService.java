package com.gd.lms.service;

import java.util.List;
import java.util.Map;

import com.gd.lms.vo.Subject;

public interface ISubjectService {
	
	// 강좌 리스트
	public List<Subject> getSubjectList();
	
	// 강좌 생성
	public int addSubject(Subject subject);
	
	// 강좌 보기
	public Map<String, Object> getSubjectOne(int subjectNo);
	
	// 강좌 수정
	public int updateSubject(Subject subject);
	
	// 강좌 삭제
	public int deleteSubject(int subjectNo);
}
