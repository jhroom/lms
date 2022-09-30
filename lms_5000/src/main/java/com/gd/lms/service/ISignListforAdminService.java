package com.gd.lms.service;

import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;

import com.gd.lms.vo.Sign;
import com.gd.lms.vo.SignCancel;

public interface ISignListforAdminService {
	
	// 강좌 리스트
	List<Map<String, Object>> StudentSignList();

	// 강좌별 수강신청 리스트
	List<Map<String, Object>> getStudentListByLecture(Sign sign);
	
	// 학생 수강신청 상태 변경
	int modifySignState(Sign sign, SignCancel signCancel);
	

}