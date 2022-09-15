package com.gd.lms.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.gd.lms.vo.User;

@Mapper
public interface UserLoginMapper {
	
	User selectUserLogin(User user);
		

}
