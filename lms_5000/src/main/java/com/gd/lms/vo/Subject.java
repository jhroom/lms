package com.gd.lms.vo;

import lombok.Data;

@Data
public class Subject {
	
	// 과목 코드
	private int subjectNo;
	// 과목이름
	private String subjectName;
	// 이수 학점
	private int subjectPoint;
	// 대상학년
	private int subjectGrade;
	// 학과번호
	private int majorNo;
	private String majorName;
}
