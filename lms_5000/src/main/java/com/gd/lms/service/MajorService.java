package com.gd.lms.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.mapper.MajorMapper;
import com.gd.lms.vo.Major;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class MajorService implements IMajorService{
	 @Autowired MajorMapper majorMapper;
	
	// 학과 리스트
	@Override
	public List<Major> getMajorList() {
		
		return majorMapper.selectMajorList();
	}
	
	//학과 추가
	@Override
	public int addMajor(Major major) {
		int row = majorMapper.addMajor(major);
		
		//디버깅 '1' 일시 성공
		log.debug(TeamColor.SSH + "학과 축가 결과 : " + row);
		
		return row;
	}

	//학과이름 수정
	@Override
	public int updateMajor(Major major) {
		
		int row = majorMapper.updateMajor(major);
		
		return row;
	}
	
	//학과 삭제
	@Override
	public int deleteMajor(int majorNo) {
		
		int row = majorMapper.deleteMajor(majorNo);
		
		return row;
	}
	
	// 학과 상세보기
	@Override
	public Map<String, Object> getMajorOne(int majorNo) {
		
		Map<String, Object> majorOne = majorMapper.selectMajorOne(majorNo);
		
		log.debug(TeamColor.SSH + "상세보기 값 넘기기 : " + majorOne);
		
		return majorOne;
	}

}
