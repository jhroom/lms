package com.gd.lms.vo;

import lombok.Data;

@Data
public class Admin {
	//운영자 ID
	private String userId; 
	//운영자 이름
	private String adminName;
	//운영자 이메일
	private String adminEmail;
	//운영자 전화번호
	private String adminTel;
	//운영자 성별
	private String adminGender;
	//승인 날짜
	private String accessDate;
	//수정 날짜
	private String updateDate;
	//직책 번호
	private int positionNo;
}
