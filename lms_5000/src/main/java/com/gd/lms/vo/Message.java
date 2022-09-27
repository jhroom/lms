package com.gd.lms.vo;

import lombok.Data;

@Data
public class Message {
	//메시지 번호
	private int messageNo;	
	//메시지 제목
	private String messageTitle;
	//메시지 내용
	private String messageContent;		
	//생성일
	private String createTime;			
	//메시지 상태 ( 읽음,안읽음 ) 기본값은 N(읽지않음)
	private String messageState;		
	//받는사람 ID
	private String receiveId;	
	//보낸사람 ID
	private String sendId;				
	
}
