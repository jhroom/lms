<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Insert title here</title>
<!-- 페이지 삽입 - 필수적인 레퍼런스(css, font) -->
<%@include file="../view/import/reference.jsp" %>
</head>
<body class="hold-transition sidebar-mini">

<!-- 전체 페이지 래퍼 -->
<div class="wrapper">


<!-- 페이지 삽입 - nav bar -->
<%@include file="../view/import/nav.jsp" %>

<!-- 페이지 삽입 - side bar -->
<%@include file="../view/import/sidebar.jsp" %>



  <!-- Content Wrapper. Contains page content -->
  <!-- 메인 컨텐츠 래퍼 -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <!-- 메인페이지 헤더(제목 등) -->
    <div class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1 class="m-0 text-dark">메인 페이지</h1>
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
		
	<!--  상단 구역 수강 게시판 섹션 -->
	    <section class="content">
	      <div class="container-fluid">
	        <div class="row">
	          <div class="col-12">
	            <!-- Default box -->
	            <div class="card">
	            
	              <div class="card-header">
	                <h3 class="card-title">수강중인 게시판</h3>
	                
	                <div class="card-tools">
	                	<!-- 감추거나 지우는 버튼들 -->
	                  <button type="button" class="btn btn-tool" data-card-widget="collapse" data-toggle="tooltip" title="Collapse">
	                    <i class="fas fa-minus"></i>
	                   </button>
	                  <button type="button" class="btn btn-tool" data-card-widget="remove" data-toggle="tooltip" title="Remove">
	                    <i class="fas fa-times"></i>
	                    </button>
	                </div>
	              </div><!-- End header -->
	              
	              <div class="card-body">
	                Start creating your amazing application! 내용?
	              </div>
	              <!-- /.card-body -->
	              <div class="card-footer">
	                Footer 취향것
	              </div>
	              <!-- /.card-footer-->
	            </div>
	            <!-- /.card -->
	          </div>
	        </div>
	      </div>
	    </section>
	    <!-- /.end-->
	    
	<!--  하단 구역 수강 게시판 섹션 -->
	    <section class="content">
	      <div class="container-fluid">
	        <div class="row">
	<!-- 하단 구역 왼쪽 공지사랑 시작 -->
	          <div class="col-6">
	            <!-- Default box -->
	            <div class="card">
	              <div class="card-header">
	                <h3 class="card-title">LMS 공지사항 게시판</h3>
	                <div class="card-tools">
	                	<!-- 감추거나 지우는 버튼들 -->
	                	<a href="">더보기</a>
	                  <button type="button" class="btn btn-tool" data-card-widget="collapse" data-toggle="tooltip" title="Collapse">
	                    <i class="fas fa-minus"></i>
	                   </button>
	                  <button type="button" class="btn btn-tool" data-card-widget="remove" data-toggle="tooltip" title="Remove">
	                    <i class="fas fa-times"></i>
	                    </button>
	                </div>
	              </div><!-- End header -->
	              
	              <div class="card-body">
	               	공지사항 내용 n개 만 보여주고 더보기 링크 클릭하면 리스트페이지로? 
	              </div><!-- /.card-body -->
	              
	              <div class="card-footer">
	                Footer 취향것
	              </div><!-- /.card-footer-->
	            </div><!-- /.card -->
	          </div><!-- End col.6 -->
	          
	<!-- 하단구역 오른쪽 달력 시작-->
	          <div class="col-6">
	            <!-- Default box -->
	            <div class="card">
	              <div class="card-header">
	                <h3 class="card-title">달력구역</h3>
	                <div class="card-tools">
	                	<!-- 감추거나 지우는 버튼들 -->
	                  <button type="button" class="btn btn-tool" data-card-widget="collapse" data-toggle="tooltip" title="Collapse">
	                    <i class="fas fa-minus"></i>
	                   </button>
	                  <button type="button" class="btn btn-tool" data-card-widget="remove" data-toggle="tooltip" title="Remove">
	                    <i class="fas fa-times"></i>
	                    </button>
	                </div>
	              </div><!-- End header -->
	              
	              <div class="card-body">
	                달력내용
	              </div><!-- /.card-body -->
	              
	              <div class="card-footer">
	                Footer 취향것
	              </div><!-- /.card-footer-->
	            </div><!-- /.card -->
	          </div><!-- End col.6 -->
	        </div><!-- End row -->
	      </div>
	    </section>
	<!-- /.end 하단구역-->
	
    기존 링크들은 사이드바로?
		<c:choose>
			<c:when test="${loginUser != null}">
				<p>${loginUser.userName}님 환영합니다.</p>
				<c:if test="${loginUser.userLevel eq 4}">
						<!-- loginUser 레벨이 4일경우 승인 페이지로 갈수있는 링크 출력-->
				<a href="${pageContext.request.contextPath}/user/userList">승인 페이지</a>
				</c:if>
				<br>
				<a href="${pageContext.request.contextPath}/lmsNotice/LmsNoticeList">공지 리스트</a><br>
				<a href="${pageContext.request.contextPath}/sign/stDash">강좌대시보드</a><br>
				<a href="${pageContext.request.contextPath}/board/list?lectureNo=1">게시판</a><br>
				<a href="${pageContext.request.contextPath}/index/mypage">마이페이지</a><br>
				<a href="${pageContext.request.contextPath}/lmsMajor/MajorList">학과 리스트</a>
				<button  onclick="window.open('${pageContext.request.contextPath}/user/messageList'
				, '새창', 'width=300px, height=500px' , 'location=no' , 'toolbar=yes'); return false">메세지</button>
				
				<p><a href="${pageContext.request.contextPath}/index/logout">로그아웃</a></p>
			</c:when>
			
			<c:otherwise>
				<a href="${pageContext.request.contextPath}/index/login">로그인하러가기</a>
			</c:otherwise>
		</c:choose>
		
		
		</div>
     </div><!-- /.container-fluid -->
    </div>
    <!-- /.content -->
 <!-- 원래위치 -->
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
<%@include file="../view/import/footer.jsp" %>

 </div>
<!-- ./wrapper -->

<!-- 페이지 삽입 - 필수적인 script -->
<%@include file="../view/import/script.jsp" %>

</body>
</html>