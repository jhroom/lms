package com.gd.lms.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.mapper.UserLoginMapper;
import com.gd.lms.vo.Admin;
import com.gd.lms.vo.Professor;
import com.gd.lms.vo.Student;
import com.gd.lms.vo.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class UserLoginService implements IUserLoginService {

	@Autowired UserLoginMapper userLoginMapper;
	
	// 로그인시 입력한 id,pw 정보로 계정 유무 조회
	@Override
	public User getUserLogin(User user) {
		User temp = userLoginMapper.selectUserLogin(user);
		
		return temp;
	}
	
	// 휴면계정 로그인시 정보 유무 확인
	@Override
	public String getRestUserCheck(User user) {
		return userLoginMapper.selectRestUserLogin(user);
	}
	
	//휴면 계정 활성화
	@Override
	public int modifyRestUserActive(String userId) {
		return userLoginMapper.updateRestUserActive(userId);
	}
	
	//운영자 회원가입
	@Override
	public boolean addAdmin(User user, int positionNo) {
		boolean result = false;
		// user로 User 테이블 INSERT
		int row = userLoginMapper.insertUser(user);
		log.debug(TeamColor.AJH + " insert 결과" + row);
		
		if(row == 1) {
			Admin admin = new Admin();
			admin.setUserId(user.getUserId());
			admin.setAdminName(user.getUserName());
			admin.setAdminEmail(user.getUserEmail());
			admin.setAdminTel(user.getUserTel());
			admin.setAdminGender(user.getUserGender());
			admin.setPositionNo(positionNo);
			
			int adminRow = userLoginMapper.insertAdmin(admin);
			result = adminRow == 1? true:false;
		}
		return result;
	}
	//회원가입시 Id 중복검사
	@Override
	public boolean getUserIdCheck(String userId) {
		boolean result = false;
		int row = userLoginMapper.selectUserIdCheck(userId);
		//userId 와 같은 id 개수가 0개라면 (중복 된 아이디가 없다면)
		if( row == 0) {
			result = true;	//결과는 참
		}
		return result;
	}
	//학생 or 교수 회원가입
	@Override
	public boolean addStudentOrPro(User user, int majorNo) {
		boolean result = false;
		
		int userRow = userLoginMapper.insertUser(user);
		
		if(user.getUserLevel() == 3) {
		
			//user 와 student 같이 insert하기위해 student에 user 정보 주입
			Student student = new Student();
			student.setUserId(user.getUserId());
			student.setStName(user.getUserName());
			student.setStEmail(user.getUserEmail());
			student.setStTel(user.getUserTel());
			student.setStGender(user.getUserGender());
			student.setMajorNo(majorNo);
			
			if(userRow == 1) {	// user가 insert 성공 했을 때
				// 학생 정보 INSERT
				int row = userLoginMapper.insertStudent(student);
				
				if( row == 1) {	// student insert가 성공 했을 때 리턴 값 true
					result = true;
				}
			}
		}// end user Level 이 학생일 때
		
		else if(user.getUserLevel() == 2) {	// 가입한 유저레벨이 교수일 떄
			Professor professor = new Professor();
			professor.setUserId(user.getUserId());
			professor.setProName(user.getUserName());
			professor.setProEmail(user.getUserEmail());
			professor.setProTel(user.getUserTel());
			professor.setProGender(user.getUserGender());
			professor.setMajorNo(majorNo);
			
			
			if(userRow == 1) {	// user가 insert 성공 했을 때
				// 교수 정보 INSERT
				int row = userLoginMapper.insertProfessor(professor);
				if( row == 1) {	// professor insert가 성공 했을 때 리턴 값 true
					result = true;
				}
			}
		}// end user Level 이 교수 일 때
		
		return result;
	}
	//로그인시 마지막 로그인날짜 업데이트
	@Override
	public void modifyUserLastLogin(String userId) {
		int row = userLoginMapper.updateUserLastLogin(userId);
		log.debug(TeamColor.AJH + "마지막 로그인 업데이트 결과 : " + row);
	}
	

}
