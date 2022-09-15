package com.gd.lms.vo;

import lombok.Data;

@Data
public class Board {
	// 게시판 번호
	private int boardNo;	
	// 게시판 이름
	private String boardName;	
	// 게시판 종류 ( QNA , 공지사항 등 ..)
	private int boardType;		
	// 작성일
	private String createDate;		
	// 강좌 번호
	private int lectureNo;			
}
