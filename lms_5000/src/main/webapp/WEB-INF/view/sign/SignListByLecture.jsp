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


  <c:choose>
			<c:when test="${loginUser != null}">
				<p>${loginUser.userName}님 환영합니다.</p>
				<c:if test="${loginUser.userLevel ne 3}">
					<a href="${pageContext.request.contextPath}/index">권한제한</a>
				</c:if>
			</c:when>
			<c:otherwise>
				<a href="${pageContext.request.contextPath}/index/login">로그인하러가기</a>
			</c:otherwise>
		</c:choose>
  <!-- Content Wrapper. Contains page content -->
  <!-- 메인 컨텐츠 래퍼 -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <!-- 메인페이지 헤더(제목 등) -->
    <div class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1 class="m-0 text-dark">수강신청 인원 리스트(운영자용 페이지)</h1>
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/sign/SignListForAdmin">개설 강좌 리스트</a></li>
              <li class="breadcrumb-item active">수강 신청 학생 리스트</li>
            </ol>
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content-header -->

    <!-- Main content -->
    <!-- 메인 콘텐츠 -->
	<div class = "container">
		  <div class="card">
		  	   <div class="card-header">
	                <h1 class="card-title"><Strong> 수강신청 학생 명단</Strong></h1>
              </div>
             <div class="card-body table-responsice p-0">
          		 <table class="table table-hover text-nowrap">
					<thead>
						<tr>
						
							<th>신청 학생 학과</th>
							<th>신청 학생 학년</th>
							<th>학생ID</th>
							<th>학생이름</th>
							<th>상태 변경</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="g" items="${getStudentList}">
							<tr>
								
								<td>${g.major_name}</td>
								<td>${g.st_grade}학년</td>
								<td>${g.user_id}</td>
								<td>${g.st_name}</td>
								<td>
									<form action="${pageContext.request.contextPath}/sign/SignListByLecture?lectureNo=${g.lecture_no}&userId=${g.user_id}" method="post">
									    <input type="hidden" name="lectureNo" id="lectureNo" value="${g.lecture_no}">
						                <input type="hidden" name="signNo" id="signNo" value="${g.sign_no}">
						                <input type="hidden" name="cancelId" id="cancelId" value="${loginUser.userId}">
										<select name="signState" >
											<c:choose>
												<c:when test="${g.sign_state eq '0'}">
													<option value="0" selected>승인 대기</option>
													<option value="1">신청 완료</option>
													<option value="2">수강 불가</option>
												</c:when>
												<c:when test="${g.sign_state eq '1'}">
													<option value="0" disabled>승인 대기</option>
													<option value="1" selected disabled>신청 완료</option>
													<option value="2" disabled>수강 불가</option>
												</c:when>
												<c:when test="${g.sign_state eq '2'}">
													<option value="0" disabled>승인 대기</option>
													<option value="1" disabled>신청</option>
													<option value="2" selected disabled>수강 불가</option>
												</c:when>
											</c:choose>											
										</select>
										<button type="submit">상태 변경</button>
									</form>
								 </td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
              </div>
            </div><!-- /.card -->
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