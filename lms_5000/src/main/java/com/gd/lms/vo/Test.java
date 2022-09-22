package com.gd.lms.vo;

import lombok.Data;

@Data
public class Test {
	// 시험번호
	private int testNo;
	// 시험이름
	private String testName;
	// 시험 시작 시간
	private String testStarttime;
	// 시험 종료 시간
	private String testEndtime;
	// 등록날자
	private String testCreatedate;
	// 수정 날자
	private String testUpdatedate;
	// 강좌 번호
	private int lectureNo;
}
