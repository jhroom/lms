package com.gd.lms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.mapper.UserLoginMapper;
import com.gd.lms.vo.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class UserLoginService implements IUserLoginService {

	@Autowired UserLoginMapper lmsLoginMapper;
	
	@Override
	public User getUserLogin(User user) {
		User temp = lmsLoginMapper.selectUserLogin(user);
		
		return temp;
	}

	@Override
	public boolean addUser(User user) {
		boolean result = false;
		int row = lmsLoginMapper.insertUser(user);
		log.debug(TeamColor.AJH + row + "insert 결과");
		if(row == 1) {
			result = true;
		}
		return result;
	}

}
