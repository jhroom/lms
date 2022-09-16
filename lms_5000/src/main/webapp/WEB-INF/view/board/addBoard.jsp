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
<h3>게시글 작성</h3>
	<form action="${pageContext.request.contextPath}/board/add" method="post" enctype="multipart/form-data">
		<input type="hidden" name="lectureNo" id="lectureNo" value="${lectureNo}">
		<table border="1">
			<thead>
				<tr>
					<th>구분</th><th>내용</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th>게시판 이름</th>
					<td><input type="text" name="boardName" id="boardName"></td>
				</tr>
			</tbody>
		</table>
		<button type="submit">제출하기</button>
	</form>
</div>

</body>
</html>