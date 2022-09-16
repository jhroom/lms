package com.gd.lms.mapper;


import org.apache.ibatis.annotations.Mapper;

import com.gd.lms.vo.User;

@Mapper
public interface FindUserMapper {

	//아이디 찾기
	User findUserId(User user);
	
	//비밀번호 찾기
	User findUserPw(User user);
}
