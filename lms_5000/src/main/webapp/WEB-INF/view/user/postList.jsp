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
            <h1 class="m-0 text-dark">My post list</h1>
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/index/mypage">mypage</a></li>
              <li class="breadcrumb-item active">My post</li>
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
      	<div class="col-12">
            <div class="card">
              <div class="card-header">
                <h3 class="card-title"><Strong>게시글 작성 목록</Strong></h3>

                <!-- <div class="card-tools">
                  <div class="input-group input-group-sm" style="width: 150px;">
                    <input type="text" name="table_search" class="form-control float-right" placeholder="Search">

                    <div class="input-group-append">
                      <button type="submit" class="btn btn-default"><i class="fas fa-search"></i></button>
                    </div>
                  </div>
                </div> -->
              </div>
              <!-- /.card-header -->
              <div class="card-body table-responsive p-0">
                <table class="table table-hover text-nowrap">
                <c:choose>
                	<c:when test="${loginUser.userLevel == 1 }">
                		<thead>
		                    <tr>
		                      <th>게시판</th>
		                      <th>제목</th>
		                      <th>조회수</th>
		                      <th>작성일</th>
		                      <th>수정일</th>
		                    </tr>
		                  </thead>
		                  <tbody>
		                    <c:forEach var="b" items="${boardList}">
							<tr>
								<td>${b.boardType}</td>
								<td><a href="${pageContext.request.contextPath}/lmsNotice
								/LmsNoticeOne?lmsNoticeNo=${b.noticeNo}&lmsNoticeTitle=${b.noticeTitle}">
								${b.noticeTitle}</a></td>
								<td>${b.count}</td>
								<td>${b.createTime}</td>
								<td>${b.updateTime}</td>
							</tr>
							</c:forEach>
		                  </tbody>
                	</c:when>
                	<c:when test="${loginUser.userLevel == 2 || loginUser.userLevel == 3}">
                		<thead>
		                    <tr>
		                      <th>과목</th>
		                      <th>게시판</th>
		                      <th>제목</th>
		                      <th>조회수</th>
		                      <th>작성일</th>
		                      <th>수정일</th>
		                    </tr>
		                  </thead>
		                  <tbody>
		                    <c:forEach var="b" items="${boardList}">
							<tr>
								<%-- <td>${b.majorName}</td> --%>
								<td>${b.subjectName}</td>
								<td>${b.boardName}</td>
								<td><a href="${pageContext.request.contextPath}/board/post/one?
								boardPostNo=${b.boardPostNo}&boardNo=${b.boardNo}&boardName=${b.boardName}
								&lectureNo=${b.lectureNo}&boardType=${b.boardType}">
								${b.boardPostName}</a></td>
								<td>${b.count}</td>
								<td>${b.boardPostCreatedate}</td>
								<td>${b.boartPostUpdatedate}</td>
							</tr>
							</c:forEach>
		                  </tbody>
                	</c:when>
                </c:choose>
                </table>
              </div>
              <!-- /.card-body -->
            </div>
            <!-- /.card -->
            <div>
	            <ul class="pagination">
	              <c:choose>
		              	<c:when test="${pg.nowPage == 1}">
		              		<li class="page-item disabled"><a class="page-link" href="${pageContext.request.contextPath}/index/mypage/postList?nowPage=${pg.nowPage-1}">Previous</a></li>
		              	</c:when>
		              	<c:otherwise>
		              		<li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/index/mypage/postList?nowPage=${pg.nowPage-1}">Previous</a></li>
		              	</c:otherwise>
	              </c:choose>
	              		<c:forEach var="p" begin="${pg.startPage}" end="${pg.endPage}">
	              			<c:choose>
	              				<c:when test="${ p == pg.nowPage }">
	              					<li class="page-item active"><a class="page-link" href="${pageContext.request.contextPath}/index/mypage/postList?nowPage=${p}">${p}</a></li>
	              				</c:when>
	              				<c:otherwise>
	              					<li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/index/mypage/postList?nowPage=${p}">${p}</a></li>
	              				</c:otherwise>
	              			</c:choose>
	              		</c:forEach>
				  <c:choose>
				  		<c:when test="${pg.nowPage >= pg.lastPage}">
				  			<li class="page-item disabled"><a class="page-link" href="${pageContext.request.contextPath}/index/mypage/postList?nowPage=${pg.nowPage+1}">Next</a></li>
				  		</c:when>
				  		<c:otherwise>
				  			<li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/index/mypage/postList?nowPage=${pg.nowPage+1}">Next</a></li>		
				  		</c:otherwise>
				  </c:choose>
				</ul>
			</div>
          </div>  <!-- End col-12 -->
	  </div>    <!-- End row -->
      </div>  <!-- /.container-fluid -->
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

