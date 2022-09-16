package com.gd.lms.service;

import com.gd.lms.vo.User;

public interface IFindUserService {
	// 아이디 , 비밀번호 찾기 등 구현Service
	
	//유저 ID를 찾을떄
	String findUserId(User user);
	
	//유저 PW를 찾을때
	String findUserPw(User user);
	
}
