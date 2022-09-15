package com.gd.lms.vo;

import lombok.Data;

@Data
public class Professor {
	//교수 ID
	private String userId;			
	//교수 이름
	private String proName;			
	//교수 이메일
	private String proEmail;		
	//교수 전화번호
	private String proTel;			
	//교수 성별
	private String proGender;		
	//접속일
	private String accessDate;		
	//개인정보 수정일
	private String updateDate;		
	//학과 번호
	private int majorNo;			
}
