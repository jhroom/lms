<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
</head>
<script>
	$(document).ready(function(){
		
		// 이메일 검증 스크립트 작성
		verifyEmail = function() {
		  
		  var emailVal = $("#email").val();
		  // 검증에 사용할 정규식 변수 regExp에 저장
		  var regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	
		  if (emailVal.match(regExp) != null) {
			  if (!confirm("사용 가능합니다\r\n변경(확인) 취소(아니오)를 눌러주세요.")) {
		           alert("취소 하셨습니다..");
		       } else {
		           $('#emailForm').submit();
		       }
		  }
		  else {
		    alert('형식에 맞지 않습니다');
		  }
		};
		
		// 핸드폰번호 검증 스크립트 작성
		verifyTel = function() {
		  
		  var telVal = $("#tel").val();
		  // 검증에 사용할 정규식 변수 regExp에 저장
		  var regExp = /^\d{3}-\d{3,4}-\d{4}$/;
	
		  if (telVal.match(regExp) != null) {
		    alert('사용가능합니다!');
		  }
		  if (telVal.match(regExp) != null) {
			  if (!confirm("사용 가능합니다\r\n변경(확인) 취소(아니오)를 눌러주세요.")) {
		           alert("취소 하셨습니다..");
		       } else {
		           $('#telForm').submit();
		       }
		  }
		  else {
		    alert('000-0000-0000 형식으로 입력해주세요');
		  }
		};
		
		$('#emailBtn').click(function(){
			if( $('#email').val() == ""){
				alert('확인 버튼 후 변경하세요')
			}
		});
		
	});
</script>
<body>
	<div>
		<h3>내 계정</h3>
		
		<div>아이디</div>
		<div>${userInfo.userId }</div>
		<hr>
		
		<div>계정 유형</div>
		<div>
			<c:choose>
				<c:when test="${userInfo.userLevel == 1}">운영자</c:when>
				<c:when test="${userInfo.userLevel == 2}">교수</c:when>
				<c:when test="${userInfo.userLevel == 3}">학생</c:when>
				<c:when test="${userInfo.userLevel == 4}">시스템관리자</c:when>
			</c:choose>
		</div>
		<hr>
		
		<div>이름</div>
		<div>${userInfo.userName}</div>
		<hr>
		
		<div>메일</div>
		<div>
			${userInfo.userEmail}
			<form action="${pageContext.request.contextPath}/index/mypage/changeUserInfo" id="emailForm" method="post">
				<input type="text" id="email" name="userInfo">
				<button type="button" onclick="verifyEmail()">확인</button>
			</form>
		</div>
		<hr>
		
		<div>휴대폰 번호</div>
		<div>
			${userInfo.userTel}
			<form action="${pageContext.request.contextPath}/index/mypage/changeUserInfo" id="telForm" method="post">
				<input type="text" id="tel" name="userInfo">
				<button type="button" onclick="verifyTel()">확인</button>
			</form>
		</div>
		<hr>
		
		<div>성별</div>
		<div>${userInfo.userGender}</div>
		<hr>
		
		<div>생성 날짜</div>
		<div>${userInfo.createDate}</div>
		<hr>
	</div>
</body>
</html>