package com.gd.lms.vo;

import lombok.Data;

@Data
public class LmsNotice {
	//LMS공지사항 번호
	private int lmsNoticeNo;			
	//LMS공지사항 제목
	private String lmsNoticeTitle;		
	//LMS공지사항 내용
	private String lmsNoticContent;		
	//LMS공지사항 작성일
	private String lmsNoticeCreatetime;		
	//LMS공지사항 수정일
	private String lmsNoticeUpdatetime;		
	//조회수
	private int count;						
	
}
