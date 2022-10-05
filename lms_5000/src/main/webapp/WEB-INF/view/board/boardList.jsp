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
            <h1 class="m-0 text-dark">과목 게시판</h1>
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

	<!-- 게시판 구역 -->

<!-- 		<!-- 공지사항 -->
<!-- 		<div> -->
<%-- 			<h3><a href="${pageContext.request.contextPath}/board/post?boardNo=${noticeNo}&boardName=공지사항">과목 공지사항</a></h3> --%>

<!-- 		</div> -->
		
		
<!-- 		<!-- Qna --> 
<!-- 		<div> -
<%-- 			<h3><a href="${pageContext.request.contextPath}/board/post?boardNo=${qnaNo}&boardName=QNA">과목 Qna</a></h3> --%>

<!-- 		</div> -->
			
			

	        <div class="row">
	<!-- 하단 구역 왼쪽 공지사랑 시작 -->
	          <div class="col-12">
	          	<div class="card">
	              <div class="card-header">
	                <h3 class="card-title">과목 게시판</h3>
	                
	                <div class="card-tools">
	                	<!-- 감추거나 지우는 버튼들 -->
	                  <button type="button" class="btn btn-tool" data-card-widget="collapse" data-toggle="tooltip" title="Collapse"> <i class="fas fa-minus"></i> </button>
	                  <button type="button" class="btn btn-tool" data-card-widget="remove" data-toggle="tooltip" title="Remove"> <i class="fas fa-times"></i> </button>
	                </div>
	              </div>
	              <!-- End header -->
	              
	              <div class="card-body">
					<c:if test="${loginUser.userLevel eq 2}">
						<a href="${pageContext.request.contextPath}/board/add/form?lectureNo=${lectureNo}">게시판 만들기</a>
					</c:if>
					<table class="table table-hover text-nowrap">
						<thead>
							<tr>
								<th>게시판 번호</th><th>게시판 이름</th><th>게시판 생성일</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="n" items="${boardList}">
									<tr>
										<td>${n.boardNo}</td><td><a href="${pageContext.request.contextPath}/board/post?boardNo=${n.boardNo}&boardName=${n.boardName}&lectureNo=${lectureNo}">${n.boardName}</a></td><td>${n.createDate}</td>
									</tr>
							</c:forEach>
						</tbody>
					</table>
					<!-- end table -->
					
					<!-- 페이징 영역 -->
					<div>

					
					</div>
					<!-- end 페이징 영역 -->
	              </div>
	              <!-- end card-body -->
	              <div class="card-footer">
					  <nav aria-label="Contacts Page Navigation">
			            <ul class="pagination justify-content-center m-0">
			            	<li class="page-item "><a class="page-link" href="${pageContext.request.contextPath}/board/list?lectureNo=${lectureNo}&currentPage=1">첫페이지</a></li>
			            	<li class="page-item "><a class="page-link" href="${pageContext.request.contextPath}/board/list?lectureNo=${lectureNo}&currentPage=${currentPage - 1}">이전쪽</a></li>
								<c:forEach items="${pages}" var="p">
									<c:if test="${p eq currentPage}">

						              <li class="page-item active"><a class="page-link" href="${pageContext.request.contextPath}/board/list?lectureNo=${lectureNo}&currentPage=${p}">${p}</a></li>
						            </c:if>
						            <c:if test="${p ne currentPage}">
						              <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/board/list?lectureNo=${lectureNo}&currentPage=${p}">${p}</a></li>
						            </c:if>
								</c:forEach>
							<li class="page-item "><a class="page-link" href="${pageContext.request.contextPath}/board/list?lectureNo=${lectureNo}&currentPage=${currentPage + 1}">다음쪽</a></li>
							<li class="page-item "><a class="page-link" href="${pageContext.request.contextPath}/board/list?lectureNo=${lectureNo}&currentPage=${realLastPage}">막페이지</a></li>
			            </ul> 
			          </nav>
	              </div>
	              <!-- /.card-footer-->
	            </div>
	            <!-- /.card -->
	          </div>
	          <!-- End col12 -->
		</div>
		<!-- End row -->

			
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

