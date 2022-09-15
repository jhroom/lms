<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h3>메인페이지</h3>
		${user}님 환영합니다.
		<a href="${pageContext.request.contextPath}/user/logout">로그아웃</a>
	</div>
</body>
</html>