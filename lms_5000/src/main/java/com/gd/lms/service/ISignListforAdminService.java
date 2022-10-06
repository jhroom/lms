package com.gd.lms.service;

import java.util.List;
import java.util.Map;

import com.gd.lms.vo.Sign;
import com.gd.lms.vo.SignCancel;

public interface ISignListforAdminService {
	
	// 강좌 리스트
	public List<Map<String, Object>> StudentSignList(int beginRow, int rowPerPage);

	// 강좌별 수강신청 리스트
	public List<Map<String, Object>> getStudentListByLecture(Sign sign);
	
	// 강좌 정보
	public List<Map<String, Object>> getSubjectInfo();
	
	// 학생 수강신청 상태 변경
	public int modifySignState(Sign sign, SignCancel signCancel);
	
	// 강좌 총 개수
	public int getTotal();
}