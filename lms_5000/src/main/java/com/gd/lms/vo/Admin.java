package com.gd.lms.vo;

import lombok.Data;

@Data
public class Admin {
	private String userId;
	private String adminName;
	private String adminEmail;
	private String adminTel;
	private String adminGender;
	private String accessDate;
	private String updateDate;
	private int positionNo;
}
