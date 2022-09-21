package com.gd.lms.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestMapper {
	// 시험볼 과목 리스트
	List<Map<String, Object>> selectTestLecture();
		
}
