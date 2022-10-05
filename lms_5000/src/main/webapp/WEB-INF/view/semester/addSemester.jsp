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
            <h1 class="m-0 text-dark">학기 추가</h1>
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/index">Home</a></li>
              <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/lmsSemester/SemesterList">Semester List</a></li>
              <li class="breadcrumb-item active">Add Semester</li>
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
	
		<form action="${pageContext.request.contextPath}/lmsSemester/addSemester/add" method="post">

		<table class="table table-hover text-nowrap">
			<tbody>
				<tr>
					<th>년도</th>
					<td>
						<select name="semesterYear" id="semesterYear">
							<option value="default">년도를 선택하세요.</option>
							<option value="2022">2022년</option>
							<option value="2023">2023년</option>
							<option value="2024">2024년</option>
						<option value="2025">2025년</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>학기</th>
					<td>
						<select name="semesterSession" id="semesterSession">
							<option value="defualt">학기를 선택하세요</option>
							<option value="1">1학기</option>
							<option value="2">2학기</option>
							
						</select>
					</td>
				</tr>
				<tr>
					<th>개강일</th>
					<td>
						<input type="date" name="semesterStartdate" id="semesterStartdate">
					</td>				
				</tr>
				<tr>
					<th>종강일</th>
					<td>
						<input type="date" name="semesterEnddate" id="semesterEnddate">
					</td>
				</tr>
			</tbody>
		</table>
		<button type="submit" class="btn btn-success">추가</button>
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

