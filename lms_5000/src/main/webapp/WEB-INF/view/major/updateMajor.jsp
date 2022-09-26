<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
	<h3>학과 수정</h3>
	<form action="${pageContext.request.contextPath}/lmsMajor/updateMajor" method="post">
	<table border="1" bordercolor="green">
		<tbody>
			<tr>
				<input type="hidden" name="majorNo" value="${majorOne.majorNo}">
			</tr>
			<tr>
				<th>학과 번호</th>
				<td>
					${majorOne.majorNo}
				</td>
			</tr>
			<tr>
				<th>학과 이름</th>
				<td>
					<input type="text" name="majorName" value="${majorOne.majorName}" >
				</td>
			</tr>
			<tr>
				<th>학과 생성일</th>
				<td>
					${majorOne.majorCreatedate}
				</td>
			</tr>
			<tr>	
				<th>생성자</th>
				<td>
					${majorOne.userId}
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