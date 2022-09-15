package com.gd.lms.vo;

import lombok.Data;

@Data
public class Sign {
	//필드
	private int signNo;
	private int signState;
	private String signStartdate;
	private String signEnddate;
	private int lectureNo;
	private String userId;	
}
