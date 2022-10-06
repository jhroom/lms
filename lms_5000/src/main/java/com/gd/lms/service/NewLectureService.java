package com.gd.lms.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
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
		public int addWeek(Lecture lecture) {
			
			log.debug(TeamColor.SSH + "lecture :" + lecture);
			
			
			//강의 추가
			int row = newLectureMapper.addLecture(lecture);
			
			log.debug(TeamColor.SSH + "dddd lecture : " + lecture);
			
			
			//학기 정보 확인
			String semesterDate = newLectureMapper.selectSemesterStartDate(lecture.getSemesterNo());
			
			
			
			
			

			//연산 확인
			try {
				
				//날짜 데이터 포멧하기
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				
				//날짜 객체 입력(학기 시작날짜)
				Date date = formatter.parse(semesterDate);
				
				//날짜 객체 생성 및 세팅
				Calendar cal = Calendar.getInstance();
				cal.setTime(date);
				
				
					//for 반복
					
					for(int i=1; i<16; i++) {
					
					//주차 시작일 세팅
					//String startDate = cal.toString();
					
					String startDate = cal.get(Calendar.YEAR) +  "-" + (cal.get(Calendar.MONTH)+1) +  "-" +cal.get(Calendar.DATE) ;
					
					log.debug(TeamColor.SSH + "시작일 세팅" + startDate);
					
						
					//7일 후 세팅
					cal.add(Calendar.DATE, + 7);
					
					//주차 종료일 세팅
					//String endDate = cal.toString();
					String endDate = cal.get(Calendar.YEAR) +  "-" + (cal.get(Calendar.MONTH)+1) +  "-" +cal.get(Calendar.DATE) ;
					
					
					
					log.debug(TeamColor.SSH + "종료일 세팅" + endDate);
					
					
					//입력
					row += newLectureMapper.addWeekK(i, lecture.getLectureNo(), startDate, endDate);
					}
		
		} catch (ParseException e) {
			e.printStackTrace();
			return 0;
	      }
			
			//리턴
			return row; 


        }
        
     
      
  }
  
