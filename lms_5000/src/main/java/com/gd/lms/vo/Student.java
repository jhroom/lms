package com.gd.lms.vo;

import lombok.Data;

@Data
public class Student {
	// 학생아이디
	private String userId;
	// 학생이름
	private String stName;
	// 학생 학년
	private int st_grade;
	// 학생 이메일
	private String stEmail;
	// 학생 전화번호
	private String stTel;
	// 학생 성별
	private String stGender;
	// 승인 날짜
	private String accessDate;
	// 수정 날짜
	private String updateDate;
	// 학과 번호
	private int majorNo;
}
