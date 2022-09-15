package com.gd.lms.vo;

import lombok.Data;

@Data
public class Attendance {
	private int week;
	private int signNo;
	private int attendState;
	private String createDate;
	private String updateDate;
}
