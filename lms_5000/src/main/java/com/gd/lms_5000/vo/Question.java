package com.gd.lms_5000.vo;

import lombok.Data;

@Data
public class Question {
	private int questionNo;
	private String questionContent;
	private int questionAnswer;
	private int testNo;
}
