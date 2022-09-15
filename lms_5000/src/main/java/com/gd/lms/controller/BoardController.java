package com.gd.lms.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gd.lms.service.IBoardService;
import com.gd.lms.vo.Board;


@Controller
public class BoardController {
	//서비스 객체 생성
	
	@Autowired IBoardService boardService;
	
	
	//게시판 리스트 출력 메서드
	@GetMapping("/board/list")
	public String getboardList(int lectureNo, Model model) {
		
		//파라미터 확인 디버깅
		System.out.println("[boardCtrl] lectureNo : " + lectureNo);	
		
		
		//일반 변수
		//공지사항 및 qna 게시판 번호를 위한 변수
		int noticeNo = 0;
		int qnaNo = 0;
		
		
		//넘겨줄 리스트(게시판)
		List<Board> list = boardService.getBoardList(lectureNo);
		

		
		//변수 세팅
		for(int i = 0; i<list.size();i++) {
			if(list.get(i).getBoardType() == 1) {
				noticeNo = list.get(i).getBoardNo();
			}
			if(list.get(i).getBoardType() == 2) {
				qnaNo = list.get(i).getBoardNo();
			}
		};
	
		

		//값 넘겨주기
		model.addAttribute("boardList",list);
		model.addAttribute("noticeNo",noticeNo);
		model.addAttribute("qnaNo",qnaNo);
		

		//디버깅
		System.out.println("[boardCtrl] list : " + list);		
		System.out.println("[boardCtrl] board 리스트 생성 및 포워딩");
		
		//포워딩
		return "board/boardList";
		
	}
	
	//게시판 게시글 출력 메서드
	@GetMapping("/board/post")
	public String getBoardPostList(int boardNo, Model model) {
		
		//파라미터 확인 디버깅
		System.out.println("[boardCtrl] boardNo : " + boardNo);	
		
		model.addAttribute("boardNo", boardNo);
		
		
		//디버깅
		System.out.println("[boardCtrl] board 포워딩");
		
		//포워딩
		return "board/boardPost";
		
	}
	
	
	

}
