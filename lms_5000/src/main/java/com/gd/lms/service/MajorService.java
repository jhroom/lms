package com.gd.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	@Override
	public int addMajor(Major major) {
		int row = majorMapper.addMajor(major);
		
		
		
		return row;
	}

	@Override
	public int updateMajor(Major major) {
		
		return 0;
	}

	@Override
	public int deleteMajor(int majorNo) {
		
		return 0;
	}

}
