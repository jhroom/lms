package com.gd.lms.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gd.lms.mapper.LectureMapper;

@Service
public class LectureService implements ILectureService {
	@Autowired LectureMapper lecturemapper;
	
	@Override
	// 수강신청을 위한 개설강좌 목록
	public List<Map<String, Object>> selectLectureListForSign() {
		List<Map<String, Object>> Lecturelist = lecturemapper.selectLectureListForSign();
		System.out.println("개설강좌 목록 service : " + Lecturelist);
		return Lecturelist;
	}

}
