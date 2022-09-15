package com.gd.lms.vo;

import lombok.Data;

@Data
public class MultiChoice {
	//보기 번호
	private int choiceNo;			
	//문제 번호
	private int questionNo;			
	//보기 내용
	private String choiceContent;	
}
