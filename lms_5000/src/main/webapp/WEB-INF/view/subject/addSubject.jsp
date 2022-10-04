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
              <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/index">Home</a></li>
              <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/lmsSubject/SubjectList">Subject List</a></li>
              <li class="breadcrumb-item active">Add Subject</li>
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
      
      
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>강좌 추가</title>
</head>
<body>
	<div>
		<h3>강좌 추가</h3>	
	</div>
	<div>
		<form action="${pageContext.request.contextPath}/lmsSubject/addSubject/add" method="get">
		
		<table class="table table-hover text-nowrap">
			<tbody>
				<tr>
					<th>학과번호</th>
					<td>
						<select name="majorNo" id="majorNo">
							<option selected>학과번호</option>
							<c:forEach var="m" items="${getMajorList}">
								<option value="${m.majorNo}">${m.majorNo}. ${m.majorName}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<th>강좌이름</th>
					<td><input type="text" name="subjectName" id="subjectName" ></td>
				</tr>
				<tr>
					<th>이수학점</th>
					<td>
						<select name="subjectPoint" id="subjectPoint">
							<option value="default">학점을 선택하세요.</option>
							<option value="1">1학점</option>
							<option value="2">2학점</option>
							<option value="3">3학점</option>
						
						</select>
					</td>
				</tr>
				<tr>
					<th>대상학년</th>
					<td>
						<select name="subjectGrade">
							<option value="default">대상학년을 선택하세요.</option>
							<option value="1">1학년</option>
							<option value="2">2학년</option>
							<option value="3">3학년</option>
							<option value="4">4학년</option>
						</select>
					</td>
				</tr>
			</tbody>
		</table>
		<button class="btn btn-success" type="submit">추가하기</button>
		</form>
	</div>

</body>
</html>
      
      



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

