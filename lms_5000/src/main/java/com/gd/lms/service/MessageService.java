package com.gd.lms.service;

import java.util.List;
import java.util.Map;

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
	public List<Message> selectMessageList(String sendId,String receiveId, int currentPage , int rowPerPage) {
		int beginRow = (currentPage-1)*rowPerPage;
		
		//List 세팅
		List<Message> list = messageMapper.selectMessgeList(sendId , receiveId , beginRow , rowPerPage);
		
		//디버그
		log.debug(TeamColor.JCH + this.getClass() + "MessageList 체크");
		return list;
	}

	//보낸 메시지
	@Override
	public List<Message> selectSendMessageList(String sendId , int currentPage , int rowPerPage) {
		int beginRow = (currentPage-1)*rowPerPage;
		
		//List 세팅
		List<Message> list = messageMapper.selectSendMessageList(sendId,beginRow,rowPerPage);
		
		//디버그
		log.debug(TeamColor.JCH + this.getClass() + "MessageList 체크");
		return list;
	}

	//받은 메시지
	@Override
	public List<Message> selectReceiveMessageList(String receiveId, int currentPage , int rowPerPage) {
		int beginRow = (currentPage-1)*rowPerPage;
		
		//List 세팅
		List<Message> list = messageMapper.selectReceiveMessageList(receiveId,beginRow,rowPerPage);
		
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
	public int updateMessageState(Message message) {
		
		
		int row = messageMapper.updateMessageState(message.getReceiveId() , message.getMessageNo());
		
		System.out.println(message.getReceiveId());
		//디버그, messageNo
		log.debug(TeamColor.JCH + this.getClass() + "메시지 확인여부 업데이트.");
		
		return row;
	}

	@Override
	public int insertMessage(Message message) {
		
		int row = messageMapper.insertMessage(message);
		
		//디버그
		log.debug(TeamColor.JCH + this.getClass() + "메시지 보내기 ( 메시지 insert ) ");
		return row;
	}

	@Override
	public int deleteMessage() {
		log.debug(TeamColor.JCH + this.getClass() + "메시지 삭제 ");
		return messageMapper.deleteMessage();
	}

	//보낸 메시지 카운팅
	@Override
	public int lastPageSendMessage(String sendId) {
		//디버깅
		log.debug(TeamColor.JCH + this.getClass() + "보낸 메시지 갯수 카운팅");
		return messageMapper.countSendMessage(sendId);
	}

	//받은 메시지 카운팅
	@Override
	public int lastPageReceiveMessage(String receiveId) {
		//디버깅
		log.debug(TeamColor.JCH + this.getClass() + "받은 메시지 갯수 카운팅");
		return messageMapper.countReceiveMessage(receiveId);
	}

	@Override
	public int lastPageMessage(String sendId, String receiveId) {
		//디버깅
		log.debug(TeamColor.JCH+this.getClass() +"전체 메시지 갯수 카운팅");
		return messageMapper.countMessage(sendId, receiveId);
	}



}
