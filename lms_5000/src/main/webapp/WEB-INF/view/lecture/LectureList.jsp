<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체 강의 리스트</title>
</head>
<body>
	<h3>전체 강의 리스트</h3>
	<div>
		<a href="${pageContext.request.contextPath}/lmsLecture/addLecture">강의 추가</a>
	</div>
	<table border="1" bordercolor="green">
		<tr>
			<th>번호</th>
			<th>강의시간</th>
			<th>시작시간</th>
			<th>종료시간</th>
			<th>요일</th>
			<th>강좌번호</th>
			<th>강의실</th>
			<th>담당교수</th>
			<th>학기</th>
		</tr>
	<c:forEach var="l" items="${LectureList}">
		<tr>
			<td>${l.lectureNo}번</td>
			<td>${l.lectureTime}</td>
			<td>${l.lectureStarttime}</td>
			<td>${l.lectureEndtime}</td>
			<td>${l.lectureDay}</td>
			<td>${l.subjectNo}</td>
			<td>${l.classroomNo}번</td>
			<td>${l.userId}</td>
			<td>${l.semesterNo}</td>
		</tr>		
	</c:forEach>
	</table>
</body>
</html>