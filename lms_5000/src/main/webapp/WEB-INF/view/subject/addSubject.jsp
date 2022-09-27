<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>강좌 추가</title>
</head>
<body>
	<div>
		<h3>강좌 추가</h3>	
	</div>
	<div>
		<form action="${pageContext.request.contextPath}/lmsSubject/addSubject/add" method="get">
		
		<table border="1" bordercolor="green">
			<tbody>
				<tr>
					<th>학과번호</th>
					<td>
						<select name="majorNo">
							<c:forEach var="m" items="${majorList}">
								<option value="${m.majorNo}">(${m.majorNo})</option>
							
							</c:forEach>
							
						
						
						
						
						
						</select>
					</td>
				</tr>
				<tr>
					<th>강좌이름</th>
					<td><input type="text" name="subjectName" id="subjectName" ></td>
				</tr>
				<tr>
					<th>이수학점</th>
					<td>
						<select name="subjectPoint" id="subjectPoint">
							<option value="default">학점을 선택하세요.</option>
							<option value="1">1학점</option>
							<option value="2">2학점</option>
							<option value="3">3학점</option>
						
						</select>
					</td>
				</tr>
				<tr>
					<th>대상학년</th>
					<td>
						<select name="subjectGrade">
							<option value="default">대상학년을 선택하세요.</option>
							<option value="1">1학년</option>
							<option value="2">2학년</option>
							<option value="3">3학년</option>
							<option value="4">4학년</option>
						</select>
					</td>
				</tr>
			</tbody>
		</table>
		</form>
	</div>

</body>
</html>