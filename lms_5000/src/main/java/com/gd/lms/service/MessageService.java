package com.gd.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.mapper.MessageMapper;
import com.gd.lms.vo.Message;
import com.gd.lms.vo.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class MessageService implements IMessageService {
	@Autowired MessageMapper messageMapper;
	
	//메시지 리스트 출력 ( 세션아이디값에 따른 메시지함 )
	@Override
	public List<Message> selectMessageList(String id) {
		//List 세팅
		List<Message> list = messageMapper.selectMessgeList(id);
		
		//디버그
		log.debug(TeamColor.JCH + this.getClass() + "MessageList 체크");
		return list;
	}

	//보낸 메시지
	@Override
	public List<Message> selectSendMessageList(String id) {
		//List 세팅
		List<Message> list = messageMapper.selectSendMessageList(id);
		
		//디버그
		log.debug(TeamColor.JCH + this.getClass() + "MessageList 체크");
		return list;
	}

	//받은 메시지
	@Override
	public List<Message> selectReceiveMessageList(String id) {
		//List 세팅
		List<Message> list = messageMapper.selectReceiveMessageList(id);
		
		//디버그
		log.debug(TeamColor.JCH + this.getClass() + "MessageList 체크");
		return list;
	}

	//메시지 상세보기
	@Override
	public List<Message> selectMessageOne(int messageNo) {
		// 상세보기
		List<Message> messageOne = messageMapper.selectMessageOne(messageNo);
		
		//디버그
		log.debug(TeamColor.JCH + this.getClass() + "메시지 상세보기");
		return messageOne;
	}

	//메시지 확인시 확인여부를 N에서 Y로 업데이트.
	@Override
	public int updateMessageState(String id) {
		
		int row = messageMapper.updateMessageState(id);
		
		//디버그
		log.debug(TeamColor.JCH + this.getClass() + "메시지 확인여부 업데이트.");
		
		return row;
	}

}
