package com.gd.lms.commons;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Configuration;

import com.gd.lms.vo.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebFilter("/*") //모든 접근에 인코딩 필터 적용
public class LoginFilter extends HttpFilter implements Filter{
	
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//인코딩
		request.setCharacterEncoding("UTF-8");
		
		//request 형변환
		HttpServletRequest req = (HttpServletRequest) request;
		
		//세션 값 가져오기
		HttpSession session = req.getSession();
		
		//로그인 정보 확인
		User u = (User)session.getAttribute("loginUser");
		
		//디버깅
		//log.debug(TeamColor.debuging + "로그인 정보 확인 : " + u + TeamColor.TEXT_RESET);
		

		//요청 uri 확인
		String uri = req.getRequestURI();
		
		//디버깅
		log.debug(TeamColor.debuging + "uri 확인 : " + uri + TeamColor.TEXT_RESET);
		
		
		//로그인, 로그아웃 관련 다이렉션 제외
		if(uri.equals("/lms/index/login")
				||uri.equals("/lms/plugins/fontawesome-free/css/all.min.css")
				||uri.equals("/lms/plugins/icheck-bootstrap/icheck-bootstrap.min.css")
				||uri.equals("/lms/dist/css/adminlte.min.css")
				||uri.equals("/lms/dist/css/adminlte.min.css")
				||uri.equals("/lms/plugins/jquery/jquery.min.js")
				||uri.equals("/lms/plugins/bootstrap/js/bootstrap.bundle.min.js")
				||uri.equals("/lms/dist/js/adminlte.min.js")
				||uri.equals("/lms/plugins/fontawesome-free/webfonts/fa-solid-900.woff2")
				||uri.equals("/lms/plugins/fontawesome-free/webfonts/fa-solid-900.woff")
				||uri.equals("/lms/plugins/fontawesome-free/webfonts/fa-solid-900.ttf")
				||uri.equals("/lms/index/logout")
				||uri.equals("/lms/user/addUser")
				||uri.equals("/lms/user/addAdmin")
				||uri.equals("/lms/user/idCheck")
				||uri.equals("/lms/user/findUserId")
				||uri.equals("/lms/user/findUserPw")
				||uri.equals("/lms/index/restUser")
				||uri.equals("/lms/img/logo_main.png")
				||uri.equals("/lms/img/back_login.jpg")
				||uri.equals("/lms/img/logo_title.ico")
				
				
				
				
				
			) {
			chain.doFilter(request, response);	
			return;
		}
		
		//로그인 정보가 있을때
		 if (u != null) {
			//log.debug(TeamColor.KHJ + "1 : "  + TeamColor.TEXT_RESET);				
			chain.doFilter(request, response);	
		//로그인 정보가 없을떄
		 } else {				
			log.debug(TeamColor.KHJ + "로그인 정보 없음!"  + TeamColor.TEXT_RESET);				
			((HttpServletResponse)response).sendRedirect(((HttpServletRequest)request).getContextPath() + "/index/login");		
		 }
		
	}
	
}
