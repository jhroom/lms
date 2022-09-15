package com.gd.lms.vo;

import lombok.Data;

@Data
public class Semester {
	private int semesterNo;
	private int semesterYear;
	private int semesterSession;
	private String semesterStartdate;
	private String semesterEnddate;
}
