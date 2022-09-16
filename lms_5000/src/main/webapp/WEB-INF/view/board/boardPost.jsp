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
	<h3>${boardName} 게시판</h3>
	<a href="${pageContext.request.contextPath}/board/post/add/form?boardNo=${boardNo}&boardName=${boardName}">글쓰기(구현중)</a>
		<table border="1">
			<thead>
				<tr>
					<th>게시글 번호</th><th>게시글 제목</th><th>작성자</th><th>조회수</th><th>게시판 이름(디버깅)</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="p" items="${boardPostList}">
					<tr>
						<td>${p.boardPostNo}</td><td><a href="${pageContext.request.contextPath}/board/post/one?boardPostNo=${p.boardPostNo}&boardNo=${boardNo}&boardName=${boardName}">${p.boardPostTitle}</a></td><td>${p.boardPostWriter}</td><td>${p.count}</td><td>${p.boardNo}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
</body>
</html>