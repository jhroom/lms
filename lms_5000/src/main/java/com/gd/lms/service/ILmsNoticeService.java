package com.gd.lms.service;

import java.util.List;

import com.gd.lms.vo.LmsNotice;

public interface ILmsNoticeService {

	// 리스트
	List<LmsNotice> getLmsNoticeList();
	
	// 공지 추가 (사진도)
	void LmsAddNotice(LmsNotice lmsNotice, String path);
	// 공지 삭제
	int deleteLmsNotice(int lmsNoticeNo, String path);
	// 공지 수정
	void updateLmsNotice(LmsNotice lmsNotice, String path);
	// 공지 상세보기
	LmsNotice getLmsNoticeOne(int lmsNoticeNo);
	
	
	
}
