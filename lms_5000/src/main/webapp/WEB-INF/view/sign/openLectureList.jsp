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
	<h3>개설 강좌 목록</h3>
		<table border="1">
			<thead>
				<tr>
					<th>강좌번호(lectureNo)</th>
					<th>과목이름(subjectName)</th>
					<th>과목학점(subjectPoint)</th>
					<th>학기(semester_no)</th>
					<th>신청 가능 학년(subjectGrade)</th>
					<th>신청 가능 학과(majorName)</th>
				</tr> 
			</thead>
			<tbody>
				<c:forEach var="m" items="${lectureList}">
					<tr>
						<td>${m.lecture_no}</td>
						<td>${m.subject_name}</td>
						<td>${m.subject_point}점</td>
						<td>${m.semester_no}학기</td>
						<td>${m.subject_grade}학년</td>
						<td>${m.major_name}</td>
						<td>
						   <a href="${pageContext.request.contextPath}/sign/addSign?lectureNo=${m.lecture_no}&userId=son">수강신청</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<br><br><br>
	<div>
		<h3>수강신청 과목</h3>
		<table border="1">
			<thead>
				<tr>
					<th>강좌번호(lectureNo)</th>
					<th>과목이름(subjectName)</th>
					<th>과목학점(subjectPoint)</th>
					<th>신청 가능 학년(subjectGrade)</th>
					<th>수업진행요일(lectureDay)</th>
					<th>강의실(classNo)</th>
					<th>수강 신청 상태(signState)</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="s" items="${singList}">
					<tr>
						<td>${s.lecture_no}</td>
						<td>${s.subject_name}</td>
						<td>${s.subject_point}점</td>
						<td>${s.subject_grade}학년</td>
						<td>
							<c:choose>
								<c:when test="${s.lecture_day eq 1}">월요일</c:when>
								<c:when test="${s.lecture_day eq 2}">화요일</c:when>
								<c:when test="${s.lecture_day eq 3}">수요일</c:when>
								<c:when test="${s.lecture_day eq 4}">목요일</c:when>
								<c:when test="${s.lecture_day eq 5}">금요일</c:when>
								<c:when test="${s.lecture_day eq 6}">토요일</c:when>
								<c:when test="${s.lecture_day eq 7}">일요일</c:when>
								<c:otherwise>요일을 다시 확인해 주세요</c:otherwise>
							</c:choose>
						</td>
						<td>${s.classroom_no}호 강의실</td>
						<td>
							<!-- session 등으로 수강신청 관련 대기 -->
							<c:choose>
								<c:when test="${s.sign_state eq 0}">신청 대기</c:when>
								<c:when test="${s.sign_state eq 1}">수강 신청 완료</c:when>
							</c:choose>
						</td>
						<td><a href="${pageContext.request.contextPath}/sign/removeSign?signNo=${s.sign_no}">수강취소</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br><br><br>
		<h3>수강 취소 내역</h3>
		<table border="1">
			<thead>
				<tr>
					<th>취소 과목 이름</th>
					<th>취소 과목 주체</th>
					<th>취소 사유</th>
					<th>취소 시간</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</tbody>		
		</table>
	</div>
	<div>
		<%-- footer 위치 --%>
		<%-- <c:import url="/WEB-INF/view/inc/........"></c:import> --%>
	</div>
	
</body>
</html>