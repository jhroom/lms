<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h3>메인페이지</h3>
		<c:choose>
			<c:when test="${user != null}">
				${user}님 환영합니다.
				<br>
				<a href="${pageContext.request.contextPath}/lmsNotice/LmsNoticeList">공지 리스트</a><br>
				<a href="${pageContext.request.contextPath}/sign/openLectureList">강의 리스트</a><br>
				<a href="${pageContext.request.contextPath}/board/list?lectureNo=1">게시판</a><br>
				<a href="${pageContext.request.contextPath}/user/logout">로그아웃</a>
			</c:when>
			<c:otherwise>
			
			
				<a href="${pageContext.request.contextPath}/user/logout">로그인하러가기</a>
			</c:otherwise>
		</c:choose>
		
		
	</div>
</body>
</html>