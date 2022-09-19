package com.gd.lms.controller;


import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.gd.lms.commons.TeamColor;
import com.gd.lms.service.IBoardService;
import com.gd.lms.vo.Board;
import com.gd.lms.vo.BoardFile;
import com.gd.lms.vo.BoardPost;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class BoardController {
	//서비스 객체 생성
	
	@Autowired IBoardService boardService;
	
	
	//게시판 리스트 출력 메서드
	@GetMapping("/board/list")
	public String getboardList(int lectureNo, Model model) {
		
		//파라미터 확인 디버깅
		log.debug(TeamColor.KHJ + "파라미터 확인 / lectureNo : " + lectureNo);
		
		
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
		log.debug(TeamColor.KHJ + "값 확인 / boardList list : " + list);
		log.debug(TeamColor.KHJ + "board 리스트 생성 및 포워딩");

		
		//포워딩
		return "board/boardList";
		
	}
	
	//게시판 게시글 출력 메서드
	@GetMapping("/board/post")
	public String getBoardPostList(int boardNo, String boardName, Model model) {
		
		//파라미터 확인 디버깅
		System.out.println("[boardCtrl] boardNo : " + boardNo);	
		System.out.println("[boardCtrl] boardName : " + boardName);	
		log.debug(TeamColor.KHJ + "값 확인 / boardNo : " + boardNo);
		log.debug(TeamColor.KHJ + "값 확인 / boardName : " + boardName);
		
		

		
		//넘겨줄 리스트(게시판)
		List<BoardPost> list = boardService.getBoardPostList(boardNo);
		
		
		//값 넘겨주기
		model.addAttribute("boardPostList",list);
		model.addAttribute("boardName",boardName);
		model.addAttribute("boardNo",boardNo);
		


		//디버깅
		log.debug(TeamColor.KHJ + "값 확인 / boardPost list : " + list);
		log.debug(TeamColor.KHJ + "boardPost 리스트 생성 및 포워딩");
		
		
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
	
	
	
	//게시글 추가 메서드-	확인 필요
	@PostMapping("/board/post/add")
	public String addBoardPost(Board board, BoardPost boardPost, MultipartFile[] uploadFiles) {
		
		//파라미터 확인 디버깅
		System.out.println("[boardCtrl] boardPost : " + boardPost);	
		System.out.println("[boardCtrl] uploadFiles : " + uploadFiles);	
		System.out.println("[boardCtrl] board : " + board);
		
		//게시글 추가하기
		int row = boardService.addBoardPost(boardPost);
		
		//디버깅
		System.out.println("[boardCtrl] boardPost : " + boardPost);	
		
		
		//////파일 넣는 추가
		// 변수 확인
		String path = "C:\\Users\\82102\\spring-workspace\\test\\src\\main\\webapp\\WEB-INF\\file2";
		String fileName = "";
		String originFileName = "";
		String contentType = "";

		//리스트 생성
		List<BoardFile> list = new ArrayList<>();
		

		for(MultipartFile file : uploadFiles) {
			if(!file.isEmpty()) {
				//변수 세팅
				fileName = file.getName();
				originFileName = file.getOriginalFilename();
				contentType = file.getContentType();	
				
				//객체 생성
				BoardFile tempFile = new BoardFile();
				
				//디버깅
				log.debug(TeamColor.KHJ + "값 확인 / add boardPost tempFile : " + tempFile);
				
				//값 세팅하기
				tempFile.setUuid(UUID.randomUUID().toString());
				tempFile.setFileOriginname(originFileName);
				tempFile.setFileName(fileName);
				tempFile.setFileType(contentType);
				tempFile.setBoardPostNo(boardPost.getBoardPostNo());
				
				//디버깅
				log.debug(TeamColor.KHJ + "값 확인 / add boardPost tempFile : " + tempFile);
			

				//리스트에 추가하기
				list.add(tempFile);
		
				//파일 객체 생성
				File newFileName = new File(path + File.separator + tempFile.getUuid()+"_"+tempFile.getFileName());

				//저장 파일 이름 생성(연구 중)
				String saveFileName = path + File.separator + tempFile.getUuid()+"_"+tempFile.getFileName();
				
				//저장 파일 경로 생성 (확인 중)
				Path savePath = Paths.get(saveFileName);
				

				try {
					file.transferTo(savePath);
				} catch (Exception e) {
					System.out.println("실패");
					e.printStackTrace();
				}
			
			}
			
			
		}
		
		
		
		//리다이렉션
		//return "redirect:/board/post";
		return "board/addBoardPost";
		
	}

}
