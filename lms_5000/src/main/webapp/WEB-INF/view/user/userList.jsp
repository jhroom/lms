<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 가입승인 대기페이지 ? level값을 y , n 으로 변경하여 활성화처리 -->
	<!-- 모든 user 정보를 볼 수 있는 페이지. -->
	<h3> 유저리스트 </h3>
	<div>
		<table border="1">
			<thead>
				<tr>
					<th>ID</th>
					<th>사용자유형</th>
					<th>이름</th>
					<th>이메일</th>
					<th>전화번호</th>
					<th>성별</th>
					<th>가입일자</th>
					<th>계정 승인 여부</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="list" items="${list}">
				<tr>
					<td>${list.userId}</td>
					<td>
					<!-- Level값에 따라서 사용자 유형이 나뉘는데 db에는 숫자로 들어가있음.
						때문에 db에들어가있는 level값에 따라서 
						if문을 사용하여 사용자 유형을 출력해주었음.
					 -->
					<c:if test="${list.userLevel eq 1}">
						운영자
					</c:if>
					<c:if test="${list.userLevel eq 2}">
						교수
					</c:if>
					<c:if test="${list.userLevel eq 3}">
						학생
					</c:if>
					<c:if test="${list.userLevel eq 4}">
						관리자
					</c:if>
					</td>
					<td>${list.userName}</td>
					<td>${list.userEmail}</td>
					<td>${list.userTel}</td>
					<td>${list.userGender}</td>
					<td>${list.createDate}</td>
					<td>
					<form action="${pageContext.request.contextPath}/user/userList" method="post">
					<!-- Active값이 Y인것은 "승인완료" 출력
						 Active값이 N인것은 "승인대기" 출력
					 -->
					<input type="hidden" name="userId" value="${list.userId}">
					<select name="userActive">
						<c:if test="${list.userActive eq 'Y'}">
							<option value="Y" selected>승인 완료</option>
							<option value="N">승인 대기</option>
						</c:if>
						<c:if test="${list.userActive eq 'N'}">
							<option value="Y" >승인 완료</option>
							<option value="N" selected>승인 대기</option>
						</c:if>
					</select>
						<button type="submit">승인상태 변경</button>
					</form>
					
					</td>
				</tr>
			</c:forEach>
				</tbody>
			</table>
	</div>

</body>
</html>