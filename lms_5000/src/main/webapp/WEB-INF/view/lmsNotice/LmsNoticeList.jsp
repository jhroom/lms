<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<a href="${pageContext.request.contextPath}/LmsNoticeAddBoard">글 작성</a>
	</div>
	<div>
	
	<table border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>내용</th>
			<th>작성일</th>
			
		</tr>
		<c:forEach var="a" items="${boardList}">
			<tr>
				<td>${a.lmsNoticeNo}</td>
				<td>${a.lmsNoticeTitle}</td>
				<td>${a.lmsNoticeContent}</td>
				<td>${a.lmsNoticeCreatetime}</td>
			</tr>
		</c:forEach>
	</table>
	</div>
</body>
</html>