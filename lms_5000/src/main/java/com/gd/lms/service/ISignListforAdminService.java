package com.gd.lms.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.gd.lms.vo.Sign;

public interface ISignListforAdminService {
	
	// 강좌 리스트
	List<Map<String, Object>> StudentSignList();

	// 강좌별 수강신청 리스트
	List<Map<String, Object>> getStudentListByLecture(Sign sign);
}
