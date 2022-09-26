package com.gd.lms.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.mapper.SubjectMapper;
import com.gd.lms.vo.Subject;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class SubjectService implements ISubjectService{
	@Autowired SubjectMapper subjectMapper;
	
	
	//강좌 리스트
	@Override
	public List<Subject> getSubjectList() {
		
		return subjectMapper.selectSubjectList();
	}
	
	//강좌 추가
	@Override
	public int addSubject(Subject subject) {
		
		int row = subjectMapper.addSubject(subject);
		
		log.debug(TeamColor.SSH + "추가 결과 : " + row);
		
		
		return row;
	}

	//강좌보기
	@Override
	public Map<String, Object> getSubjectOne(int subjectNo) {
		
		Map<String, Object> subjectOne = subjectMapper.selectSubjectOne(subjectNo);
		
		log.debug(TeamColor.SSH + "상세값 넘기기 : " + subjectOne);
		
		return subjectOne;
	}
	
	//강좌 수정
	@Override
	public int updateSubject(Subject subject) {
		
		int row = subjectMapper.updateSubject(subject);
		
		return row;
	}

	//강좌 삭제
	@Override
	public int deleteSubject(int subjectNo) {
		
		int row = subjectMapper.deleteSubject(subjectNo);
		
		return row;
	}

}
