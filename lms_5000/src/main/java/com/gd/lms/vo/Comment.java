package com.gd.lms.vo;

import lombok.Data;

@Data
public class Comment {
	//댓글 번호
	private int commentNo;				
	//댓글 내용
	private String commentContent;		
	//댓글 작성일
	private String commentCreatedate;	
	//댓글 수정일
	private String commentUpdatedate;	
	//게시글 번호
	private int boardPostNo;			
}
