<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
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
            <h1 class="m-0 text-dark">계정 승인 페이지</h1>
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/index">Home</a></li>
              <li class="breadcrumb-item active">계정 승인 페이지</li>
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
	<!-- 가입승인 대기페이지 ? level값을 y , n 으로 변경하여 활성화처리 -->
	<!-- 모든 user 정보를 볼 수 있는 페이지. -->
	<div>
		<table border="1">
			<thead>
				<tr>
					<th>ID</th>
					<th>사용자유형</th>
					<th>이름</th>
					<th>이메일</th>
					<th>전화번호</th>
					<th>성별</th>
					<th>가입일자</th>
					<th>계정 승인 여부</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="list" items="${list}">
				<tr>
					<td>${list.userId}</td>
					<td>
					<!-- Level값에 따라서 사용자 유형이 나뉘는데 db에는 숫자로 들어가있음.
						때문에 db에들어가있는 level값에 따라서 
						if문을 사용하여 사용자 유형을 출력해주었음.
					 -->
					<c:if test="${list.userLevel eq 1}">
						운영자
					</c:if>
					<c:if test="${list.userLevel eq 2}">
						교수
					</c:if>
					<c:if test="${list.userLevel eq 3}">
						학생
					</c:if>
					<c:if test="${list.userLevel eq 4}">
						관리자
					</c:if>
					</td>
					<td>${list.userName}</td>
					<td>${list.userEmail}</td>
					<td>${list.userTel}</td>
					<td>${list.userGender}</td>
					<td>${list.createDate}</td>
					<td>
					<form action="${pageContext.request.contextPath}/user/userList" method="post">
					<!-- Active값이 Y인것은 "승인완료" 출력
						 Active값이 N인것은 "승인대기" 출력
					 -->
					<input type="hidden" name="userId" value="${list.userId}">
					<select name="userActive">
						<c:if test="${list.userActive eq 'Y'}">
							<option value="Y" selected>승인 완료</option>
							<option value="N">승인 대기</option>
						</c:if>
						<c:if test="${list.userActive eq 'N'}">
							<option value="Y" >승인 완료</option>
							<option value="N" selected>승인 대기</option>
						</c:if>
					</select>
						<button type="submit">승인상태 변경</button>
					</form>
					
					</td>
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