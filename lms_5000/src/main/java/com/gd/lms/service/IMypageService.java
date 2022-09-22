package com.gd.lms.service;

import java.util.List;
import java.util.Map;

import com.gd.lms.vo.User;

public interface IMypageService {
	
	User getUserInfo(String userId);
	
	int modifyUserInfo(Map<String, Object> map);
	// 비밀번호 변경시 현재 비밀번호 db와 일치하는지 확인
	User getPwCheck(User user);
	
	// 변경할 비밀번호 처리
	int modifyUserPw(User user);
	
	// 게시글 리스트
	List<Map<String, Object>> getboardWriteList(String userId);
	
	// 댓글 리스트
	List<Map<String, Object>> getCommentWriteList(String userId);
}
