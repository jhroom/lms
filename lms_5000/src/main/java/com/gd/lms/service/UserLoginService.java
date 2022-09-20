package com.gd.lms.service;

import java.util.Map;

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
	
	@Override
	public User getUserLogin(User user) {
		User temp = userLoginMapper.selectUserLogin(user);
		
		return temp;
	}

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
	
	@Override
	public User getUserInfo(String userId) {
		//세션이 담긴 아이디로 마이페이지에 보일 나의 정보 가져오기
		return userLoginMapper.selectUserInfo(userId);
	}
	
	@Override
	public int modifyUserInfo(Map<String, Object> map) {
		int row = -1;
		int levelRow = -1;
		
		String userId = (String)map.get("userId");
		String userInfo = (String)map.get("userInfo");
		int userLevel = (int)map.get("userLevel");
		
		System.out.println(TeamColor.AJH+"파라미터 레벨 확인 :" + userLevel);
		
		if( ((String)map.get("userInfo")).contains("@")) {
			System.out.println(TeamColor.AJH+"파라미터 형식 이메일");
			
			//통합 계정 이메일 변경
			row = userLoginMapper.modifyUserEmail(userInfo, userId);
			
			// 레벨에 따른 계정 이메일 변경
			switch(userLevel) {
				case 1 : levelRow = userLoginMapper.modifyAdminEmail(userInfo, userId);break;
				case 2 : levelRow = userLoginMapper.modifyProEmail(userInfo, userId);break;
				case 3 : levelRow = userLoginMapper.modifyStudentEmail(userInfo, userId);break;
			}
		} else {
			System.out.println(TeamColor.AJH+"파라미터 형식 번호");
			
			//통합 계정 번호 변경
			row = userLoginMapper.modifyUserTel(userInfo, userId);
			
			//레벨에 따른 계정 번호 변경
			switch(userLevel) {
				case 1 : levelRow = userLoginMapper.modifyAdminTel(userInfo, userId);break;
				case 2 : levelRow = userLoginMapper.modifyProTel(userInfo, userId);break;
				case 3 : levelRow = userLoginMapper.modifyStudentTel(userInfo, userId);break;
			}
		}
		
		if(row == 1 && levelRow == 1) {
			System.out.println(TeamColor.AJH+"정보 변경 성공 : " + row);
			System.out.println(TeamColor.AJH+"계층에따른 정보 변경 성공 : " + levelRow);
		}
		
		return row;
	}

}
