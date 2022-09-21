package com.gd.lms.mapper;

import java.util.List;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gd.lms.vo.LmsFile;
import com.gd.lms.vo.LmsNotice;

@Mapper
public interface LmsNoticeMapper {
	//리스트
	public List<LmsNotice> selectLmsNoticeList();
	//공지 추가
	public int LmsAddNotice(LmsNotice lmsNotice);
	//공지 삭제
	public int deleteLmsNotice(int lmsNoticeNo);
	//공지 수정
	public int updateLmsNotice(LmsNotice lmsNotice);
	//공지 상세보기
	public Map<String, Object> selectLmsNoticeOne(int lmsNoticeNo);
	//게시글 파일 추가
	public int insertLmsNoticeFile(LmsFile lmsFile);
	
}
