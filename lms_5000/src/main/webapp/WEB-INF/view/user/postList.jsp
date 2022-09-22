<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LMS | 작성리스트</title>
</head>
<body>
	<div>
		<h3>나의 게시글 작성 목록</h3>
		<table>
			<thead>
				<tr>
					<th>학과이름</th>
					<th>과목이름</th>
					<th>게시판</th>
					<th>제목</th>
					<th>조회수</th>
					<th>작성일</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="b" items="${boardList}">
				<tr>
					<td>${b.majorName}</td>
					<td>${b.subjectName}</td>
					<td>${b.boardName}</td>
					<td><a href="${pageContext.request.contextPath}
					/board/post/one?boardPostNo=${b.boardPostNo}&boardNo=${b.boardNo}&boardName=${b.boardName}">
					${b.boardPostName}</a></td>
					<td>${b.count}</td>
					<td>${b.boardPostCreatedate}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<h3>나의 댓글 작성 목록</h3>
		<table>
			<thead>
				<tr>
					<th>학과이름</th>
					<th>과목이름</th>
					<th>게시판</th>
					<th>제목</th>
					<th>댓글내용</th>
					<th>작성일</th>
					<th>수정일</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="b" items="${commentList}">
				<tr>
					<td>${b.majorName}</td>
					<td>${b.subjectName}</td>
					<td>${b.boardName}</td>
					<td>${b.boardPostTitle}</td>
					<td><a href="${pageContext.request.contextPath}
					/board/post/one?boardPostNo=${b.boardPostNo}&boardNo=${b.boardNo}&boardName=${b.boardName}">
					${b.commentContent}</a></td>
					<td>${b.commentCreateDate}</td>
					<td>${b.commentUpdateDate}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>