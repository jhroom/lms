package com.gd.lms.commons;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PageUtil {
	

	public Map<String, Object> pageVariable(int currentPage, int lastcontents){
		
		//페이징 메서드
		/*
		 * 페이지네이션을 위한 변수를 생성해주는 메서드입니다.
		 * 
		 * 필요한 파라미터 : 
		 * 		- currentPage : 현재 페이지 값
		 * 		- lastcontents : 페이징을 해야하는 요소의 마지막 값(각 테이블마다 쿼리로 구해야합니다.)
		 * 
		 * 생성되는 변수 : 
		 * 		----쿼리(limit)에 사용되는 변수
		 * 		- rowPerPage  : 각 페이지당 할당되는 행수
		 * 		- beginRow : 페이지 할당을 위한 시작 행 번호
		 * 		
		 * 		----페이지(view)에 사용되는 변수
		 * 		- startPage : 페이지의 시작 번호
		 * 		- endPage : 페이지의 끝 번호
		 * 		- realLastPage : 제일 마지막 페이지 번호
		 * 		- pages : 페이지 수의 배열
		 * 		- currentPage : 계산 후 현재 페이지
		 * 
		 */
			
		//리턴값 세팅
		Map<String, Object> map = new HashMap();
		
		//페이징 하고 싶은 수의 변수
		int rowPerPage = 2;
		
		//쿼리로 찐 막 페이지 구하기
		////변수 선언
		int realLastPage = 0;
		
		////마지막 페이지 설정
		if(lastcontents%rowPerPage == 0) {
			realLastPage = lastcontents/rowPerPage;
		} else {
			realLastPage = lastcontents/rowPerPage+1;
		}
			
		if(realLastPage == 0){
			realLastPage = 1;					
		} 
		
		//현제 페이지 설정
		////현 페이지가 0보다 작으면 1로
		if(currentPage <= 0) {
			currentPage = 1;
		}
		
		//현 페이지가 마지막 페이지보다 크면 마지막 페이지로
		if(currentPage >= realLastPage) {
			currentPage = realLastPage; 
		}
		
		
		//쿼리(limit) 시작 수 설정
		int beginRow = currentPage *rowPerPage - rowPerPage;
		
		if(beginRow <0) {
			beginRow = 0;
		}
		
		//페이지 세팅
		////시작 페이지 값 설정
		int startPage = 0;
		
		if(currentPage % 10 == 0) {
			startPage = (currentPage / 10 -1) * 10 +1;
	
		} else {
			startPage = currentPage / 10 * 10 +1;
	
		}
		
		//마지막 페이지 값 설정
		int endPage = startPage+10;
	
		if(endPage > realLastPage) { endPage = realLastPage; }
		
		
		//페이지 배열 크기 설정
		int arrLength = endPage - startPage +1;
		if(arrLength > 10) {
			arrLength = 10;
		}
		
		//넘겨줄 배열값 세팅
		int [] pages = new int[arrLength];
		
		for(int i = 0;i<pages.length;i++) {
			pages[i] = startPage + i;
		}
		
	
		//리턴값 세팅
		map.put("rowPerPage", rowPerPage);		
		map.put("beginRow", beginRow);
		
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("realLastPage", realLastPage);
		map.put("pages", pages);		
		map.put("currentPage", currentPage);
		

		
		
		//디버깅
		System.out.println("페이지네이션 변수 / lastcontents : "+lastcontents);
		System.out.println("페이지네이션 변수 / rowPerPage : "+rowPerPage);
		System.out.println("페이지네이션 변수 / beginRow : "+beginRow);
		
		System.out.println("페이지네이션 변수 / startPage : "+startPage);
		System.out.println("페이지네이션 변수 / endPage : "+endPage);
		System.out.println("페이지네이션 변수 / realLastPage : "+realLastPage);
		System.out.println("페이지네이션 변수 / pages : "+Arrays.toString(pages));
		System.out.println("페이지네이션 변수 / currentPage : "+currentPage);
		
	
		//리턴
		return map;
	}

}
