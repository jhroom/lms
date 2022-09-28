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
            <h1 class="m-0 text-dark">${lectureInfo.majorName} ${lectureInfo.subjectName} ${week}주차 출석체크</h1>
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
      <!-- 여기를 밀어버리고 컨텐츠로 채우시면 됩니다 -->
      <!-- 카드형태를 옮겨 쓰셔도 무상관 -->
		<div class="row">
			<div class="col-sm-3"></div>
			
			<div class="col-sm-6">
				<div class="row">
					<div class="col-sm-6">학생</div>
					<div class="col-sm-3">출석상태</div>
					<div class="col-sm-3">출석</div>
				</div>
			
			<div class="container-fluid">
				
				<form id="attendForm" action="${pageContext.request.contextPath}/dashBoard/addAttendance" method="post">
					<input type="hidden" value="${week}" name="week">
					<input type="hidden" value="${lectureNo}" name="lectureNo">
					
					<c:forEach var="s" items="${studentList}" varStatus="status">
						<div class="row">
						<div class="col-sm-6">
							<input type="hidden" value="${s.studentId}" name="studentId[${status.index}]">
							<input type="text" value="${s.studentName}">
						</div>
						<div class="col-sm-3">
							<c:choose>
								<c:when test="${s.attendState eq 0}">결석</c:when>
								<c:when test="${s.attendState eq 1}">지각</c:when>
								<c:when test="${s.attendState eq 2}">조퇴</c:when>
								<c:when test="${s.attendState eq 3}">출석</c:when>
							</c:choose>
						</div>
						<div class="col-sm-3">
							<select  name="attendState[${status.index}]">
								<!-- <option value="">-- 선택 --</option> -->
								<option value="0">결석</option>						
								<option value="1">지각</option>
								<option value="2">조퇴</option>
								<option value="3">출석</option>
							</select>
						</div>
						</div>
					</c:forEach>
					
					<button type="submit">제출</button>
				</form>
			</div>
			
			</div>
			
			<div class="col-sm-3"></div>
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

