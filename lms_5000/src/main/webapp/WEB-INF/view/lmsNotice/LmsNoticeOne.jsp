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
      
     <div>
		<h3>공지 상세보기</h3>
		<table border="1" bordercolor="green">
			<tbody>
				<tr>
					<th>번호</th>
					<td>${noticeOne.lmsNoticeNo}</td>
				</tr>
				<tr>
					<th>제목</th>
					<td>${noticeOne.lmsNoticeTitle}</td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>${noticeOne.lmsNoticeName}</td>				
				</tr>
				<tr>
					<th>내용</th>
					<td>${noticeOne.lmsNoticeContent}</td>			
				</tr>
				<tr>
					<th>작성일</th>
					<th>${noticeOne.lmsNoticeCreatetime}</th>
				</tr>
				<tr>
					<th>수정일</th>
					<th>${noticeOne.lmsNoticeUpdatetime}</th>
				</tr>
				<tr>
					<th>조회수</th>
					<th>${noticeOne.count }</th>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td>
						<a href="${pageContext.request.contextPath}/lmsNotice/downloadFile?fileName=${noticeOne.fileName}&lmsNoticeNo=${noticeOne.lmsNoticeNo}">${noticeOne.fileOriginname}</a>
					</td>
				</tr>
					
			</tbody>
			
		</table>
		
		<a href="${pageContext.request.contextPath}/lmsNotice/deleteLmsNotice?lmsNoticeNo=${lmsNoticeNo}&lmsNotice/lmsNoticeTitle=${lmsNoticeTitle}" class="btn btn-info" role="button">삭제</a>
		&nbsp; 
		<a href="${pageContext.request.contextPath}/lmsNotice/UpdateLmsNotice/form?lmsNoticeNo=${lmsNoticeNo}&lmsNotice/lmsNoticeTitle=${lmsNoticeTitle}" class="btn btn-info" role="button">수정</a>
		&nbsp; 
		<a href="${pageContext.request.contextPath}/lmsNotice/LmsNoticeList" class="btn btn-info" role="button">리스트</a>
		
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

