<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학기 리스트</title>
</head>
<body>
	<div>
		<h3>전체 학기 리스트</h3>
	</div>
		<a href="${pageContext.request.contextPath}/lmsSemester/addSemester">학기 추가</a>
	<div>
		<table border="1" bordercolor="green">
			<tr>
				<th>학기번호</th>
				<th>해당년도</th>
				<th>학기</th>
				<th>개강일</th>
				<th>종강일</th>
			</tr>
			<c:forEach var="s" items="${SemesterList}">
				<tr>
					<td>${s.semesterNo}번</td>
					<td>${s.semesterYear}년</td>
					<td>
						<a href="${pageContext.request.contextPath}/lmsSemester/semesterOne?semesterNo=${s.semesterNo}">${s.semesterSession}학기</a>
					</td>
					<td>${s.semesterStartdate}</td>
					<td>${s.semesterEnddate}</td>			
					
			</c:forEach>
		
		</table>
	
	</div>
	

</body>
</html>