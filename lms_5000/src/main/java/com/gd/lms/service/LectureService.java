package com.gd.lms.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.mapper.LectureMapper;
import com.gd.lms.vo.Sign;
import com.gd.lms.vo.SignCancel;
import com.gd.lms.vo.Subject;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class LectureService implements ILectureService {
	@Autowired LectureMapper lecturemapper;
	
	
	@Override
	// 수강신청을 위한 개설강좌 목록
	public List<Map<String, Object>> selectLectureListForSign(int beginRow, int rowPerPage) {
		List<Map<String, Object>> Lecturelist = lecturemapper.selectLectureListForSign(beginRow,rowPerPage);
		//디버깅
		log.debug(TeamColor.YHW + "-- Lecturelist-service--"+ Lecturelist );
		return Lecturelist;
	}
	
	

	@Override
	// 학생 선택 과목 add
	public int addSign(Sign sign){
		//파라미터 값 확인
		log.debug(TeamColor.KHJ + "파라미터 값 확인 / sign : "+ sign );
				
		//리턴값 세팅
		int addSign = 0;
		
		// 수강 신청 여부 확인
		int check = lecturemapper.selectSignHistory(sign);
		
		
		//수강 신청 이력이 없을 경우에만 삽입 실행
		if(check == 0) {		
			//삽입 쿼리 실행
			addSign = lecturemapper.insertSign(sign);
			
		}

		
		//디버깅
		log.debug(TeamColor.YHW + "-- addSign-service -- "+ addSign );
		return addSign;
	}

	@Override
	// 학생 수강신청 목록
	public List<Map<String, Object>> signList(Sign userId) {
		List<Map<String, Object>> SignList = lecturemapper.selectSignList(userId);
		//디버깅
		log.debug(TeamColor.YHW + "-- SignList-service -- "+ SignList );
		return SignList;
	}

	@Override
	// 수강 취소
	public int removeSign(Sign sign) {
		int removeSign = lecturemapper.deleteSign(sign);
		//디버깅
		log.debug(TeamColor.YHW + "-- removeSign-service -- "+ removeSign );
		return removeSign;
	}
	
	@Override
	// 수강 취소 과목 입력
	public int addCancleSign(SignCancel signCancel) {
		int addCancleSign = lecturemapper.insertCancelSign(signCancel);
		//디버깅
		log.debug(TeamColor.YHW + "-- addCancleSign-service -- "+ addCancleSign );
		return addCancleSign;
	}

	@Override
	// 수강 취소 리스트
	public List<Map<String, Object>> selectCancelSignList(SignCancel userId) {
		List<Map<String, Object>> CancelList = lecturemapper.selectCancelSignList(userId);
		//디버깅
		log.debug(TeamColor.YHW + "-- CancelList-service -- "+ CancelList );
		return CancelList;
	}

	@Override
	public int getSignTime(Sign sign) {
		// 리턴값 세팅
		int time = lecturemapper.selectSignTime(sign);
		
		
		//리턴
		return time;
	}

	//학기 기간에 따른 수강 페이지 진입 여부 결정 값 생성 서비스
	@Override
	public boolean getSemesterCheck() {
		//
		
		//오늘 날짜 생성
		Calendar today = Calendar.getInstance();
		
		//디버깅
		log.debug(TeamColor.KHJ + "캘린더 객체 확인 "+ today);
		
		//학기 구분값 입력
		int month = today.get(Calendar.MONTH)<6? 1:2;
		int year =  today.get(Calendar.YEAR);

		
		//학기 시작 시간 추출 쿼리 실행
		String semester = lecturemapper.selectSemester(year, month);
		
		//디버깅
		log.debug(TeamColor.KHJ + "학기 확인 "+ semester);
		

		
		//연산 확인
		try {
			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); 
			
			//학기 시작 날짜 객체 입력
			Date date = formatter.parse(semester);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			
			//학기 시작 날짜 -7 객체 입력
			Calendar cal2 = Calendar.getInstance();
			cal2.setTime(date);
			cal2.add(Calendar.DATE, -7);
			
			//디버깅
			log.debug(TeamColor.KHJ + "학기 시작일 확인 "+ cal);
			log.debug(TeamColor.KHJ + "학기 시작일 -7 확인 "+ cal2);

			
			//리턴
			//기간일 경우 true리턴
			if(today.before(cal)&&today.after(cal2)) {
				return true;
			
			//기간이 아닐 경우 false 리턴
			} else {
				return false;
			}
			
		//오류 시 false 리턴
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} 
	}
	
	/////// 페이징 
	@Override
	// 강좌 갯수
	public int getTotal() {
		int getTotal = lecturemapper.getTotal();
		return getTotal;
	}
}
