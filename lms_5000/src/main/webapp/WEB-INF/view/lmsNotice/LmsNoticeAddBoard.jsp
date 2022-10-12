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
            <h1 class="m-0 text-dark">공지사항 작성</h1>
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/index">Home</a></li>
              <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/lmsNotice/LmsNoticeList">LmsNotice List</a></li>
              <li class="breadcrumb-item active">Add LmsNotice</li>
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
          
    
    <form action="${pageContext.request.contextPath}/lmsNotice/LmsNoticeAddBoard//add" method="post" enctype="multipart/form-data">
		<input type="hidden" name="boardNo" id="boardNo" value="${lmsNoticeNo}">
		<table class="table table-hover text-nowrap">
			
			<tbody>
				<tr>
					<th>제목</th>
					<td><input class ="form-control" type="text" name="lmsNoticeTitle" id="lmsNoticeTitle"></td>
				</tr>
				
				<tr>
				<!-- 작성자는 db에는 없기 때문에 혹시나 입력된대로 게시판에 들어가면 어떨까 생각해봤습니다. -->
				<!-- 그래서 만약 잘만 된다면 db에 작성자란을 만들고 거기에 직접 입력하는 식으로 만드는거죠. -->
					<th>작성자</th>
					<td>
						<input class ="form-control" type="text" name="lmsNoticeName" id="lmsNoticeName" value="${loginUser.userId}(${loginUser.userName})" readonly="readonly"> 
					</td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea class ="form-control" name="lmsNoticeContent" id="lmsNoticeContent" style= "width:100%; height:6.25em;resize:none"></textarea></td>
				</tr>		
				<tr>
					<th>파일</th>
					<td><input type="file" name="lmsFile" id="lmsFile"></td>
					
				</tr>		
			</tbody>
		</table>
		<button class="btn btn-success" type="submit">작성하기</button>
	<!--  	<button type="submit" onclick="javascript:form.action='${pageContext.request.contextPath}/lmsNotice/LmsNoticeList'">글목록</button>-->
		
	</form>

      


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

