package com.gd.lms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gd.lms.vo.LmsNotice;

@Mapper
public interface LmsNoticeMapper {
	//리스트
	List<LmsNotice> selectLmsNoticeList();
	//공지 추가
	int LmsAddNotice(LmsNotice lmsNotice);
	//공지 삭제
	int deleteLmsNotice(int lmsNoticeNo);
	//공지 수정
	int updateLmsNotice(LmsNotice lmsNotice);
	//공지 상세보기
	LmsNotice selectLmsNoticeOne(int lmsNoticeNo);
	
}
