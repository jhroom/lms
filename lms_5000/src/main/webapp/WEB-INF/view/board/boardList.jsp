<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 게시판 구역 -->
	<div>
		<!-- 공지사항 -->
		<div>
			<h3><a href="${pageContext.request.contextPath}/board/post?boardNo=${noticeNo}&boardName=공지사항">과목 공지사항</a></h3>

		</div>
		
		
		<!-- Qna -->
		<div>
			<h3><a href="${pageContext.request.contextPath}/board/post?boardNo=${qnaNo}&boardName=QNA">과목 Qna</a></h3>

		</div>
			
	
		<!-- 과목 게시판 -->
		<div>
			<h3>과목 게시판</h3>
			<a href="${pageContext.request.contextPath}/board/add/form?lectureNo=${lectureNo}">게시판 만들기(미구현)</a>
			<table border="1">
				<thead>
					<tr>
						<th>게시판 번호</th><th>게시판 이름</th><th>게시판 생성일</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="n" items="${boardList}">
						<c:if test="${n.boardType eq 3}">
							<tr>
								<td>${n.boardNo}</td><td><a href="${pageContext.request.contextPath}/board/post?boardNo=${n.boardNo}&boardName=${n.boardName}">${n.boardName}</a></td><td>${n.createDate}</td>
							</tr>
						</c:if>
					</c:forEach>
				</tbody>
			</table>
		</div>
			
	
	</div>

</body>
</html>