package com.gd.lms.service;

import java.util.List;

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
	public List<User> selectUserList() {
		//List 세팅
		List<User> list = userListMapper.selectUserList();
		
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
	public List<User> selectWaitUserList() {
		//List 세팅
		List<User> list = userListMapper.selectWaitUserList();
		
		//디버그
		log.debug(TeamColor.JCH + this.getClass() + " selectUserList 체크");
		return list;
	}

	//승인 완료 유저
	@Override
	public List<User> selectYesUserList() {
		//List 세팅
		List<User> list = userListMapper.selectYesUserList();
				
		//디버그
		log.debug(TeamColor.JCH + this.getClass() + " selectUserList 체크");
		return list;
	}


	
}
