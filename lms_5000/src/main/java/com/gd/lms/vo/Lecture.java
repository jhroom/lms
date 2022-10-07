package com.gd.lms.vo;

import lombok.Data;

@Data
public class Lecture {
	//강좌 번호
	private int lectureNo;				
	//강의 시간
	private String lectureTime;			
	//강의 시작시간
	private String lectureStarttime;	
	//강의 종료시간
	private String lectureEndtime;		
	//강의를 하는 요일
	private String lectureDay;			
	//과목 번호
	private int subjectNo;			
	//강의실 번호
	private int classroomNo;		
	//교수 ID
	private String userId;			
	//학기 번호
	private int semesterNo;
	
	private String subjectName;
	private String userName;
	private int semesterYear;
	private int semesterSession;
}
