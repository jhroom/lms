<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
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
            <h1 class="m-0 text-dark">공지사항</h1>
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/index">Home</a></li>
              <li class="breadcrumb-item active">LmsNotice List</li>
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
      
      
     <div class="row">
     	<div class="col-12">
     	<div class="card">
     		<div class="card-header">
     	<h3 class="card-title">	LMS 공지사항</h3>
     	
     	
		<div class="card-tools">
<!-- 감추거나 지우는 버튼들 -->
        <button type="button" class="btn btn-tool" data-card-widget="collapse" data-toggle="tooltip" title="Collapse"> <i class="fas fa-minus"></i> </button>
        <button type="button" class="btn btn-tool" data-card-widget="remove" data-toggle="tooltip" title="Remove"> <i class="fas fa-times"></i> </button>
  	   </div>
     </div>
<!-- End header -->
	<div class="card-body">		
	<div>
		<c:if test="${loginUser.userLevel eq 4 || loginUser.userLevel eq 1}">
		<a href="${pageContext.request.contextPath}/lmsNotice/LmsNoticeAddBoard" class="btn btn-primary">글 작성</a>
		</c:if>
	</div>
	<div>
	
	<table class="table table-hover text-nowrap" >
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>내용</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
			
		</tr>
		<c:forEach var="a" items="${lmsNoticeList}">
			<tr>
				<td>${a.lmsNoticeNo}</td>
				<td><a href="${pageContext.request.contextPath}/lmsNotice/LmsNoticeOne?lmsNoticeNo=${a.lmsNoticeNo}&lmsNoticeTitle=${a.lmsNoticeTitle}">${a.lmsNoticeTitle}</a></td>
				<td>${a.lmsNoticeContent}</td>
				<td>${a.lmsNoticeName}</td>
				<td>${a.lmsNoticeCreatetime}</td>
				<td>${a.count}</td>
			</tr>
		</c:forEach>
	</table>
	</div>
	</div>
	</div>
	</div>
	
	

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
