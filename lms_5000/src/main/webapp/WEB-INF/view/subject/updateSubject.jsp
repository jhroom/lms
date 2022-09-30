<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>강좌 수정하기</title>
</head>
<body>
<div>
	<h3>강좌 수정</h3>
	<form action="${pageContext.request.contextPath}/lmsSubject/updateSubject" method="post">
	<table border="1" bordercolor="green">
		<tbody>
			<tr>
				<input type="hidden" name="subjectNo" value="${subjectOne.subjectNo}">
			</tr>
			<tr>
				<th>강좌번호</th>
				<td>${subjectOne.subjectNo}번</td>
			</tr>
			<tr>
				<th>강좌이름</th>
				<td>
					<input type="text" name="subjectName" value="${subjectOne.subjectName}">
				</td>
			</tr>
			<tr>
				<th>이수학점</th>
				<td>
					<select name="subjectPoint" id="subjectPoint" onchange="subjectPoint(this)">
						<option value="${subjectOne.subjectPoint}">${subjectOne.subjectPoint}학점</option>
						<option value="1">1학점</option>
						<option value="2">2학점</option>
						<option value="3">3학점</option>
					</select>
				
				</td>
			</tr>
			<tr>
				<th>대상학년</th>
				<td>
					<select name="subjectGrade" id="subjectGrade" onchange="subjectGrade(this)">
						<option value="${subjectOne.subjectGrade}">${subjectOne.subjectGrade}학년</option>
						<option value="1">1학년</option>
						<option value="2">2학년</option>
						<option value="3">3학년</option>
						<option value="4">4학년</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>학과번호</th>
				<td>
					<select name="majorNo" id="majorNo" onchange="majorNo(this)">
					
					<c:forEach var="m" items="${getMajorList}">
						<option value="${m.majorNo}">${m.majorNo}. ${m.majorName}</option>
					</c:forEach>
					</select>
				
				</td>
			</tr>
			
			
			
		</tbody>
	</table>
	<button type="button" onclick="history.back()">수정취소</button>
	<button type="submit">수정</button>
	</form>
</div>

</body>
</html>