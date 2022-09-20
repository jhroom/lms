package com.gd.lms.service;

import java.util.List;
import java.util.Map;

import com.gd.lms.vo.LmsNotice;

public interface ILmsNoticeService {

	// 리스트
	public List<LmsNotice> getLmsNoticeList();
	
	// 공지 추가 (파일도 필요)
	public int LmsAddNotice(LmsNotice lmsNotice);
	// 공지 삭제
	public int deleteLmsNotice(int lmsNoticeNo, String path);
	// 공지 수정
	void updateLmsNotice(LmsNotice lmsNotice, String path);
	// 공지 상세보기
	public Map<String, Object> getLmsNoticeOne(int lmsNoticeNo);
	
	
	
}
