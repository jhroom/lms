package com.gd.lms_5000.vo;

import lombok.Data;

@Data
public class Lecture {
	private int lectureNo;
	private String lectureTime;
	private String lectureStarttime;
	private String lectureEndtime;
	private int lectureDay;
	private int subjectNo;
	private int classroomNo;
	private String userId;
	private int semesterNo;
}
