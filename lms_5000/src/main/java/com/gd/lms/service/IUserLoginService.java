package com.gd.lms.service;

import com.gd.lms.vo.User;

public interface IUserLoginService {
	
	User getUserLogin(User user);
	
	boolean addUser(User user);
	
	boolean getUserIdCheck(String userId);
	
	boolean addStudent(User user, int majorNo);

}
