package com.gd.lms.vo;

import lombok.Data;

@Data
public class Student {
	private String userId;
	private String stName;
	private String stEmail;
	private String stTel;
	private String stGender;
	private String accessDate;
	private String updateDate;
	private int majorNo;
}
