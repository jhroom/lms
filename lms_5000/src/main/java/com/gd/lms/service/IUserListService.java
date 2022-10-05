package com.gd.lms.service;

import java.util.List;
import java.util.Map;

import com.gd.lms.vo.User;

public interface IUserListService {
	
	//유저 리스트
	public List<User> selectUserList(int currentPage , int rowPerPage);
	
	//마지막페이지 - 전체유저
	public int lastPage();
	
	//마지막페이지 - 승인유저
	public int lastPageYesUser();
		
	//마지막페이지 - 대기유저
	public int lastPageWaitUser();
		
	//마지막페이지 - 휴면유저
	public int lastPageHUser();
	
	//업데이트 Active
	public int updateUserActive(User user);
	
	//승인대기 유저 리스트
	public List<User> selectWaitUserList(int currentPage , int rowPerPage);
	
	//승인완료 유저 리스트
	public List<User> selectYesUserList(int currentPage , int rowPerPage);
	
	//휴면계정 유저 리스트
	public List<User> selectHUserList(int currentPage , int rowPerPage);
	
	//마지막 로그인 날짜로부터 60일동안 로그인 안 했다면 Y->N
	public int updateUserActiveByLastLogin();
}
