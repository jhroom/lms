package com.gd.lms.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.mapper.UserListMapper;
import com.gd.lms.vo.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class UserListService implements IUserListService {
	@Autowired 	UserListMapper userListMapper;
	
	//전체 유저 리스트
	@Override
	public List<User> selectUserList(int currentPage, int rowPerPage) {
		int beginRow = (currentPage-1)*rowPerPage;
		
		//List 세팅
		List<User> list = userListMapper.selectUserList(beginRow , rowPerPage);
		
		//디버그
		log.debug(TeamColor.JCH + this.getClass() + " selectUserList 체크");

		
		return list;
	}

	//유저 활성화값 변경
	@Override
	public int updateUserActive(User user) {
		
		int row = userListMapper.updateUserActive(user);
		
		log.debug(TeamColor.JCH + this.getClass() + "updateUserAcite 체크");
		return row;
	}

	//승인 대기 유저
	@Override
	public List<User> selectWaitUserList(int currentPage , int rowPerPage) {
		int beginRow = (currentPage-1)*rowPerPage;

		//List 세팅
		List<User> list = userListMapper.selectWaitUserList(beginRow , rowPerPage);
		
		//디버그
		log.debug(TeamColor.JCH + this.getClass() + " selectUserList 체크");
		return list;
	}

	//승인 완료 유저
	@Override
	public List<User> selectYesUserList(int currentPage , int rowPerPage) {
		int beginRow = (currentPage-1)*rowPerPage;

		
		//List 세팅
		List<User> list = userListMapper.selectYesUserList(beginRow , rowPerPage);
				
		//디버그
		log.debug(TeamColor.JCH + this.getClass() + " selectUserList 체크");
		return list;
	}
	
	//승인 완료 유저
	@Override
	public List<User> selectHUserList(int currentPage , int rowPerPage) {
		int beginRow = (currentPage-1)*rowPerPage;

		
		//List 세팅
		List<User> list = userListMapper.selectHUserList(beginRow , rowPerPage);
				
		//디버그
		log.debug(TeamColor.JCH + this.getClass() + " selectUserList 체크");
		return list;
	}
	
	//유저 Active값 자동 변경 ( 마지막 로그인 날짜와 현재 날짜차이가 60일 일 경우)
	@Override
	public int updateUserActiveByLastLogin() {
		//디버깅
		log.debug(TeamColor.JCH + this.getClass() + "휴면계정 변경");
		return userListMapper.updateUserActiveByLastLogin();
	}

	@Override
	public int lastPage() {
		//디버깅
		log.debug(TeamColor.JCH + this.getClass() + "마지막페이지 구하기 위한 전체 갯수 카운팅");
		return userListMapper.countUserList();
	}

	@Override
	public int lastPageYesUser() {
		//디버깅
		log.debug(TeamColor.JCH + this.getClass() + "마지막페이지 구하기 위한 승인유저 갯수 카운팅");
		return userListMapper.countYesUserList();
	}

	@Override
	public int lastPageWaitUser() {
		//디버깅
		log.debug(TeamColor.JCH + this.getClass() + "마지막페이지 구하기 위한 대기유저 갯수 카운팅");
		return userListMapper.countWaitUserList();
	}

	@Override
	public int lastPageHUser() {
		//디버깅
		log.debug(TeamColor.JCH + this.getClass() + "마지막페이지 구하기 위한 휴면유저 갯수 카운팅");
		return userListMapper.countHUserList();
	}
	
	

	
}
