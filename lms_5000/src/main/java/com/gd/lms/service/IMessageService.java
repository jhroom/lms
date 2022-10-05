package com.gd.lms.service;

import java.util.List;
import java.util.Map;

import com.gd.lms.vo.Message;
import com.gd.lms.vo.User;

public interface IMessageService {

	//메시지 리스트 출력
	public List<Message> selectMessageList(String sendId,String receiveId, int currentPage , int rowPerPage);
	
	//메시지 리스트 출력( 내가 보낸거 )
	public List<Message> selectSendMessageList(String sendId , int currentPage , int rowPerPage);
	
	//메시지 리스트 출력( 내가 받은거 )
	public List<Message> selectReceiveMessageList(String receiveId , int currentPage , int rowPerPage);
	
	//메시지 상세보기
	public List<Message> selectMessageOne(int messageNo);
	
	//메시지 확인여부 업데이트
	public int updateMessageState(Message message);
	
	//메시지 보내기
	public int insertMessage(Message message);
	
	//메시지 삭제
	public int deleteMessage();
	
	//마지막 페이지 - 전체
	public int lastPageMessage(String sendId,String receiveId);
	
	//마지막 페이지 - 본인이 보냈을때.
	public int lastPageSendMessage(String sendId);
	
	//마지막 페이지 - 본인이 받았을때.
	public int lastPageReceiveMessage(String receiveId);

}
