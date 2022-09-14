package com.gd.lms_5000.vo;

import lombok.Data;

@Data
public class Message {
	private int messageNo;
	private String messageContent;
	private String createTime;
	private String messageState;
	private String receiveId;
	private String sendId;
	
}
