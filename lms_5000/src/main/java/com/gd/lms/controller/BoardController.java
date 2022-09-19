package com.gd.lms.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gd.lms.service.IBoardService;
import com.gd.lms.vo.Board;
import com.gd.lms.vo.BoardPost;


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
		model.addAttribute("lectureNo",lectureNo);
		
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
	public String getBoardPostList(int boardNo, String boardName, Model model) {
		
		//파라미터 확인 디버깅
		System.out.println("[boardCtrl] boardNo : " + boardNo);	
		System.out.println("[boardCtrl] boardName : " + boardName);	
		

		
		//넘겨줄 리스트(게시판)
		List<BoardPost> list = boardService.getBoardPostList(boardNo);
		
		
		//값 넘겨주기
		model.addAttribute("boardPostList",list);
		model.addAttribute("boardName",boardName);
		model.addAttribute("boardNo",boardNo);
		


		//디버깅
		System.out.println("[boardCtrl] boardPost list : " + list);		
		System.out.println("[boardCtrl] boardPost 리스트 생성 및 포워딩");
		
		
		//디버깅
		System.out.println("[boardCtrl] boardPost 포워딩");
		
		//포워딩
		return "board/boardPost";
		
	}
	
	//게시글 상세 페이지 출력 메서드
	@GetMapping("/board/post/one")
	public String getBoardPostOne(int boardPostNo, String boardName, int boardNo, Model model) {
		

		//파라미터 확인 디버깅
		System.out.println("[boardCtrl] boardPostNo : " + boardPostNo);	
		
		//넘겨줄 값(BoardPost)
		BoardPost boardPost = boardService.getBoardPostOne(boardPostNo);
		
		//값 넘겨주기
		model.addAttribute("boardPost",boardPost);
		model.addAttribute("boardName",boardName);
		model.addAttribute("boardNo",boardNo);
		
		//포워딩
		return "board/boardOne";
		
	}
	
	//게시글 추가 폼 전송 메서드
	@GetMapping("/board/post/add/form")
	public String directAddBoardPost(int boardNo, String boardName, Model model) {

		//파라미터 확인 디버깅
		System.out.println("[boardCtrl] boardNo : " + boardNo);	
		
		//값 넘겨주기
		model.addAttribute("boardName",boardName);
		model.addAttribute("boardNo",boardNo);
		
		return "board/addBoardPost";
	}
	
	
	
	//게시글 추가 메서드
	@PostMapping("/board/post/add")
	public String addBoardPost(Board board, BoardPost boardPost) {
		
		//파라미터 확인 디버깅
		System.out.println("[boardCtrl] boardPost : " + boardPost);	
		System.out.println("[boardCtrl] board : " + board);	
		
		//파일 넘기는 법 연구 필요
		
		
		
		//리다이렉션
		//return "redirect:/board/post";
		return "board/addBoardPost";
		
	}
	
	//게시판 추가 메서드
	@GetMapping("/board/add/form")
	public String directAddBoard(int lectureNo, Model model) {
		
		//파라미터 확인 디버깅
		System.out.println("[boardCtrl] lectureNo : " + lectureNo);	
		
		
		model.addAttribute("lectureNo", lectureNo);
		
		//포워팅
		return "board/addBoard";
	}
	
	//게시판 추가 메서드
	@GetMapping("/board/add")
	public String addBoard(Board board) {
		
		//파라미터 확인 디버깅
		System.out.println("[boardCtrl] board : " + board);	
		
		//추가할 게시판 내용
		int row = boardService.addBoard(board);
		
		//추가 여부 확인 디버깅
		System.out.println("[boardCtrl] row : " + row);	
		
		//포워팅
		return "redirect:/board/list?lectureNo="+board.getLectureNo();
	}

}
