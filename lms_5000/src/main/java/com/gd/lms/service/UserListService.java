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
	
	@Override
	public List<User> selectUserList() {
		//List 세팅
		List<User> list = userListMapper.selectUserList();
		
		//디버그
		log.debug(TeamColor.JCH + this.getClass() + " selectUserList 체크");

		
		return list;
	}

	@Override
	public int updateUserActive(User user) {
		
		int row = userListMapper.updateUserActive(user);
		
		log.debug(TeamColor.JCH + this.getClass() + "updateUserAcite 체크");
		return row;
	}


	
}
