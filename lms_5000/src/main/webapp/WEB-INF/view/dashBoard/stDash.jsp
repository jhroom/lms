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
				<br>
					<button  onclick="window.open('${pageContext.request.contextPath}/sign/openLectureList'
					, '새창', 'width=300px, height=500px' , 'location=no' , 'toolbar=yes'); return false">수강신청
					</button>
				   <a href="${pageContext.request.contextPath}/sign/openLectureList"></a><br>
			</c:when>
		</c:choose>
	</div>
    <div class="content">
    <div class="container-fluid">
    <div class="col-sm-5">
	<div class="card card-primary card-outline">
         <div class="card-body">
           <h1 class="card-title"><Strong>강의정보</Strong></h1><br>
           <table border="1">
           	 <thead>
	           	 <tr>
	           	 	<th>강의명(SubjectName)</th>
	           	 	<th>수업요일(LectureDay)</th>
	           	 	<th>강의실(classroomNo)</th>
	           	 	<th>교수이름(ProfessorName)</th>
	           	 </tr>
           	 </thead>
           	 <tbody>
           	 	 <c:forEach var="a" items="${signList}">
	           	 	 <tr>
						<td>
							<a href="${pageContext.request.contextPath}/dashBoard/lectureDashBoard?userId=${loginUser.userId}&lecture=${a.lecture_no}">${a.subject_name}</a>
						</td>     	 	 
						<td>
							<c:choose>
								<c:when test="${a.lecture_day eq 1}">월요일</c:when>
								<c:when test="${a.lecture_day eq 2}">화요일</c:when>
								<c:when test="${a.lecture_day eq 3}">수요일</c:when>
								<c:when test="${a.lecture_day eq 4}">목요일</c:when>
								<c:when test="${a.lecture_day eq 5}">금요일</c:when>
								<c:when test="${a.lecture_day eq 6}">토요일</c:when>
								<c:when test="${a.lecture_day eq 7}">일요일</c:when>
								<c:otherwise>요일을 다시 확인해 주세요</c:otherwise>
							</c:choose>
						</td> 	 	 
						<td>${a.classroom_no} 강의실</td>           	 	 
						<td>${a.pro_name} 교수</td>           	 	 
	           	 	 </tr>
           	 	 </c:forEach>
           	 </tbody>
		   </table>
           <a href="#" class="card-link">Card link</a>
           <a href="#" class="card-link">Another link</a>
        </div>
    </div><!-- /.card -->
	</div>
	<div class="col-sm-2"></div>
	<div class="col-sm-5">
	</div>
	</div>
        <!-- /.row -->
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
<!-- ./wrapper -->

<!-- 페이지 삽입 - 필수적인 script -->
<%@include file="../import/script.jsp" %>

</body>
</html>