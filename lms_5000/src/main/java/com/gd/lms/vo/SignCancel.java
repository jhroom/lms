package com.gd.lms.vo;

import lombok.Data;

@Data
public class SignCancel {
	// 수강번호
	private int signNo;
	// 취소 주체 - 학생 , 운영자
	private String userId;
	// 취소날짜
	private String cancelDate;
}
