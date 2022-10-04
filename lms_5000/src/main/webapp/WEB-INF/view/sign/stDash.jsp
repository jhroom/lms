<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="${pagaContext.request.contextPath}/lms/index">LMS 메인 페이지</a></li>
              <li class="breadcrumb-item active">수강 과목 목록</li>
            </ol>
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content-header -->

    <!-- Main content -->
    <!-- 메인 콘텐츠 -->
    <div class="col-sm-03"></div>
  	<div>
		<c:choose>
			<c:when test="${loginUser != null}">
				<h3>${loginUser.userName}님 환영합니다.</h3>
				<br>
					<div class="col-sm-3">
						<button  onclick="window.open('${pageContext.request.contextPath}/sign/openLectureList'
						, '새창', 'width=1280px, height=900px' , 'location=center' , 'toolbar=yes'); return false" id="cyw" type="button" class="btn btn-block btn-primary">수강신청
						</button>
					   <a href="${pageContext.request.contextPath}/sign/openLectureList"></a><br>
					</div>
			</c:when>
		</c:choose>
	</div>
    <div class="content">
    <div class="container-fluid">
	<div class="card">
		 <div class="card-header">
		 	<h2 class="card-title"><strong>강의 목록</strong></h2>
		 </div>
         <div class="card-body table-responsice p-0">
           <table class="table table-hover text-nowrap">
           	 <thead>
	           	 <tr>
	           	 	<th>강의명</th>
	           	 	<th>수업요일</th>
	           	 	<th>강의실</th>
	           	 	<th>교수이름</th>
	           	 </tr>
           	 </thead>
           	 <tbody>
           	 	 <c:forEach var="a" items="${signList}">
	           	 	 <tr>
						<td>
							<a href="${pageContext.request.contextPath}/dashBoard/lectureDashBoard?userId=${loginUser.userId}&lectureNo=${a.lecture_no}">${a.subject_name}</a>
						</td>     	 	
						<td>
							<c:choose>
								<c:when test="${a.lecture_day eq 1}">월요일</c:when>
								<c:when test="${a.lecture_day eq 2}">화요일</c:when>
								<c:when test="${a.lecture_day eq 3}">수요일</c:when>
								<c:when test="${a.lecture_day eq 4}">목요일</c:when>
								<c:when test="${a.lecture_day eq 5}">금요일</c:when>
								<c:when test="${a.lecture_day eq 6}">토요일</c:when>
								<c:when test="${a.lecture_day eq 7}">일요일</c:when>
								<c:otherwise>요일을 다시 확인해 주세요</c:otherwise>
							</c:choose>
						</td> 	 	 
						<td>${a.classroom_no} 강의실</td>           	 	 
						<td>${a.pro_name} 교수</td>           	 	 
	           	 	 </tr>
           	 	 </c:forEach>
           	 </tbody>
		   </table>
        </div>
    </div><!-- /.card -->
	</div>
	<div class="col-sm-2"></div>
	<div class="col-sm-5">
	</div>
	</div>
        <!-- /.row -->
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
<!-- ./wrapper -->

<!-- 페이지 삽입 - 필수적인 script -->
<%@include file="../import/script.jsp" %>

</body>
<script>
//Date date = new DATE();

let a = 'ddd';
console.log(a);

let date = new Date();
console.log(date);
console.log(date.getFullYear()); // 년도
console.log(date.getMonth()+1); // 월
console.log(date.getDate()); // 일
console.log(date.getHours()); // 시간
console.log(date.getMinutes()); // 분
console.log(date.getSeconds()); // 초

let dataMonth = (date.getMonth()+1)
if(dataMonth < 10){
	dataMonth = '0'+(date.getMonth()+1) 
}

let nowDate = ''+date.getFullYear()+dataMonth+date.getDate()+date.getHours()+date.getMinutes()+'00';
console.log(nowDate);

let chooseDate = '202209030000'; //  지정데이터 (지정된 시간을 넣을 변수)
console.log(document.getElementById('cyw'));
if(chooseDate > nowDate){
	document.getElementById('cyw').style.display="none";
}else{
	document.getElementById('cyw').style.display="block";
}


</script>
</html>