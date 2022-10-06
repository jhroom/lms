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
          <div class="col-sm-8">
            <h3 class="m-0 text-dark">${lectureInfo.majorName} ${lectureInfo.subjectName} ${week}주차 출석체크</h3>
          </div><!-- /.col -->
          <div class="col-sm-4">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}
								/dashBoard/lectureDashBoard?lectureNo=${lectureNo}">Dash Board</a></li>
              <li class="breadcrumb-item active">Attendance Page</li>
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
			
			<div class="col-sm-6 card" style="padding: 3% 5%">
			
			<div class="">
			
				<c:choose>
					<c:when test="${loginUser.userLevel == 1 }">
						<table class="table table-hover text-center">
							<thead>
								<tr>
									<th>학생</th>
									<th>출석상태</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach  var="s" items="${studentList}">
								<tr>
									<td>${s.studentName}</td>
									<td>
										<c:choose>
											<c:when test="${s.attendState eq 0}">결석</c:when>
											<c:when test="${s.attendState eq 1}">지각</c:when>
											<c:when test="${s.attendState eq 2}">조퇴</c:when>
											<c:when test="${s.attendState eq 3}">출석</c:when>
										</c:choose>
									</td>
								</tr>
								</c:forEach>
							</tbody>
						</table>
					</c:when>
					
					<c:when test="${loginUser.userLevel == 2 }">
						<form id="attendForm" action="${pageContext.request.contextPath}/dashBoard/addAttendance" method="post">
							<input type="hidden" value="${week}" name="week">
							<input type="hidden" value="${lectureNo}" name="lectureNo">
							
							<table class="table table-hover text-center">
								<thead>
									<tr>
										<th>학생</th>
										<th>출석상태</th>
										<th>출석</th>
									</tr>
								</thead>
								
								<tbody>
									<c:forEach var="s" items="${studentList}" varStatus="status">
									<tr>
										<td>
											<input type="hidden" value="${s.studentId}" name="studentId[${status.index}]">
											${s.studentName}
										</td>
										<td>
											<c:choose>
												<c:when test="${s.attendState eq 0}">결석</c:when>
												<c:when test="${s.attendState eq 1}">지각</c:when>
												<c:when test="${s.attendState eq 2}">조퇴</c:when>
												<c:when test="${s.attendState eq 3}">출석</c:when>
											</c:choose>
										</td>
										<td>
											<select  name="attendState[${status.index}]" class="custom-select custom-select-sm mb-3">
												<!-- <option value="">-- 선택 --</option> -->
												<option value="0">결석</option>						
												<option value="1">지각</option>
												<option value="2">조퇴</option>
												<option value="3">출석</option>
											</select>
										</td>
									</tr>
									</c:forEach>
								</tbody>
							</table>
							<button type="submit" class="btn btn-secondary float-right" >제출</button>
						</form>
					</c:when>
					
				</c:choose>
			</div><!-- end container  -->
			
			</div><!-- end col-sm-6 -->
			
			<div class="col-sm-3"></div>
		</div>

      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
  
<!-- 페이지 삽입 - footer -->
<%@include file="../import/footer.jsp" %>

</div>
<!-- ./wrapper -->

<!-- 페이지 삽입 - 필수적인 script -->
<%@include file="../import/script.jsp" %>

</body>
</html>

