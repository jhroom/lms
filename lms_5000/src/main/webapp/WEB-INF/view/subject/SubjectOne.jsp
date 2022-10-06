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
            <h1 class="m-0 text-dark">강좌 상세보기</h1>
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/index">Home</a></li>
              <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/lmsSubject/SubjectList">Subject List</a></li>
              <li class="breadcrumb-item active">Subject One</li>
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
	
	<table class="table table-hover text-nowrap">	
		<tbody>
			<tr>
				<th>강좌번호</th>
				<td>${subjectOne.subjectNo}번</td>
			</tr>
			<tr>
				<th>강좌이름</th>
				<td>${subjectOne.subjectName}</td>
			</tr>
			<tr>
				<th>이수학점</th>
				<td>${subjectOne.subjectPoint}학점</td>
			</tr>
			<tr>
				<th>대상학년</th>
				<td>${subjectOne.subjectGrade}학년</td>
			</tr>
			<tr>
				<th>학과번호</th>
				
				<td>
				
				${subjectOne.majorNo}${subjectOne.majorName}
				
				</td>
			</tr>
		</tbody>
	</table>
	
	<a href="${pageContext.request.contextPath}/lmsSubject/updateSubject/form?subjectNo=${subjectNo}" class="btn btn-success" role="button">수정</a>
	<a href="${pageContext.request.contextPath}/lmsSubject/deleteSubject?subjectNo=${subjectNo}" class="btn btn-success" role="button">삭제</a>
	 
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

