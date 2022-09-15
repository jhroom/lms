<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<form action="${pageContext.request.contextPath}/user/addUser" method="post">
			<table border="1">
				<tr>
					<td>id</td>
					<td><input type="text" name="userId"></td>
				</tr>
				<tr>
					<td>pw</td>
					<td><input type="password" name="userPw"></td>
				</tr>
				<tr>
					<td>사용자유형</td>
					<td>
						<select name="userLevel">
						<option value="1">운영자</option>
						<option value="2">교수</option>
						<option value="3">학생</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="userName"></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="text" name="userEmail"></td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td><input type="text" name="userTel"></td>
				</tr>
				<tr>
					<td>성별</td>
					<td>
						남<input type="radio" name="userGender" value="M">
						여<input type="radio" name="userGender" value="F">
					</td>
				</tr>
			</table>
			
			<button type="submit">회원가입</button>
		</form>
	</div>
</body>
</html>