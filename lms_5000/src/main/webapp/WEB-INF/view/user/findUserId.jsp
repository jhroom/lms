<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
	<form action="${pageContext.request.contextPath}/user/findUserId" method="post">
		<h3>아이디 찾기</h3>
		<table border="1">
			<tr>
				<td>이름</td>
				<td><input type="text" value="관리자" name="userName"></td>
			</tr>
			
			<tr>
				<td>전화번호</td>
				<td><input type="text" value="010" name="userTel"></td>
			</tr>
			
		</table>
		<button type="submit">입력</button>
	</form>
	
	<div>
	<!-- 메시지를 받아와서 출력해주는곳 
		정보가 틀릴경우 입력 정보를 확인 / 정보가 맞을경우 찾는 ID를 출력
	-->
		<c:if test="${IdMsg != null }">
			<p>${IdMsg }</p>
		</c:if>
	</div>
	</div>
	<a href="${pageContext.request.contextPath}/user/login">로그인 페이지로 돌아가기</a>
	<a href="${pageContext.request.contextPath}/user/findUserPw">비밀번호 찾으러 가기</a>
</body>
</html>