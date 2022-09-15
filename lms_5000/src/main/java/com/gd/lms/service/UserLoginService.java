package com.gd.lms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gd.lms.mapper.UserLoginMapper;
import com.gd.lms.vo.User;

@Service
@Transactional
public class UserLoginService implements IUserLoginService {

	@Autowired UserLoginMapper lmsLoginMapper;
	
	@Override
	public User getUserLogin(User user) {
		User temp = lmsLoginMapper.selectUserLogin(user);
		
		return temp;
	}

}
