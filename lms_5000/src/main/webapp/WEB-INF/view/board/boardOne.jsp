<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
            <h1 class="m-0 text-dark">${boardName} 게시판</h1>
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
				<div>

					<table class="table table-hover text-nowrap">
						<thead>
							<tr>
								<th>구분</th><th>내용</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<th>제목</th>
								<td>${boardOne.boardPostTitle}</td>
							</tr>
							<tr>
								<th>작성자</th>
								<td>${boardOne.boardPostWriter}</td>
							</tr>
							<tr>
								<th>작성일</th>
								<td>${boardOne.boardPostCreatedate}</td>
							</tr>
							<tr>
								<th>수정일</th>
								<td>${boardOne.boardPostUpdatedate}</td>
							</tr>
							<tr>
								<th>조회수</th>
								<td>${boardOne.count}</td>
							</tr>
							<tr>
								<th>내용</th>
								<td>${boardOne.boardPostContent}</td>
							</tr>		
							<tr>
								<th>첨부파일</th>
								<td>
									<a href="${pageContext.request.contextPath}/board/download/file?fileName=${boardOne.fileName}&boardPostNo=${boardOne.boardPostNo}&boardNo=${boardNo}&boardName=${boardName}">
										${boardOne.fileOriginname}
									</a>
								</td>
							</tr>		
			
						</tbody>
					</table>
					
					<!-- 작성자 이름 설정 -->
					<c:set var="writer" value="${loginUser.userName}(${loginUser.userId})"/>
					
					<c:if test="${loginUser.userLevel eq 2 || writer eq boardOne.boardPostWriter}">
						<a href="${pageContext.request.contextPath}/board/modifyPost/form?boardPostNo=${boardOne.boardPostNo}&boardName=${boardName}&boardNo=${boardNo}">수정</a>
						<a href="${pageContext.request.contextPath}/board/removePost?boardPostNo=${boardOne.boardPostNo}&fileName=${boardOne.fileName}&boardName=${boardName}&boardNo=${boardNo}">삭제</a>
					</c:if>
				</div>




	              </div>
	              <!-- end card-body -->
	              <div class="card-footer">
	                Footer 취향것
	              </div>
	              <!-- /.card-footer-->
	            </div>
	            <!-- /.card -->
	          </div>
	          <!-- End col12 -->
		</div>
		<!-- End row -->
      

      
      
          	    <div class="row">
	<!-- 하단 구역 왼쪽 공지사랑 시작 -->
	          <div class="col-12">
	          	<div class="card">
	              <div class="card-header">
	                <h3 class="card-title">댓글</h3>
	                
	                <div class="card-tools">
	                	<!-- 감추거나 지우는 버튼들 -->
	                  <button type="button" class="btn btn-tool" data-card-widget="collapse" data-toggle="tooltip" title="Collapse"> <i class="fas fa-minus"></i> </button>
	                  <button type="button" class="btn btn-tool" data-card-widget="remove" data-toggle="tooltip" title="Remove"> <i class="fas fa-times"></i> </button>
	                </div>
	              </div>
	              <!-- End header -->
	              
	              <div class="card-body">
	              
				<!-- 댓글 입력 폼 -->
      			<div>
				<form action="${pageContext.request.contextPath}/board/addComment" method="get">
					
					<input type="hidden" name="boardPostNo" value="${boardOne.boardPostNo}">
					<input type="hidden" name="boardName" value="${boardName}">
					<input type="hidden" name="boardNo" value="${boardNo}">
					
					<textarea class="form-control" name="commentContent"></textarea>
					<button class="btn btn-success"type="submit">댓글 달기</button>
				</form>
				
				</div>
				
				<!-- 댓글 리스트 -->
				<div>
					<table  class="table table-hover text-nowrap">
						<thead>
						<tr>
							<th style="width:20%">작성자</th><th style="width:70%">내용</th><th style="width:10%"></th>
						</tr>
						</thead>
						<tbody>
							<c:forEach items="${commentList}" var="m">
								<tr>
									<td>${m.commentWriter}</td><td>${m.commentContent}</td>
									<td>
										<c:if test="${loginUser.userLevel eq 2||writer eq m.commentWriter}">
											<a href="${pageContext.request.contextPath}/board/removeComment?commentNo=${m.commentNo}&boardPostNo=${boardOne.boardPostNo}&boardName=${boardName}&boardNo=${boardNo}">삭제</a>
										</c:if>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				
				</div>

	              </div>
	              <!-- end card-body -->
	              <div class="card-footer">
	                Footer 취향것
	              </div>
	              <!-- /.card-footer-->
	            </div>
	            <!-- /.card -->
	          </div>
	          <!-- End col12 -->
		</div>
		<!-- End row -->
      
      
      
			<div>
			
				
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


