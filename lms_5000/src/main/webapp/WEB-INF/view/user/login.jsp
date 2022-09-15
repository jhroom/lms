<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>5000 LMS Login</h3>
	<div>
		<form action="${pageContext.request.contextPath}/user/login" method="post">
			id
				<input type="text" name="userId">
			pw
				<input type="password" name="userPw">
				<button type="submit">로그인</button>
		</form>
	</div>
	
</body>
</html>