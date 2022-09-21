package com.gd.lms.service;

import java.util.Map;

import com.gd.lms.vo.User;

public interface IMypageService {
	
	User getUserInfo(String userId);
	
	int modifyUserInfo(Map<String, Object> map);

}
