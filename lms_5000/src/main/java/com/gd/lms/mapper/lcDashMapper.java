package com.gd.lms.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gd.lms.vo.Sign;

@Mapper
public interface lcDashMapper {
	// 학생이 수강 신청한 과목 목록	
	List<Map<String, Object>> seletStudentSign(Sign userId);
}
