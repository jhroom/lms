package com.gd.lms.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.mapper.SignListForAdminMapper;
import com.gd.lms.vo.Sign;
import com.gd.lms.vo.SignCancel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SignListforAdminService implements ISignListforAdminService{
	@Autowired SignListForAdminMapper signListForAdminMapper;
	
	// 강좌 리스트
	@Override
	public List<Map<String, Object>> StudentSignList() {
		List<Map<String, Object>> StudentSignList = signListForAdminMapper.selectLectureList();
		// 디버깅
		log.debug(TeamColor.YHW + "-- mapper에서 넘어온 강좌리스트 -service--"+ StudentSignList );
		return StudentSignList;
	}
	
	// 강좌별 수강신청 리스트
	@Override
	public List<Map<String, Object>> getStudentListByLecture(Sign sign) {
		List<Map<String, Object>> getStudentListByLecture = signListForAdminMapper.selectStudentListByLecture(sign);
		// 디버깅
		log.debug(TeamColor.YHW + "-- mapper에서 넘어온 수강신청 리스트 -service--"+ getStudentListByLecture );
		return getStudentListByLecture;
	}

	// 학생 수강상태 변경
	@Override
	public int modifySignState(Sign sign) {
		int modifySignState = signListForAdminMapper.updateSignState(sign);
		// 디버깅
		log.debug(TeamColor.YHW + "-- mapper에서 넘어온 수강상태 변경 -service--"+ modifySignState );
		return modifySignState;
	}

	@Override
	public int modifySignState(Sign sign, SignCancel signCancel) {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
