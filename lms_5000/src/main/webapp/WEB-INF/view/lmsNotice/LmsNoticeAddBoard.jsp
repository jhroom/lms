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
            <h1 class="m-0 text-dark">Starter Page</h1>
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
      <div class="container">
    <h1>LMS 공지사항 작성</h1>
    <form action="${pageContext.request.contextPath}/lmsNotice/LmsNoticeAddBoard//add" method="post" enctype="multipart/form-data">
		<input type="hidden" name="boardNo" id="boardNo" value="${lmsNoticeNo}">
		<table border="1" bordercolor="green">
			
			<tbody>
				<tr>
					<th>제목</th>
					<td><input type="text" name="lmsNoticeTitle" id="lmsNoticeTitle"></td>
				</tr>
				
				<tr>
				<!-- 작성자는 db에는 없기 때문에 혹시나 입력된대로 게시판에 들어가면 어떨까 생각해봤습니다. -->
				<!-- 그래서 만약 잘만 된다면 db에 작성자란을 만들고 거기에 직접 입력하는 식으로 만드는거죠. -->
					<th>작성자</th>
					<td><input type="text" name="lmsNoticeName" id="LmsNoticeName" value="작성자의 이름을 쓰시오" ></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea name="lmsNoticeContent" id="lmsNoticeContent"></textarea></td>
				</tr>		
				<tr>
					<th>파일</th>
					<td><input type="file" name="lmsFile" id="lmsFile"></td>
					
				</tr>		
			</tbody>
		</table>
		<button type="submit">작성하기</button>
	<!--  	<button type="submit" onclick="javascript:form.action='${pageContext.request.contextPath}/lmsNotice/LmsNoticeList'">글목록</button>-->
		
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

