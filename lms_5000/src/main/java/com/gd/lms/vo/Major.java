package com.gd.lms.vo;

import lombok.Data;

@Data
public class Major {
	//학과 번호
	private int majorNo;				
	//학과 이름
	private String majorName;			
	//학과 개설일
	private String majorCreatedate;		
	//운영자 ID
	private String userId;				
}
