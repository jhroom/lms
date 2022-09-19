package com.gd.lms.service;

import com.gd.lms.vo.User;

public interface IUserLoginService {
	
	User getUserLogin(User user);
	
	boolean addAdmin(User user, int positionNo);
	
	boolean getUserIdCheck(String userId);
	
	boolean addStudentOrPro(User user, int majorNo);

}
