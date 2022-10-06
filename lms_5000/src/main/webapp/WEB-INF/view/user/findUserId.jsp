<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="x-ua-compatible" content="ie=edge">

<title>AdminLTE 3 | Starter</title>

<!-- 페이지 삽입 - 필수적인 레퍼런스(css, font) -->
<%@include file="../import/reference.jsp" %>

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
            <h1 class="m-0 text-dark">아이디 찾기</h1>
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active">아이디 찾기</li>
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
	<div>
	<form action="${pageContext.request.contextPath}/user/findUserId" method="post">
		<table border="1">
			<tr>
				<td>이름</td>
				<td><input type="text" name="userName"></td>
			</tr>
			
			<tr>
				<td>전화번호</td>
				<td><input type="text" name="userTel" placeholder="ex ) 010-0000-0000"></td>
			</tr>
			
		</table>
		<button type="submit" class="btn btn-sm btn-primary">입력</button>
	</form>
	
	<div>
	<!-- 메시지를 받아와서 출력해주는곳 
		정보가 틀릴경우 입력 정보를 확인 / 정보가 맞을경우 찾는 ID를 출력
	-->
		<c:if test="${IdMsg != null }">
			<p>${IdMsg }</p>
		</c:if>
	</div>
	</div>
	<br>
	<a href="${pageContext.request.contextPath}/index/login">
	<button type="button" class="btn btn-sm btn-outline-primary btn-sm">로그인 하기</button>
	</a>
	<a href="${pageContext.request.contextPath}/user/findUserPw">
	<button type="button" class="btn btn-sm btn-outline-primary btn-sm">비밀번호 찾기</button>
	</a>
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