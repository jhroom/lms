package com.gd.lms.vo;

import lombok.Data;

@Data
public class Position {
	//직책 번호
	private int positionNo;			
	//직책 이름 , 기본값 0 (운영자) 1(관리자)->가입승인을 해주는 역할
	private int positionName;		
}
