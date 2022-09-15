package com.gd.lms.vo;

import lombok.Data;

@Data
public class BoardPost {
	//게시글 번호
	private int boardPostNo;			
	//게시판 번호
	private int boardNo;		
	//게시글 제목
	private String boardPostTitle;			
	//게시글 내용
	private String boardPostContent;		
	//게시글 작성자
	private String boardPostWriter;			
	//게시글 작성일
	private String boardPostCreatedate;		
	//게시글 수정일
	private String boardPostUpdatedate;		
	//조회수
	private int count;						
}
