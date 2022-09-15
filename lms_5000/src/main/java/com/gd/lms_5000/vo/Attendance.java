package com.gd.lms_5000.vo;

import lombok.Data;

@Data
public class Attendance {
	private int week;
	private int signNo;
	private int attendState;
	private String createDate;
	private String updateDate;
}
