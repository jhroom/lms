package com.gd.lms.service;

import java.util.List;

import com.gd.lms.vo.User;

public interface IUserListService {
	
	//유저 리스트
	public List<User> selectUserList();
	
	//업데이트 Active
	public int updateUserActive(User user);
	
	//승인대기 유저 리스트
	public List<User> selectWaitUserList();
	
	//승인완료 유저 리스트
	public List<User> selectYesUserList();
}
