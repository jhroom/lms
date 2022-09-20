package com.gd.lms.service;

import java.util.List;
import java.util.Map;

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
	public int LmsAddNotice(LmsNotice lmsNotice) {
		int row = lmsNoticeMapper.LmsAddNotice(lmsNotice);
		
		//디버깅
		System.out.println("AddNotice : " + row);
		
		return row;
		
		
	}

	
	//공지 삭제
	@Override
	public int deleteLmsNotice(int lmsNoticeNo, String path) {
		
		return 0;
	}
	
	
	//공지 수정
	@Override
	public void updateLmsNotice(LmsNotice lmsNotice, String path) {
		
		
	}
	//공지 상세보기
	@Override
	public Map<String, Object> getLmsNoticeOne(int lmsNoticeNo) {
		
		Map<String, Object> noticeOne = lmsNoticeMapper.selectLmsNoticeOne(lmsNoticeNo);
		//LmsNotice lmsNotice = lmsNotice
		
		
		return noticeOne;
	}
	

}
