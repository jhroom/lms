package com.gd.lms.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.mapper.MypageMapper;
import com.gd.lms.vo.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class MypageService implements IMypageService {
	
	@Autowired MypageMapper mypageMapper;

	@Override
	public User getUserInfo(String userId) {
		//세션이 담긴 아이디로 마이페이지에 보일 나의 정보 가져오기
		return mypageMapper.selectUserInfo(userId);
	}

	@Override
	public int modifyUserInfo(Map<String, Object> map) {
		int row = -1;
		int levelRow = -1;
		
		String userId = (String)map.get("userId");
		String userInfo = (String)map.get("userInfo");
		int userLevel = (int)map.get("userLevel");
		
		System.out.println(TeamColor.AJH+"파라미터 레벨 확인 :" + userLevel);
		
		//정보변경하는 객체 이메일 전화번호 분기
		if( ((String)map.get("userInfo")).contains("@")) {
			System.out.println(TeamColor.AJH+"파라미터 형식 이메일");
			
			//통합 계정 이메일 변경
			row = mypageMapper.modifyUserEmail(userInfo, userId);
			
			// 레벨에 따른 계정 이메일 변경
			switch(userLevel) {
				case 1 : levelRow = mypageMapper.modifyAdminEmail(userInfo, userId);break;
				case 2 : levelRow = mypageMapper.modifyProEmail(userInfo, userId);break;
				case 3 : levelRow = mypageMapper.modifyStudentEmail(userInfo, userId);break;
			}
		} else {
			System.out.println(TeamColor.AJH+"파라미터 형식 번호");
			
			//통합 계정 번호 변경
			row = mypageMapper.modifyUserTel(userInfo, userId);
			
			//레벨에 따른 계정 번호 변경
			switch(userLevel) {
				case 1 : levelRow = mypageMapper.modifyAdminTel(userInfo, userId);break;
				case 2 : levelRow = mypageMapper.modifyProTel(userInfo, userId);break;
				case 3 : levelRow = mypageMapper.modifyStudentTel(userInfo, userId);break;
			}
		}
		
		if(row == 1 && levelRow == 1) {
			System.out.println(TeamColor.AJH+"정보 변경 성공 : " + row);
			System.out.println(TeamColor.AJH+"계층에따른 정보 변경 성공 : " + levelRow);
		}
		
		return row;
	}
	
	@Override
	public User getPwCheck(User user) {
		log.debug("컨트롤러 에서 넘어온값 확인 : " + user);
		return mypageMapper.selectPwCheck(user);
	}
	@Override
	public int modifyUserPw(User user) {
		return mypageMapper.modifyUserPw(user);
	}
	//게시글 리스트
	@Override
	public List<Map<String, Object>> getboardWriteList(String userId) {
		
		return mypageMapper.selectboardWriteList(userId);
	}
	//댓글리스트
	@Override
	public List<Map<String, Object>> getCommentWriteList(String userId) {
		return mypageMapper.selectCommentWriteList(userId);
	}

}
