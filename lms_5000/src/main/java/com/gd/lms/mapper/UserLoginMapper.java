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
	
	//회원가입시 사용자의 정보 통합으로 담는 곳
	int insertUser(User user);
	
	//회원가입시 관리자 정보 담기
	int insertAdmin(Admin admin);
	
	//회원가입시 학생 정보 담기
	int insertStudent(Student student);
	
	//회원가입시 교수 정보 담기
	int insertProfessor(Professor professor);
	

}
