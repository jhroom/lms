<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<!-- 페이지 삽입 - 필수적인 레퍼런스(css, font) -->
<%@include file="../import/reference.jsp" %><title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<style>
	.form-control{
		width: 180px;
		display: inline;
	}
</style>
</head>
<script>
	$(document).ready(function(){
		$('#mailDiv').hide();
		$('#telDiv').hide();
		
		$('#mailBtn').click(function(){
			$('#mailDiv').show();
		});
		$('#telBtn').click(function(){
			$('#telDiv').show();
		});
		
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
<body class="hold-transition sidebar-mini">

<!-- 전체 페이지 래퍼 -->
<div class="wrapper">


<!-- 페이지 삽입 - nav bar -->
<%@include file="../import/nav.jsp" %>

<!-- 페이지 삽입 - side bar -->
<%@include file="../import/sidebar.jsp" %>



  <!-- Content Wrapper. Contains page content -->
  <!-- 메인 컨텐츠 래퍼 -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <!-- 메인페이지 헤더(제목 등) -->
    <div class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1 class="m-0 text-dark">My info</h1>
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/index/mypage">mypage</a></li>
              <li class="breadcrumb-item active">My Info</li>
            </ol>
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content-header -->

    <!-- Main content -->
    <!-- 메인 콘텐츠 -->
    <div class="content">
      <div class="container-fluid">
		<c:choose>
			<c:when test="${msg != null}">
				<div><h5>${msg}</h5></div>
			</c:when>
		</c:choose>
		
		<div><strong>아이디</strong></div>
		<div>${userInfo.userId }</div>
		<hr>
		
		<div><strong>비밀번호</strong></div>
		<div><a href="${pageContext.request.contextPath}/user/updatePw">변경</a></div>
		<hr>
		
		<div><strong>계정 유형</strong></div>
		<div>
			<c:choose>
				<c:when test="${userInfo.userLevel == 1}">운영자</c:when>
				<c:when test="${userInfo.userLevel == 2}">교수</c:when>
				<c:when test="${userInfo.userLevel == 3}">학생</c:when>
				<c:when test="${userInfo.userLevel == 4}">시스템관리자</c:when>
			</c:choose>
		</div>
		<hr>
		
		<c:choose>
				<c:when test="${userInfo.userLevel == 1 }">
					<div>직책</div>
					<div>
					<c:choose>
						<c:when test="${userInfo.extraInfo == 1 }"> <div>사원</div> </c:when>
						<c:when test="${userInfo.extraInfo == 2 }"> <div>대리</div> </c:when>
						<c:when test="${userInfo.extraInfo == 3 }"> <div>과장</div> </c:when>
					</c:choose>
					</div>
					<hr>
				</c:when>
				<c:when test="${userInfo.userLevel == 2 || userInfo.userLevel == 3}">
					<div>학과</div>
					<div>${userInfo.extraInfo}</div>
					<hr>
				</c:when>
		</c:choose>
		
		<div><strong>이름</strong></div>
		<div>${userInfo.userName}</div>
		<hr>
		
		<div><strong>메일</strong></div>
		<div>
			${userInfo.userEmail}
			<button type="button" id="mailBtn" class="btn btn-link">변경하기</button>
		</div>
		<div id="mailDiv">
			<form action="${pageContext.request.contextPath}/index/mypage/changeUserInfo" id="emailForm" method="post">
				<input type="text" id="email" class="form-control" name="userInfo" placeholder="ex)aaa@example.com">
				<button type="button" class="btn btn-link" onclick="verifyEmail()">확인</button>
			</form>
		</div>
		<hr>
		
		<div><strong>휴대폰 번호</strong></div>
		<div>
			${userInfo.userTel}
			<button type="button" id="telBtn" class="btn btn-link">변경하기</button>
		</div>
		<div id="telDiv">
			<form action="${pageContext.request.contextPath}/index/mypage/changeUserInfo" id="telForm" method="post">
				<input type="text" id="tel" class="form-control" name="userInfo" placeholder="ex)000-0000-0000">
				<span><button type="button" class="btn btn-link" onclick="verifyTel()">확인</button></span>
			</form>
		</div>
		<hr>
		
		<div><strong>성별</strong></div>
		<div>${userInfo.userGender}</div>
		<hr>
		
		<div><strong>생성 날짜</strong></div>
		<div>${userInfo.createDate}</div>
		<hr>
		
		<div><strong>정보 수정 날짜</strong></div>
		<div>${userInfo.updateDate}</div>
		<hr>
		
		<div><strong>마지막 로그인 날짜</strong></div>
		<div>${userInfo.lastloginDate}</div>
		<hr>
	</div>
    </div><!-- /.container-fluid -->
    </div>
    <!-- /.content -->
  <!-- /.content-wrapper -->

  <!-- Control Sidebar -->
  <!-- 좌측 사이드 바 -->
  <aside class="control-sidebar control-sidebar-dark">
    <!-- Control sidebar content goes here -->
    <div class="p-3">
      <h5>Title</h5>
      <p>Sidebar content</p>
    </div>
  </aside>
  <!-- /.control-sidebar -->
  
  
<!-- 페이지 삽입 - footer -->
<%@include file="../import/footer.jsp" %>
</div>
<!-- ./wrapper -->

<!-- 페이지 삽입 - 필수적인 script -->
<%@include file="../import/script.jsp" %>
</body>
</html>