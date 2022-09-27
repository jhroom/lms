<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>강좌 상세보기</title>
</head>
<body>
<div>
	<h3>강좌 상세보기</h3>
	<table border="1" bordercolor="green">
		<tbody>
			<tr>
				<th>강좌번호</th>
				<td>${subjectOne.subjectNo}번</td>
			</tr>
			<tr>
				<th>강좌이름</th>
				<td>${subjectOne.subjectName}</td>
			</tr>
			<tr>
				<th>이수학점</th>
				<td>${subjectOne.subjectPoint}학점</td>
			</tr>
			<tr>
				<th>대상학년</th>
				<td>${subjectOne.subjectGrade}학년</td>
			</tr>
			<tr>
				<th>학과번호</th>
				
				<td>
				
				${subjectOne.majorNo}${subjectOne.majorName}
				
				</td>
			</tr>
		</tbody>
	</table>
	
	<a href="${pageContext.request.contextPath}/lmsSubject/updateSubject/form?subjectNo=${subjectNo}" class="btn btn-info" role="button">수정</a>
	<a href="${pageContext.request.contextPath}/lmsSubject/deleteSubject?subjectNo=${subjectNo}" class="btn btn-info" role="button">삭제</a>
	 
</div>

</body>
</html>