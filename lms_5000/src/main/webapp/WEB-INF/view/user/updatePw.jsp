<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="x-ua-compatible" content="ie=edge">

<title>AdminLTE 3 | Starter</title>

<!-- 페이지 삽입 - 필수적인 레퍼런스(css, font) -->
<%@include file="../import/reference.jsp" %>

<script>
		$(document).ready(function(){
			$("#pwUpdate").on("click", function(){
				if($("#userPw").val==""){
					alert("현재 비밀번호를 입력해주세요");
					$("userPw").focus();
					return false
				}
				if($("#userPw1").val==""){
					alert("변경비밀번호을를 입력해주세요");
					$("#userPw1").focus();
					return false
				}
				if($("#userPw2").val==""){
					alert("변경비밀번호를 입력해주세요");
					$("#userPw2").focus();
					return false
				}
				if ($("#userPw1").val() != $("#userPw2").val()) {
					alert("변경비밀번호가 일치하지 않습니다.");
					$("#userPw2").focus();
					 
				
	<!--			$.ajax({
					url : "/member/pwCheck",
					type : "POST",
					dataType : "json",
					data : $("#updatePwForm").serializeArray(),
					success: function(data){
						
						if(data==0){
							alert("패스워드가 틀렸습니다.");
							return;
						}else{
							if(confirm("변경하시겠습니까?")){
								$("#updatePwForm").submit();
							}
							
						}
					}
				})
				
			}); -->
			
				
			
		})
	</script>
</head>
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
            <h1 class="m-0 text-dark">Starter Page</h1>
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active">Starter Page</li>
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
		
		 <form action="${pageContext.request.contextPath}/user/updatePw" method="post" id="updatePwForm" name="updatePwForm">
         <input type="hidden" id="memberId" name="memberId" value="${userInfo.userId}">
    <div class="col-sm-8 col-sm-offset-2">
        <div class="panel panel-default panel-margin-10">
            <div class="panel-body panel-body-content text-center">
                <p class="lead">변경하실 비밀번호를 입력해 주세요.</p>
                <div class="form-group">
                    <input type="password" name="userPw" id="userPw" class="form-control form-control-inline text-center" placeholder="현재 비밀번호" />
                </div>
                <div class="form-group">
                    <input type="password" name="userPw1" class="form-control form-control-inline text-center" placeholder="새 비밀번호" />
                </div>
                <div class="form-group">
                    <input type="password" name="userPw2" class="form-control form-control-inline text-center" placeholder="새 비밀번호 확인" />
                </div>
                <button type="button" id="pwUpdate" name="pwUpdate" class="btn btn-primary">비밀번호 변경</button> <a href="${pageContext.request.contextPath}/index" class="btn btn-default">취소</a>
            </div>
        </div>
    </div>
    </form>
      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content -->
  </div>
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

