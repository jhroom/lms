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
	
	//마지막 로그인 날짜로부터 60일동안 로그인 안 했다면 Y->N
	public int updateUserActiveByLastLogin();
}
