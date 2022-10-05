package com.gd.lms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gd.lms.vo.User;

@Mapper
public interface UserListMapper {
	//전체 유저 리스트
	List<User> selectUserList(int beginRow , int rowPerPage);
	
	//Active값 변경
	public int updateUserActive(User user);
	
	//대기 유저 리스트
	List<User> selectWaitUserList(int beginRow , int rowPerPage);
	
	//승인 유저 리스트
	List<User> selectYesUserList(int beginRow , int rowPerPage);
	
	//휴면 유저 리스트
	List<User> selectHUserList(int beginRow , int rowPerPage);

	//휴면계정 전환 마지막 로그인 이후 60일 .. Y->N로 .
	int updateUserActiveByLastLogin();

	//전체 유저 리스트 count
	public int countUserList();
	
	//대기 유저 리스트 count
	public int countWaitUserList();
	
	//승인 유저 리스트 count
	public int countYesUserList();
	
	//휴면 유저 리스트 count
	public int countHUserList();
}
