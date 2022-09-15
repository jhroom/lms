package com.gd.lms.vo;

import lombok.Data;

@Data
public class Attendance {
	// 수업 주차
	private int week;
	// 학생의 수강 정보
	private int signNo;		
	// 출석 상태 ( 0 결석 1 지각 2 조퇴 3 출석 )
	private int attendState;		
	// 작성일
	private String createDate;		
	// 수정일
	private String updateDate;		
}
