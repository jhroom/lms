package com.gd.lms.vo;

import lombok.Data;

@Data
public class AttendanceForm {
	//출석 폼 전용 vo
	
	private int week; //출석 주차
	
	private int lectureNo; // 해당 강좌
	
	private String [] studentId; // 출석할 학생 userId;
	
	private String studentOne; // 한개의 학생아이디 저장용
	
	private int [] attendState; // 출석될 상태 0:결석, 1:지각, 2:조퇴, 3:출석
	
	private int attStateOne; // 한개의 학생 출석 상태 저장용

}
