package com.gd.lms.vo;

import lombok.Data;

@Data
public class User {
	//  회원 아이디
	private String userId;
	// 회원 비밀번호
	private String userPw;
	// 1: 운영자 2: 교수 3: 학생
	private int userLevel;
	// 회원 이름
	private String userName;
	// 회원 이메일
	private String userEmail;
	// 회원 전화번호
	private String userTel;
	// 회원 성별
	private String userGender;
	// 수정 날자
	private String updateDate;
	// 생성 날자
	private String createDate;
	// 마지막 접속 날자
	private String lastloginDate;
	// 계정 활성화 상태
	private String userActive;
}
