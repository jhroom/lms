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
            <h1 class="m-0 text-dark">수강신청 페이지</h1>
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
	<div>
		<%-- header 위치 --%>
		<%-- <c:import url="/WEB-INF/view/inc/........"></c:import> --%>
	</div>
	<div class="container">
	<div class="card card-primary card-outline">
         <div class="card-body">
           <h1 class="card-title"><Strong>개설 강좌 목록</Strong></h1><br>
           <table border="1">
			<thead>
				<tr>
					<th>강좌번호(lectureNo)</th>
					<th>과목이름(subjectName)</th>
					<th>과목학점(subjectPoint)</th>
					<th>학기(semester_no)</th>
					<th>신청 가능 학년(subjectGrade)</th>
					<th>신청 가능 학과(majorName)</th>
				</tr> 
			</thead>
			<tbody>
				<c:forEach var="m" items="${lectureList}">
					<tr>
						<td>${m.lecture_no}</td>
						<td>${m.subject_name}</td>
						<td>${m.subject_point}점</td>
						<td>${m.semester_no}학기</td>
						<td>${m.subject_grade}학년</td>
						<td>${m.major_name}</td>
						<td>
						   <a href="${pageContext.request.contextPath}/sign/addSign?lectureNo=${m.lecture_no}&userId=son">수강신청</a>
						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
            <a href="#" class="card-link">Card link</a>
            <a href="#" class="card-link">Another link</a>
          </div>
            </div><!-- /.card -->
	</div>
	<br>
	<div class = "container">
		  <div class="card card-primary card-outline">
              <div class="card-body">
                <h1 class="card-title"><Strong>수강신청 과목</Strong></h1><br>
                <table border="1">
					<thead>
						<tr>
							<th>강좌번호(lectureNo)</th>
							<th>과목이름(subjectName)</th>
							<th>과목학점(subjectPoint)</th>
							<th>신청 가능 학년(subjectGrade)</th>
							<th>수업진행요일(lectureDay)</th>
							<th>강의실(classNo)</th>
							<th>수강 신청 상태(signState)</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="s" items="${singList}">
							<tr>
								<td>${s.lecture_no}</td>
								<td>${s.subject_name}</td>
								<td>${s.subject_point}점</td>
								<td>${s.subject_grade}학년</td>
								<td>
									<c:choose>
										<c:when test="${s.lecture_day eq 1}">월요일</c:when>
										<c:when test="${s.lecture_day eq 2}">화요일</c:when>
										<c:when test="${s.lecture_day eq 3}">수요일</c:when>
										<c:when test="${s.lecture_day eq 4}">목요일</c:when>
										<c:when test="${s.lecture_day eq 5}">금요일</c:when>
										<c:when test="${s.lecture_day eq 6}">토요일</c:when>
										<c:when test="${s.lecture_day eq 7}">일요일</c:when>
										<c:otherwise>요일을 다시 확인해 주세요</c:otherwise>
									</c:choose>
								</td>
								<td>${s.classroom_no}호 강의실</td>
								<td>
									<!-- session 등으로 수강신청 상태 대기 -->
									<c:choose>
										<c:when test="${s.sign_state eq 0}">신청 대기</c:when>
										<c:when test="${s.sign_state eq 1}">수강 신청 완료</c:when>
									</c:choose>
								</td>
								<td><a href="${pageContext.request.contextPath}/sign/cancelSign?lectureNo=${s.lecture_no}&signNo=${s.sign_no}" onclick="clickBtn();" >수강취소</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
                <a href="#" class="card-link">Card link</a>
                <a href="#" class="card-link">Another link</a>
              </div>
            </div><!-- /.card -->
		
	 </div>
	 <br>
	 <div class = "container">
		  <div class="card card-primary card-outline">
              <div class="card-body">
               <h1 class="card-title"><Strong>수강 취소 내역</Strong></h1><br>
               <table border="1">
					<thead>
						<tr>
							<th>강좌번호(lectureNo)</th>
							<th>취소 과목 이름(subjectName)</th>
							<th>취소 과목 주체(userId)</th>
							<th>취소 사유(Content)</th>
							<th>취소 시간(cancelDate)</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="c" items="${cancelSignList}">
							<tr>
								<td>${c.lecture_no}</td>
								<td>${c.subject_name}</td>
								<td>	
									${c.user_id}
									<c:choose >
										<c:when test="${loginUser.userLevel eq 1 }">(운영자)</c:when>
										<c:when test="${loginUser.userLevel eq 3 }">(학생)</c:when>
									</c:choose>
								</td>
								<td>	
									<c:choose >
										<c:when test="${loginUser.userLevel eq 1 }">수강 기준 부합(운영자)</c:when>
										<c:when test="${loginUser.userLevel eq 3 }">학생 개인 사유</c:when>
									</c:choose>
								</td>	
								<td>${c.cancel_date}</td>
							</tr>
						</c:forEach>
					</tbody>		
				</table>
                <a href="#" class="card-link">Card link</a>
                <a href="#" class="card-link">Another link</a>
              </div>
            </div><!-- /.card -->
	</div>
	<div>
		<%-- footer 위치 --%>
		<%-- <c:import url="/WEB-INF/view/inc/........"></c:import> --%>
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