package com.gd.lms.service;

import com.gd.lms.vo.User;

public interface IUserLoginService {
	
	User getUserLogin(User user);
	
	// 휴면계정 정보확인 
	String getRestUserCheck(User user);
	
	// 휴면계정 활성화
	int modifyRestUserActive(String userId);
	
	boolean addAdmin(User user, int positionNo);
	
	boolean getUserIdCheck(String userId);
	
	boolean addStudentOrPro(User user, int majorNo);
	
	void modifyUserLastLogin(String userId);

}
