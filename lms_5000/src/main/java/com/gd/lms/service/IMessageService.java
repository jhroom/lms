package com.gd.lms.service;

import java.util.List;

import com.gd.lms.vo.Message;
import com.gd.lms.vo.User;

public interface IMessageService {

	//메시지 리스트 출력
	public List<Message> selectMessageList(String id);
	
	//메시지 리스트 출력( 내가 보낸거 )
	public List<Message> selectSendMessageList(String id);
	
	//메시지 리스트 출력( 내가 받은거 )
	public List<Message> selectReceiveMessageList(String id);
	
	//메시지 상세보기
	public List<Message> selectMessageOne(int messageNo);
	
	//메시지 확인여부 업데이트
	public int updateMessageState(Message message);
	
	//메시지 보내기
	public int insertMessage(Message message);
}
