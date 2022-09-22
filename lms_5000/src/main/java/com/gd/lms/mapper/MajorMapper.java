package com.gd.lms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gd.lms.vo.Major;

@Mapper
public interface MajorMapper {
	// 학과 리스트
	public List<Major> selectMajorList();
	
	// 학과 추가
	public int addMajor(Major major);
	
	// 학과 삭제
	public int deleteMajor(int majorNo);
	
	// 학과 수정
	public int updateMajor(Major major);
	
}
