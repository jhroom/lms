<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
	<h3><a href="${pageContext.request.contextPath}/board/post?boardNo=${boardNo}&boardName=${boardName}">${boardName} 게시판</a></h3>
		<table border="1">
			<thead>
				<tr>
					<th>구분</th><th>내용</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th>제목</th>
					<td>${boardOne.boardPostTitle}</td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>${boardOne.boardPostWriter}</td>
				</tr>
				<tr>
					<th>작성일</th>
					<td>${boardOne.boardPostCreatedate}</td>
				</tr>
				<tr>
					<th>수정일</th>
					<td>${boardOne.boardPostUpdatedate}</td>
				</tr>
				<tr>
					<th>조회수</th>
					<td>${boardOne.count}</td>
				</tr>
				<tr>
					<th>내용</th>
					<td>${boardOne.boardPostContent}</td>
				</tr>		
				<tr>
					<th>첨부파일</th>
					<td>
						<a href="${pageContext.request.contextPath}/board/download/file?fileName=${boardOne.fileName}&boardPostNo=${boardOne.boardPostNo}&boardNo=${boardNo}&boardName=${boardName}">
							${boardOne.fileOriginname}
						</a>
					</td>
				</tr>		

			</tbody>
		</table>
		<a href="">수정(미구현)</a>
		<a href="">삭제(미구현)</a>
		
	</div>
	

</body>
</html>