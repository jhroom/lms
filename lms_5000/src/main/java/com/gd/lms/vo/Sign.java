package com.gd.lms.vo;

import lombok.Data;

@Data
public class Sign {
	//수강번호
	private int signNo;
	// 수강상태
	private int signState;
	// 수강신청 시작일
	private String signStartdate;
	// 수강신청 종료일
	private String signEnddate;
	// 강좌 코드
	private int lectureNo;
	// 학생아이디
	private String userId;	
}
