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
	<form action="${pageContext.request.contextPath}/lmsMajor/MajorList/add" method="post">
	<input type="hidden" name="majorNo" id="majorNo" value="${majorNo}">
	<table border="1" bordercolor="green">
		<tbody>
			<tr>
				<th>학과이름</th>
				<td><input type="text" name="majorName" id="majorName" value="학과 이름"></td>
			</tr>
		</tbody>
		</table>
		<button type="button">추가하기</button>
	</form>

</body>
</html>