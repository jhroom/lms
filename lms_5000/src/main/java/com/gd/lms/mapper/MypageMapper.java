package com.gd.lms.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gd.lms.vo.Paging;
import com.gd.lms.vo.User;

@Mapper
public interface MypageMapper {
	
	//마이페이지 학생 정보
	Map<String, Object> selectStudentInfo(String userId);
	
	//마이페이지 교수 정보
	Map<String, Object> selectProfessorInfo(String userId);
	
	//마이페이지 운영자 정보
	Map<String, Object> selectAdminInfo(String userId);
	
	//마이페이지 시스템관리자 정보
	Map<String, Object> selectSystemInfo(String userId);
	
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
	
	//운영자id로 게시글 작성 리스트
	List<Map<String, Object>> selectAdminBoardList(Paging paging);
	
	//학생,교수 Id로 게시글 작성 리스트 가져오기
	List<Map<String, Object>> selectboardWriteList(Paging paging);
	
	//학생,교수 Id로 게시글 작성 개수 가져오기
	int selectBoardCount(String userId);
	
	//운영자 게시글 작성 개수
	int selectNoticeCount(String userId);
	
	//학생,교수Id로 댓글 작성 리스트 가져오기
	List<Map<String, Object>> selectCommentWriteList(String userId);
	
}
