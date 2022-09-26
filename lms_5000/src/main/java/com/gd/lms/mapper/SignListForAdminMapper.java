package com.gd.lms.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gd.lms.vo.Sign;

@Mapper
public interface SignListForAdminMapper {
	// 강좌 리스트 
	List<Map<String, Object>> selectLectureList();
	
	// 강좌별 수강신청 리스트
	List<Map<String, Object>> selectStudentListByLecture(Sign sign);
}