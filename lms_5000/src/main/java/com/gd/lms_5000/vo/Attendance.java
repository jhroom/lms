package com.gd.lms_5000.vo;

import lombok.Data;

@Data
public class Attendance {
	private int week;
	private int signN;
	private int attendState;
	private String createDate;
	private String updateDate;
}
