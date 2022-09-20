package com.gd.lms.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.gd.lms.vo.Admin;
import com.gd.lms.vo.Professor;
import com.gd.lms.vo.Student;
import com.gd.lms.vo.User;

@Mapper
public interface UserLoginMapper {
	//회원가입 아이디 중복검사
	int selectUserIdCheck(String userId);
	
	//id,pw로 user 로그인과 최소한의 정보 담기
	User selectUserLogin(User user);
	
	//로그인된 유저 id로 마이페이지 정보 조회
	User selectUserInfo(String userId);
	
	//회원가입시 사용자의 정보 통합으로 담는 곳
	int insertUser(User user);
	
	//회원가입시 관리자 정보 담기
	int insertAdmin(Admin admin);
	
	//회원가입시 학생 정보 담기
	int insertStudent(Student student);
	
	//회원가입시 교수 정보 담기
	int insertProfessor(Professor professor);
	
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
	
		
		

}
