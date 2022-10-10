<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
            <h1 class="m-0 text-dark">게시글 작성</h1>
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
			<div>
				<form action="${pageContext.request.contextPath}/board/post/add" method="post" enctype="multipart/form-data">
					<input type="hidden" name="boardNo" id="boardNo" value="${board.boardNo}">
					<input type="hidden" name="lectureNo" id="lectureNo" value="${board.lectureNo}">
					<input type="hidden" name="boardType" id="boardType" value="${board.boardType}">
					
					
					<table class="table table-hover text-nowrap">
						<thead>
							<tr>
								<th>구분</th><th>내용</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<th>게시판</th>
								<td><input class="form-control" type="text" name="boardName" id="boardName" value="${board.boardName}" readonly></td>
							</tr>
							<tr>
								<th>제목</th>
								<td><input class="form-control" type="text" name="boardPostTitle" id="boardPostTitle"></td>
							</tr>
							
							<tr>
								<th>작성자</th>
								<td><input class="form-control" type="text" name="boardPostWriter" id="boardPostWriter" value="${loginUser.userName}(${loginUser.userId})" readonly></td>
							</tr>
							<tr>
								<th>내용</th>
								<td><textarea class="form-control" name="boardPostContent" id="boardPostContent" style="width:100%;height: 6.25em;resize: none;"></textarea></td>
							</tr>		
							<tr>
								<th>첨부파일</th>
								<td><input type="file" name="uploadFile" id="uploadFile"></td>
								<!-- 파일 넘기는법 연구필요 -->
							</tr>		
						</tbody>
					</table>
					<button class="btn btn-success" type="submit">제출하기</button>
				</form>
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


