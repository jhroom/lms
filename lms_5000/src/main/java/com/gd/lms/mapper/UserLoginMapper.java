package com.gd.lms.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.gd.lms.vo.Admin;
import com.gd.lms.vo.Professor;
import com.gd.lms.vo.Student;
import com.gd.lms.vo.User;

@Mapper
public interface UserLoginMapper {
	
	int selectUserIdCheck(String userId);
	
	User selectUserLogin(User user);
	
	int insertUser(User user);
	
	int insertAdmin(Admin admin);
	
	int insertStudent(Student student);
	
	int insertProfessor(Professor professor);
		

}
