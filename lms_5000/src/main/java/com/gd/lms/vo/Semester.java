package com.gd.lms.vo;

import lombok.Data;

@Data
public class Semester {
	//학기 번호
	private int semesterNo;				
	//학기 연도
	private int semesterYear;			
	//학기 (1 : 1학기 , 2 : 2학기) 
	private int semesterSession;		
	//학기 시작일
	private String semesterStartdate;	
	//학기 종료일
	private String semesterEnddate;		
	
}
