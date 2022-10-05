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
            <h1 class="m-0 text-dark">메세지</h1>
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/index">Home</a></li>
              <li class="breadcrumb-item active">MessageList</li>
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
		<a href="${pageContext.request.contextPath}/user/messageList">전체 메시지 리스트</a>
		<a href="${pageContext.request.contextPath}/user/sendmessageList">보낸 메시지 리스트</a>
		<a href="${pageContext.request.contextPath}/user/receivemessageList">받은 메시지 리스트</a>
		<table class="table table-hover text-nowrap">
			<thead>
				<tr>
					<th>보낸 사람</th>
					<th>받는 사람</th>
					<th>메시지 제목</th>
					<th>받은 시간</th>
					<th>확인 여부</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="list" items="${list}">
					<tr>
						<td>${list.sendId}</td>
						<td>${list.receiveId}</td>
						<td>
						<input type="hidden" value="${list.receiveId}"> 
						<input type="hidden" value="${list.messageNo}">
						<a href="${pageContext.request.contextPath}/user/messageOne?messageNo=${list.messageNo}">${list.messageTitle}</a>
						</td>
						<td>${list.createTime}</td>
						<td>${list.messageState}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="${pageContext.request.contextPath}/user/message">
		<button type="button" class="btn btn-sm btn-primary">메세지 보내기</button>
		</a><br>
		<div style="position: absolute; right: 0px; bottom :60px;">
			메시지는 60일 보관이후 삭제됩니다.
		</div>
	</div>
	
		<ul class="pagination">
             <c:if test="${currentPage > 1}">
                    <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/user/messageList?currentPage=${currentPage-1}">이전</a></li>
             </c:if>
			 <c:if test="${currentPage < lastPage}">
			    	<li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/user/messageList?currentPage=${currentPage+1}">다음</a></li>
			</c:if>
		</ul>	
		
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