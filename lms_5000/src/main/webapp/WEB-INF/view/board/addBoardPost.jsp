<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
<h3>게시글 작성</h3>
	<form action="${pageContext.request.contextPath}/board/post/add" method="post" enctype="multipart/form-data">
		<input type="hidden" name="boardNo" id="boardNo" value="${boardNo}">
		<table border="1">
			<thead>
				<tr>
					<th>구분</th><th>내용</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th>게시판</th>
					<td><input type="text" name="boardName" id="boardName" value="${boardName}" readonly></td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input type="text" name="boardPostName" id="boardPostName"></td>
				</tr>
				
				<tr>
					<th>작성자</th>
					<td><input type="text" name="boardPostWriter" id="boardPostWriter" value="세션 id" readonly></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea name="boardPostContent" id="boardPostContent"></textarea></td>
				</tr>		
				<tr>
					<th>첨부파일</th>
					<td><input type="file" name="boardPostFile" id="boardPostFile"></td>
					<!-- 파일 넘기는법 연구필요 -->
				</tr>		
			</tbody>
		</table>
		<button type="submit">제출하기</button>
	</form>
</div>

</body>
</html>