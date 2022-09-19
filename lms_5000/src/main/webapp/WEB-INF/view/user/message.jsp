<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<form action="${pageContext.request.contextPath}/user/message" method="post">
			보낸이
			<input type="text" name="sendId"><br>
			받는이
			<input type="text" name="receiveId"><br>
			<!-- 같은 강의 듣는사람 강의 교수 리스트 선택할수 있거나 검색하는방법으로 -->
			 내용 
			<textarea rows="20" cols="20" name="messageContent"></textarea>
		</form>
	</div>
</body>
</html>