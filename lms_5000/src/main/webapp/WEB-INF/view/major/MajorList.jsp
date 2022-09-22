<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>
		전체 학과 리스트
	</h3>
	<div>
	<a href="${pageContext.request.contextPath}/lmsMajor/addMajor">학과 추가</a>
	</div>
	
	<table border="1" bordercolor="green">
		<tr>
			<th>학과번호</th>
			<th>학과이름</th>
			<th>학과생성일</th>
			<th>생성자</th>
		</tr>
		<c:forEach var= "a" items="${MajorList}">
			<tr>
				<td>${a.majorNo}</td>
				<td>${a.majorName}</td>
				<td>${a.majorCreatedate}</td>
				<td>${a.userId}</td>
			</tr>
	
	
		</c:forEach>
	</table>
	
	
		
</body>
</html>