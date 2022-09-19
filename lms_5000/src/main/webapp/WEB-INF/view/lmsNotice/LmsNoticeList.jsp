<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LMS 공지사항입니다.</title>
</head>
<body>
<div>
	<h3>LMS 공지사항</h3>
</div>
	<div>
		<a href="${pageContext.request.contextPath}/lmsNotice/LmsNoticeAddBoard">글 작성</a>
	</div>
	<div>
	
	<table border="" bordercolor="green">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>내용</th>
			<th>작성일</th>
			
		</tr>
		<c:forEach var="a" items="${lmsNoticeList}">
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