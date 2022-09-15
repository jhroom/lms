package com.gd.lms.vo;

import lombok.Data;

@Data
public class Question {
	//문제 번호
	private int questionNo;				
	//문제 지문
	private String questionContent;		
	//문제 정답
	private int questionAnswer;			
	//시험 번호

	private int testNo;				
}