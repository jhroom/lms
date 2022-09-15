package com.gd.lms.vo;

import lombok.Data;

@Data
public class Professor {
	private String userId;
	private String proName;
	private String proEmail;
	private String proTel;
	private String proGender;
	private String accessDate;
	private String updateDate;
	private int majorNo;
}
