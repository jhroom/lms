package com.gd.lms.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.gd.lms.vo.LmsFile;

@Mapper
public interface LmsFileMapper {
	//파일 추가
	int insertLmsFile(LmsFile lmsFile);
	
	//파일 삭제 (공지사항 삭제시)
	int deleteLmsFile(int LmsNoticeNo);
	
	

}
