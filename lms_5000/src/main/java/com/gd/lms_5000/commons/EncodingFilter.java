package com.gd.lms_5000.commons;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

import lombok.extern.slf4j.Slf4j;

@Slf4j // 로깅에 대한 추상 레이어를 제공하는 인터페이스의 모음이다. (로깅 Facade)
@WebFilter("/*") //모든 접근에 인코딩 필터 적용
public class EncodingFilter extends HttpFilter implements Filter{
	//인코딩 필터
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//인코딩
		request.setCharacterEncoding("UTF-8");
	
		//디버깅
		log.debug(TeamColor.debuging + "===EncodingFilter utf-8 인코딩 실행===" + TeamColor.TEXT_RESET);
		
		chain.doFilter(request, response);
	}
}
