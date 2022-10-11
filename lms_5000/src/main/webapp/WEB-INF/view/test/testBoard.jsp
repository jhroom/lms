<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="x-ua-compatible" content="ie=edge">

<title>LMS 5000</title>

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
            <h1 class="m-0 text-dark">${lectureName}시험 리스트 페이지</h1>
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item active">시험 목록</li>                  
              <li class="breadcrumb-item active"><a href="${pageContext.request.contextPath}/dashBoard/lectureDashBoard?lectureNo=${lectureNo}">${lectureName}</a></li>
              <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/index">메인페이지</a></li>
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
		<div>
		
		<c:if test="${loginUser.userLevel eq 2 }">
			<a href="${pageContext.request.contextPath}/test/addTest?lectureNo=${lectureNo}">시험 만들기</a>
		</c:if>
		<table class="table table-hover text-nowrap">
			<thead>
				<tr>
					<th>시험 번호</th><th>시험 이름</th><th>시험 시작 일자</th><th>시험 마감 일자</th><th>생성일</th><th>수정일</th><th>응시</th><th>점수</th><th>채점</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items="${testList}" var="t">
					<tr>
						<td>${t.testNo}</td><td>${t.testName}<c:if test="${loginUser.userLevel ne 3}"><a href="${pageContext.request.contextPath}/test/modify/form?testNo=${t.testNo}&lectureNo=${lectureNo}">수정</a></c:if></td><td>${t.testStarttime}</td><td>${t.testEndtime}</td><td>${t.testCreatedate}</td><td>${t.testUpdatedate}</td><td><c:if test="${loginUser.userLevel eq 3}"><a href="${pageContext.request.contextPath}/test/enter?testNo=${t.testNo}&lectureNo=${lectureNo}">시험 응시하기</a></c:if></td><td>${t.score}</td><td><c:if test="${loginUser.userLevel ne 3}"><a href="${pageContext.request.contextPath}/test/student?lectureNo=${lectureNo}&testNo=${t.testNo}">채점 링크</a></c:if></td>
					</tr>
				</c:forEach>
			</tbody>
		
		</table>
		
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


