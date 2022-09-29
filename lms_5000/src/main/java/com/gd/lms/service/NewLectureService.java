package com.gd.lms.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.mapper.NewLectureMapper;
import com.gd.lms.vo.Lecture;
import com.gd.lms.vo.Professor;

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

}
