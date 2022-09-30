<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h3>강의 수정</h3>
	</div>
	<div>
		<form action="${pageContext.request.contextPath}/lmsLecture/updateLecture" method="post">
			<table border="1" bordercolor="green">
				<tbody>
					<tr>
						<input type="hidden" name="lectureNo" value="${lectureOne.lectureNo}">
					</tr>
					<tr>
						<th>강의번호</th>
						<td>${lectureOne.lectureNo}</td>
					</tr>
					<tr>
						<th>강의시간</th>
						<td>
							<select name="lectureTime" onchange="lectureTime(this)">
								<option value="${lectureOne.lectureTime}">${lectureOne.lectureTime}시간</option>
								<option value="1">1시간</option>
								<option value="2">2시간</option>
								<option value="3">3시간</option>
							</select>
						</td>
					</tr>
					<tr>
						<th>시작시간</th>
						<td>
							<input type="time" name="lectureStarttime">
						</td>
					</tr>
					<tr>
						<th>종료시간</th>
						<td>
							<input type="time" name="lectureEndtime">
						</td>
					</tr>
					<tr>
						<th>요일</th>
						<td>
							<select name="lectureDay" onchange="lectureDay(this.value)">
								<option value="${lectureOne.lectureDay}">${lectureOne.lectureDay}</option>
								<option value="1">월</option>
								<option value="2">화</option>
								<option value="3">수</option>
								<option value="4">목</option>
								<option value="5">금</option>
							</select>
						</td>
					</tr>
					<tr>
						<th>강좌번호</th>
						<td>
							<select name="subjectNo" id="subjectNo" onchange="subjectNo(this.value)">
								<c:forEach var="s" items="${getSubjectList}">
									<option value="${s.subjectNo}">${s.subjectNo}. ${s.subjectName}</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<th>강의실</th>
						<td>
							<input type="text" name="classroomNo" id="classroomNo" value="${lectureOne.classroomNo}">
						</td>
					</tr>
					<tr>
						<th>담당교수</th>
						<td>
							<select name="userId" id="userId" onchange="userId(this)">
								<c:forEach var="p" items="${getProList}">
									<option value="${p.userId}">${p.userId}(${p.proName})</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<th>학기</th>
						<td>
							<select name="semesterNo" id="semesterNo" onchange="semesterNo(this)">
								<c:forEach var="se" items="${getSemesterList}">
									<option value="${se.semesterNo}">${se.semesterYear}년도${se.semesterSession}학기</option>
								
								</c:forEach>
									
							</select>
						</td>
					</tr>
					
				</tbody>
			</table>
			<button type="button" onclick="history.back()">수정쉬초</button>
			<button type="submit">수정</button>
		</form>
	</div>

</body>
</html>