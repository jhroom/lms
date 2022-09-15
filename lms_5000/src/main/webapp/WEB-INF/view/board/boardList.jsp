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
			<h3><a href="${pageContext.request.contextPath}/board/post?boardNo=${noticeNo}">과목 공지사항</a></h3>

		</div>
		
		
		<!-- Qna -->
		<div>
			<h3><a href="${pageContext.request.contextPath}/board/post?boardNo=${qnaNo}">과목 Qna</a></h3>

		</div>
			
	
		<!-- 과목 게시판 -->
		<div>
			<h3>과목 게시판</h3>
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
								<td>${n.boardNo}</td><td><a href="${pageContext.request.contextPath}/board/post?boardNo=${n.boardNo}">${n.boardName}</a></td><td>${n.createDate}</td>
							</tr>
						</c:if>
					</c:forEach>
				</tbody>
			</table>
		</div>
			
	
	</div>

</body>
</html>