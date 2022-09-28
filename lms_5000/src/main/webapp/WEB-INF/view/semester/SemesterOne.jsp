<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세보기</title>
</head>
<body>
<div>
	<h3>학기 상세보기</h3>
	<table border="1" bordercolor="green">
		<tbody>
			<tr>
				<th>학기번호</th>
				<td>${semesterOne.semesterNo}번</td>
			</tr>
			<tr>
				<th>년도</th>
				<td>${semesterOne.semesterYear}년</td>
			</tr>
			<tr>
				<th>학기</th>
				<td>${semesterOne.semesterSession}학기</td>
			</tr>
			<tr>
				<th>개강일</th>
				<td>${semesterOne.semesterStartdate}</td>
			</tr>
			<tr>
				<th>종강일</th>
				<td>${semesterOne.semesterEnddate}</td>
			</tr>
		</tbody>
	</table>
	<a href="${pageContext.request.contextPath}/lmsSemester/updateSemester/form?semesterNo=${semesterNo}" class="btn btn-info" role="button">수정</a>
	<a href="${pageContext.request.contextPath}/lmsSemester/deleteSemester?semesterNo=${semesterNo}" class="btn btn-info" role="button">삭제</a>
	
</div>

</body>
</html>