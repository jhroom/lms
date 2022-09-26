<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학과 상세보기</title>
</head>
<body>
<div>
	<h3>학과 상세보기</h3>
	<table border="1" bordercolor="green">
		<tbody>
			<tr>
				<th>학과 번호</th>
				<td>${majorOne.majorNo}번</td>	
			</tr>
			<tr>
				<th>학과 이름</th>
				<td>${majorOne.majorName}</td>	
			</tr>
			<tr>
				<th>생성일</th>
				<td>${majorOne.majorCreatedate}</td>	
			</tr>
			<tr>
				<th>생성자</th>
				<td>${majorOne.userId}</td>	
			</tr>
		</tbody>
	</table>

	<a href="${pageContext.request.contextPath}/lmsMajor/updateMajor/form?majorNo=${majorNo}" class="btn btn-info" role="button">수정</a>
	<a href="${pageContext.request.contextPath}/lmsMajor/deleteMajor?majorNo=${majorNo}" class="btn btn-info" role="button">삭제</a>
	
</div>
</body>
</html>