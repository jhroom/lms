package com.gd.lms.vo;

import lombok.Data;

@Data
public class Week {
	// 1주차 2 주차..
	private int week;
	// 강좌 시작날자 
	private String startDate;
	// 강좌 종료날자
	private String EndDate;	
	// 강좌 번호
	private int lectureNo;
	
}
