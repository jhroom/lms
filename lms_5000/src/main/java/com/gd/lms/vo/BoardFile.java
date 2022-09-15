package com.gd.lms.vo;

import lombok.Data;

@Data
public class BoardFile {
	// 파일 이름
	private String fileName;				
	// 파일 원본 이름
	private String fileOriginname;			
	// 파일 타입
	private String fileType;				
	// 작성일
	private String createDate;			
	// 게시글 번호
	private int boardPostNo;				
}
