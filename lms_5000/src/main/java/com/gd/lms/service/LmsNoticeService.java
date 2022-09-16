package com.gd.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gd.lms.mapper.LmsNoticeMapper;
import com.gd.lms.vo.LmsNotice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class LmsNoticeService implements ILmsNoticeService {
	@Autowired LmsNoticeMapper lmsNoticeMapper;
	
	
	// 공지 리스트
	@Override
	public List<LmsNotice> getLmsNoticeList() {
		return lmsNoticeMapper.selectLmsNoticeList();
	}
	
	
	
	
	// 공지 등록
	@Override
	public void LmsAddNotice(LmsNotice lmsNotice, String path) {
		//공지 등록 중..
		
	}

	
	
	@Override
	public int deleteLmsNotice(int lmsNoticeNo, String path) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateLmsNotice(LmsNotice lmsNotice, String path) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public LmsNotice getLmsNoticeOne(int lmsNoticeNo) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
