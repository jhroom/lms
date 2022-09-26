<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
					<td></td>
				</tr>
				<tr>
					<th>강좌이름</th>
					<td><input type="text" name="subjectName" id="subjectName" ></td>
				</tr>
				<tr>
					<th>이수학점</th>
					<td></td>
				</tr>
				<tr>
					<th>대상학년</th>
					<td></td>
				</tr>
			</tbody>
		</table>
		</form>
	</div>

</body>
</html>