package com.gd.lms.service;

import java.util.List;

import com.gd.lms.vo.Major;

public interface IMajorService {
	
	// 학과 리스트
	public List<Major> getMajorList();
	
	// 학과 추가
	public int addMajor(Major major);
	
	// 학과 수정
	public int updateMajor(Major major);
	
	// 학과 삭제
	public int deleteMajor(int majorNo);
	
	
}
