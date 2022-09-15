<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<div>
		<%-- header 위치 --%>
		<%-- <c:import url="/WEB-INF/view/inc/........"></c:import> --%>
	</div>
	<div class="container">
		<table border="1">
			<thead>
				<tr>
					<th>강좌번호(lectureNo)</th>
					<th>과목이름(subjectName)</th>
					<th>과목학점(subjectPoint)</th>
					<th>신청 가능 학년(subjectGrade)</th>
					<th>신청 가능 학과(majorName)</th>
				</tr> 
			</thead>
			<tbody>
				<c:forEach var="m" items="${lectureList}">
					<tr>
						<td>${m.lecture_no}</td>
						<td>${m.subject_name}</td>
						<td>${m.subject_point}</td>
						<td>${m.subject_grade}</td>
						<td>${m.major_name}</td>
						<td>
						   <a href="${pageContext.request.contextPath}/sign?lecuureNo=${m.lecture_no}">수강신청</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div>
		<%-- footer 위치 --%>
		<%-- <c:import url="/WEB-INF/view/inc/........"></c:import> --%>
	</div>
	
</body>
</html>