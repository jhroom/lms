package com.gd.lms.vo;

import lombok.Data;

@Data
public class User {
	private String userId;
	private String userPw;
	private int userLevel;
	private String userName;
	private String userEmail;
	private String userTel;
	private String userGender;
	private String updateDate;
	private String createDate;
	private String lastloginDate;
	private String userActive;
}