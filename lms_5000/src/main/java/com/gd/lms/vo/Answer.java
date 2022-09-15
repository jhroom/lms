package com.gd.lms.vo;

import lombok.Data;

@Data
public class Answer {
	// 학생이 제출한 답안
	private int answerSelect;
	// 각 문제의 점수
	private int answerScore;
	// 문제 번호
	private int questionNo;	
	// 학생의 수강 정보
	private int signNo;
}
