<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>5000 LMS Login</h3>
	<div>
		<c:if test="${errMsg != null }">
			<p>${errMsg }</p>
		</c:if>
	</div>
	<div>
		<form action="${pageContext.request.contextPath}/user/login" method="post">
			id
				<input type="text" name="userId">
			pw
				<input type="password" name="userPw">
				<button type="submit">로그인</button>
		</form>
	</div>
	
	<div><a href="${pageContext.request.contextPath}/user/addUser">회원가입</a></div>
</body>
</html>