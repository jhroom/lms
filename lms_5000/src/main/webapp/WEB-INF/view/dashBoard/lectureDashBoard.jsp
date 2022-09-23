<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active">STUDENT LMS PAGE</li>
            </ol>
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content-header -->

    <!-- Main content -->
    <!-- 메인 콘텐츠 -->
    <div class="col-sm-03"></div>
  	<div>
		<c:choose>
			<c:when test="${loginUser != null}">
				<h3>${loginUser.userName}님 환영합니다.</h3>
			</c:when>
			<c:otherwise>
				   <a href="${pageContext.request.contextPath}/index/login"></a>
			</c:otherwise>
		</c:choose>
	</div>
    <div class="content">
	    <div class="container-fluid">
		    <div class="col-sm-6">
				<div class="card card-primary card-outline">
			         <div class="card-body">
			           <h1 class="card-title"><Strong>게시판</Strong></h1><br>
			           <table border="1">
			           	 <thead>
				         	 <tr>
				         	 	<td></td>
				         	 	<td></td>
				         	 	<td></td>
				          	</tr>
			           	 </thead>
			           	 <tbody>
			           	 </tbody>
					   </table>
			          <a href="${pageContext.request.contextPath}/dashBoard/lectureDashBoard" >게시판 생성</a>
			           <a href="#" class="card-link">Another link</a>
			        </div>
			    </div><!-- /.card -->
			</div>
			
			
			<div class="col-sm-6">
				<div class="card card-primary card-outline">
			         <div class="card-body">
			           <h1 class="card-title"><Strong>과제 제출 게시판</Strong></h1><br>
			           <table border="1">
			           	 <thead>
				         
					   </table>
<%-- 					   <c:choose> --%>
<%-- 					   		<c:when test="${loginUser.userLevel eq 2 }"> --%>
					           	 <a href="${pageContext.request.contextPath}/dashBoard/addform" >과제 제출 게시판 생성</a>
<%-- 					   		</c:when> --%>
<%-- 			           </c:choose> --%>
			           <a href="#" class="card-link">Another link</a>
			        </div>
			    </div><!-- /.card -->
			</div>
			<br><br>
			
			<div class="container-fluid">
		    <div class="col-sm-5">
			<div class="card card-primary card-outline">
		         <div class="card-body">
		           <h1 class="card-title"><Strong>시험</Strong></h1><br>
		           <table border="1">
		           	 <thead>
			          
		           	 </thead>
		           	 <tbody>
		           	 	 
		           	 </tbody>
				   </table>
		           <a href="#" class="card-link">Card link</a>
		           <a href="#" class="card-link">Another link</a>
		        </div>
		    </div><!-- /.card -->
			</div>
			
			<div class="col-sm-2"></div>
			
			<div class="col-sm-5">
			<div class="card card-primary card-outline">
		         <div class="card-body">
		           <h1 class="card-title"><Strong>성적확인</Strong></h1><br>
		           <table border="1">
		           	 <thead>
			          
		           	 </thead>
		           	 <tbody>
		           	 </tbody>
				   </table>
		           <a href="#" class="card-link">Card link</a>
		           <a href="#" class="card-link">Another link</a>
		        </div>
		    </div><!-- /.card -->
			</div>
			
			<br><br>
			
			<div class="card card-primary card-outline">
		         <div class="card-body">
		           <h1 class="card-title"><Strong>출결현황</Strong></h1><br>
		           <table border="1">
		           	 <thead>
			          
		           	 </thead>
		           	 <tbody>
			           	 	
		           	 	
		           	 </tbody>
				   </table>
		           <a href="#" class="card-link">Card link</a>
		           <a href="#" class="card-link">Another link</a>
		        </div>
		    </div><!-- /.card -->
			</div>
		        <!-- /.row -->
	    </div><!-- /.container-fluid -->
    </div>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
  </div>
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
<!-- ./wrapper -->

<!-- 페이지 삽입 - 필수적인 script -->
<%@include file="../import/script.jsp" %>

</body>
</html>