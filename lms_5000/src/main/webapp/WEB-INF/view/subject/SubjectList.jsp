<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체 강좌 리스트</title>
</head>
<body>
	<h3>
		전체 강좌 리스트
	</h3>
	<div>
		<a href="${pageContext.request.contextPath}/">추가하기(ㄱㄷ)</a>
	</div>
	<table border="1" bordercolor="green">
		<tr>
			<th>강좌번호</th>
			<th>강좌이름</th>
			<th>이수학점</th>
			<th>대상학년</th>
			<th>학과번호</th>
		</tr>
		<c:forEach var="s" items="${SubjectList}">
			<tr>
				<td>${s.subjectNo}</td>
				<td>
					<a href="${pageContext.request.contextPath}/lmsSubject/subjectOne?subjectNo=${s.subjectNo}">${s.subjectName}</a>
				</td>				
				<td>${s.subjectPoint}</td>
				<td>${s.subjectGrade}</td>
				<td>${s.majorNo}</td>
			</tr>
		
		
		</c:forEach>
	</table>

</body>
</html>