<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>학과 추가</h3>
	<form action="${pageContext.request.contextPath}/lmsMajor/MajorList/add" method="get">
	
	<table border="1" bordercolor="green">
		<tbody>
			<tr>
				<th>학과이름</th>
				<td><input type="text" name="majorName" id="majorName" Placeholder="학과 이름을 적으세요."></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="userId" id="userId" value="${userId}" readonly="readonly"><td>
			</tr>
		</tbody>
		</table>
		<button type="submit">추가하기</button>
		
		
	</form>

</body>
</html>