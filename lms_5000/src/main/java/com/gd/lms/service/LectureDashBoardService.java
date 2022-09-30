package com.gd.lms.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.mapper.LectureDashBoardMapper;
import com.gd.lms.vo.AttendanceForm;
import com.gd.lms.vo.Board;
import com.gd.lms.vo.Lecture;
import com.gd.lms.vo.Sign;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class LectureDashBoardService implements ILectureDashBoadService {
	@Autowired LectureDashBoardMapper lectureDashBoardMapper;	
	//////////////////////////기타 게시판 /////////////////////////////
	// 기타 게시판 생성
	@Override
	public int addSubBoard(Board board) {
		int addSubBoard = lectureDashBoardMapper.insertSubBoard(board);
		// 과제 제출 게시판 작동 확인
		log.debug(TeamColor.YHW + "-- addSubBoard-service--"+ addSubBoard );
		return addSubBoard;
	}
	////////////////////////// 과제관련 게시판 /////////////////////////////
	// 과제 제출 게시판 생성
	@Override
	public int addAssignmentBoard(Board board) {
		int addAssignmentBoard=lectureDashBoardMapper.insertBoard(board);
		// 과제 제출 게시판 작동 확인
		log.debug(TeamColor.YHW + "-- addAssignmentBoard-service--"+ addAssignmentBoard );
		
		
		return addAssignmentBoard;
	}
	
	// 과제 제출 개시판
	@Override
	public List<Map<String, Object>> getAssignment(Board lectureNo) {
		List<Map<String, Object>> getAssignment = lectureDashBoardMapper.assignmentBoardList(lectureNo);
		// 과제 제출 게시판 확인
		log.debug(TeamColor.YHW + "-- getAssignment-service--"+ getAssignment );
		return getAssignment;
	}
	
	//학생페이지에서 볼 수 있는 개인 출석 현황.
	@Override
	public List<Map<String, Object>> stuAttendance(int lectureNo, String userId) {
		//디버깅
		log.debug(TeamColor.JCH + this.getClass() + "학생 출결 리스트 확인");
		
		List<Map<String,Object>> stuAtt = lectureDashBoardMapper.sutAttendance(lectureNo , userId);
		System.out.println(stuAtt);
		System.out.println(lectureNo + "수강 번호 확인");
		return stuAtt;
	}

	@Override
	public List<Map<String,Object>> weekList(int lectureNo) {
		return lectureDashBoardMapper.weekList(lectureNo);
	}
	
	@Override
	public List<Map<String, Object>> getStudentListForAtt(Lecture lecture, int week) {
		Map<String, Object> param = new HashMap<>();
		param.put("lectureNo", lecture.getLectureNo());
		param.put("userId", lecture.getUserId());
		param.put("week", week);
		
		return lectureDashBoardMapper.selectStudentListForAtt(param);
	}
	
	//학생 출석 서비스
	@Override
	public boolean addStudentAttendance(AttendanceForm attForm) {
		boolean result = true;
		log.debug(TeamColor.AJH + "서비스시작 파라미터 확인 attForm : " + attForm);
		
		String [] arrStudent = attForm.getStudentId();
		log.debug(TeamColor.AJH + "값 확인 / arrStudent : " + Arrays.toString(arrStudent));
		
		int [] arrAttState = attForm.getAttendState();
		log.debug(TeamColor.AJH + "값 확인 / arrAttState : " + Arrays.toString(arrAttState));
		
		int [] row = new int [arrStudent.length];
		log.debug(TeamColor.AJH + "값 확인 / row : " + Arrays.toString(row));
		
		for(int i=0; i<row.length; i++) {
			AttendanceForm temp = attForm;
			temp.setStudentOne(arrStudent[i]);
			temp.setAttStateOne(arrAttState[i]);
			
			// 주차,학생id,강의no로 출석 정보가 있으면 1 없으면 0 리턴
			row[i] = lectureDashBoardMapper.selectStudentAttData
							(attForm.getWeek(), arrStudent[i], attForm.getLectureNo()) == null? 0 : 1;
			log.debug(TeamColor.AJH + "조회 결과 값 확인 / row["+i+"] : " + row[i]);
			
			// 위의 결과를가지고 insert , update 실행
			if(row[i] == 0) {
				row [i] = lectureDashBoardMapper.insertStudentAttendance(temp);
				log.debug(TeamColor.AJH + "insert 결과 값 확인 / row["+i+"] : " + row[i]);
				if( row[i] == 0) {
					result = false;
				}
			}
			else if(row[i] == 1) {
				row [i] = lectureDashBoardMapper.updateStudentAttendance(temp);
				log.debug(TeamColor.AJH + "update 결과 값 확인 / row["+i+"] : " + row[i]);
				if( row[i] == 0) {
					result = false;
				}
			}
		}
		return result;
	}
	// 교수의 출석페이지의 강의 정보
	@Override
	public Map<String, Object> getLectureInfo(Lecture lecture) {
		return lectureDashBoardMapper.selectLectureInfo(lecture);
	}
	
	//최근 개시글 리스트 10건 
	@Override
	public List<Map<String, Object>> getRecentBoard(int lectureNo) {
		//파라미터 값 확인 디버깅
		log.debug(TeamColor.KHJ + "파라미터 확인 lectureNo : " + lectureNo);
		
		//리스트 생성
		List<Map<String, Object>> list = lectureDashBoardMapper.selectRecentBoard(lectureNo);
		
		
		//리턴
		return list;
	}
	
	//강좌별 대시보드 진입시 사용여부 검사
	@Override
	public boolean getDashBoardCheck(String userId, int lectureNo, int userLevel) {
		
		boolean result = false;
		Map<String,Object> row = null;
		
		if(userLevel == 1) {
			result = true;
		} else if(userLevel == 2) {
			Lecture setLecture = new Lecture();
			setLecture.setLectureNo(lectureNo);
			setLecture.setUserId(userId);
			row = lectureDashBoardMapper.selectLectureInfoCheckPro(setLecture);
			log.debug(TeamColor.AJH + "교수 대시보드 유효 검사 : " + row);
		}
		else if(userLevel == 3) {
			Sign sign = new Sign();
			sign.setLectureNo(lectureNo);
			sign.setUserId(userId);
			row = lectureDashBoardMapper.selectSignInfoCheckStu(sign);
			log.debug(TeamColor.AJH + "학생 대시보드 유효 검사 : " + row);
		}
		if(row != null) {
			result = true;
		}
		return result;
	}

}
