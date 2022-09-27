package com.gd.lms.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gd.lms.vo.Message;

@Mapper
public interface MessageMapper {
	
	//메시지 리스트 출력 ( 전체 )
	List<Message> selectMessgeList(String id);

	//메시지 리스트 출력 ( 발신 )
	List<Message> selectSendMessageList(String id);
	
	//메시지 리스트 출력 ( 수신 )
	List<Message> selectReceiveMessageList(String id);
	
	//메시지 상세보기
	public List<Message> selectMessageOne(int messageNo);
	
	//메시지 읽음표시 업데이트
	public int updateMessageState(String id);
}
