package com.gd.lms.service;

import java.util.List;

import java.util.Map;

import com.gd.lms.vo.Paging;
import com.gd.lms.vo.User;

public interface IMypageService {
	
	//마이페이지 정보조회시 비밀번호 확인
	boolean getPasswordCheck(User user);
	
	//마이페이지 유저 정보받기
	Map<String, Object> getUserInfo(String userId, int userLevel);
	
	int modifyUserInfo(Map<String, Object> map);
	
	// 비밀번호 변경시 현재 비밀번호 db와 일치하는지 확인
	User getPwCheck(User user);
	
	// 변경할 비밀번호 처리
	int modifyUserPw(User user);
	
	// 게시글 리스트
	List<Map<String, Object>> getboardWriteList(int userLevel, Paging paging);
	
	//게시글 개수 마지막페이지구하기용
	Paging getPostCount(int userLevel, Paging paging);
	
	// 댓글 리스트
	List<Map<String, Object>> getCommentWriteList(Paging paging);
	
	// 댓글 개수 카운트
	Paging getCommentCount(Paging paging);
}
