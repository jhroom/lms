package com.gd.lms.service;

import java.util.List;

import com.gd.lms.vo.Major;
import com.gd.lms.vo.Position;
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
	
	//학과리스트
	List<Major> getMajorList();
	
	//직책 리스트 받기
	List<Position> getPositionList();

}
