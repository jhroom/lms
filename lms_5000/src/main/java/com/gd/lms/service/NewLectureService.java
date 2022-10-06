package com.gd.lms.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.mapper.NewLectureMapper;
import com.gd.lms.vo.Lecture;
import com.gd.lms.vo.Professor;
import com.gd.lms.vo.Week;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class NewLectureService implements INewLectureService {
	@Autowired NewLectureMapper newLectureMapper;
	
	// 리스트
		@Override
		public List<Lecture> getLectureList() {
			
			
			return newLectureMapper.selectLectureList();
		}
		// 추가
		@Override
		public int addLecture(Lecture lecture) {
			
			int row = newLectureMapper.addLecture(lecture);
			
			
			return row;
		}

		// 수정
		@Override
		public int updateLecture(Lecture lecture) {
			
			int row = newLectureMapper.updateLecture(lecture);
			
			return row;
		}

		// 삭제
		@Override
		public int deleteLecture(int lectureNo) {
			
			int row = newLectureMapper.deleteLecture(lectureNo);
			
			return row;
		}

		// 상세보기
		@Override
		public Map<String, Object> getLectureOne(int lectureNo) {
			 
			Map<String, Object> lectureOne = newLectureMapper.selectLectureOne(lectureNo);
			
			log.debug(TeamColor.SSH + "상세값 넘기기" + lectureOne);
			
			return lectureOne;
		}
		
		// 교수 리스트 가져오기
		@Override
		public List<Professor> getProList() {
			
			
			return newLectureMapper.getProList();
		}
		
		// 강의 추가시 출석 주차 생성
		@Override
		public int addWeek(Week week) {

//			//연산 확인
//			try {
//				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//				
//			//날짜 객체 입력	null=학기 시작날짜
//			Date date = formatter.parse(null);
//			Calendar cal = Calendar.getInstance();
//			cal.setTime(date);
//			
//			//리턴값 
//			int row = 0;
//			
//			//for 
//			int i = 0;
//			for(i=1; i<16; i++) {
//			
//			//마지막날 세팅
//			String startDay = cal.toString();
//				
//			//7일 후 세팅
//			cal.add(Calendar.DATE, + 7);
//			
//			//날짜의 문자열 변환
//			String endDay = cal.toString();
//			
//			//입력
//			row += newLectureMapper.addWeek(i, lectureNo, startDay, endDay);
//			
//		}
//		
//		}
//
//        }
//        
//     //오류 시 false 리턴
//     } catch (ParseException e) {
//        e.printStackTrace();
        return 0;
     } 
  }
  
