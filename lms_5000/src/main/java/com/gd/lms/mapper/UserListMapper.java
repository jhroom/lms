package com.gd.lms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gd.lms.vo.User;

@Mapper
public interface UserListMapper {
	//전체 유저 리스트
	List<User> selectUserList();
	
	//Active값 변경
	public int updateUserActive(User user);
	
	//대기 유저 리스트
	List<User> selectWaitUserList();
	
	//
	List<User> selectYesUserList();

}
