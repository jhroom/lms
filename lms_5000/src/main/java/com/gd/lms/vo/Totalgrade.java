package com.gd.lms.vo;

import lombok.Data;

@Data
public class Totalgrade {
	// 수강 코드
	private int signNo;
	// 최종 학점
	private double totalGrade;
	// 총 점수
	private int gradeTotal;
	// 등수 -- 이 등수를 토대로 학점 매기기
	private int gradeRank;
	// 시험점수
	private int gradeTest;
	// 출석 점수
	private int gradeAtt;
	// 과제점수
	private int gradePaper;
	
}
