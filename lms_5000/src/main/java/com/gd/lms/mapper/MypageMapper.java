package com.gd.lms.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.gd.lms.vo.User;

@Mapper
public interface MypageMapper {
	
	//로그인된 유저 id로 마이페이지 정보 조회
	User selectUserInfo(String userId);
	
	//마이페이지 이메일 변경
	int modifyUserEmail(String userEmail, String userId);
	
	//운영자 이메일 변경
	int modifyAdminEmail(String userEmail, String userId);
		
	//학생 이메일 변경
	int modifyStudentEmail(String userEmail, String userId);
	
	//교수 이메일 변경
	int modifyProEmail(String userEmail, String userId);
	
	//마이페이지 번호 변경
	int modifyUserTel(String userTel, String userId);
	
	//운영자 번호 변경
	int modifyAdminTel(String userTel, String userId);
	
	//학생 번호 변경
	int modifyStudentTel(String userTel, String userId);
	
	//교수 번호 변경
	int modifyProTel(String userTel, String userId);
	
	//비빌번호 변경시 기존 비밀번호 확인
	User selectPwCheck(User user);
	
	//비밀번호 변경
	int modifyUserPw(User user);

}
