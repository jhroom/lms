package com.gd.lms.commons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.gd.lms.service.IMessageService;
import com.gd.lms.service.IUserListService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component		//애도 객체가 있어야 어플리케이션에서 찾아서 실행 할거다
public class UserScheduler {
	
	@Autowired IUserListService userListService;
	@Autowired IMessageService messageService;
	
	//매일 오후 18시마다 실행
	@Scheduled(cron = "0 0 18 * * *")
	public void modifyUserActiveN() {
		
		//디버깅
		log.debug(TeamColor.JCH + this.getClass() + "휴면계정 처리");
								
		//정해준 시간마다 실행 후 휴면처리
		int row = userListService.updateUserActiveByLastLogin();
		System.out.println("휴면계정 확인 : " + row);
	}
	
	//매일 00시에 실행
	@Scheduled(cron = "0 0 0 * * *")
	public void deleteMessage() {
		//디버깅
		log.debug(TeamColor.JCH + this.getClass() + "메시지 삭제 처리 ( 60일이상 )");
		
		int row = messageService.deleteMessage();
		System.out.println("삭제된 메시지 확인 : " + row);
	}
	

}
