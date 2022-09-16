package com.gd.lms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.mapper.FindUserMapper;
import com.gd.lms.vo.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class FindUserService implements IFindUserService {

	@Autowired FindUserMapper findUserMapper;
	
	@Override
	public String findUserId(User user) {
		//회원 아이디 찾기
		log.debug(TeamColor.JCH + this.getClass() + user + " FindUserService 호출");
		
		//db에 데이터 없을때 넘어오는 메시지
		String userId = "";
		if(findUserMapper.findUserId(user) != null) {
			//db에 데이터가 있으면 ID값을 받아와서 넘어옴
			userId = findUserMapper.findUserId(user).getUserId();
		}
		
		//받아온 유저 id확인.
		System.out.println(userId);
		
		return userId;
	}

	@Override
	public String findUserPw(User user) {
		//회원 비밀번호 찾기
		log.debug(TeamColor.JCH + this.getClass() + user + " FindUserService 호출");
		
		String userPw ="";
		if(findUserMapper.findUserPw(user) != null) {
			//db에 데이터가 있으면 pw값을 받아서 넘어옴
			userPw = findUserMapper.findUserPw(user).getUserPw();
		}
		//받아온 유저 pw 확인
		System.out.println(userPw);
		
		return userPw;
	}

}
