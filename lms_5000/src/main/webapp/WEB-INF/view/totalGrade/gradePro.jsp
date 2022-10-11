<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="x-ua-compatible" content="ie=edge">

<title>LMS 5000</title>

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
            <h1 class="m-0 text-dark">교수 성적 처리 페이지</h1>
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item active">성적</li>                  
              <li class="breadcrumb-item active"><a href="${pageContext.request.contextPath}/dashBoard/lectureDashBoard?lectureNo=${lectureNo}">${lectureName}</a></li>
              <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/index">메인페이지</a></li>
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
	  <div class="col-sm-2">
      	<a href="${pageContext.request.contextPath}/grade/pro/final?lectureNo=${lectureNo}" ><button class="btn btn-block btn-secondary"> 최종 학점 산출 버튼</button></a>
	  </div>
      </br>
	  <input type="hidden" name="lectureNo" value="${lectureNo}">
      <form action="${pageContext.request.contextPath}/grade/pro/cal" method="post">
	  <input type="hidden" name="lectureNo" value="${lectureNo}">
      <div class="col-sm-2">
  		 <button type="submit" class="btn btn-block btn-info">성적 산출 버튼</button>
      </div>
      </br>
	  <div class="card">
	     <div class="card-body table-responsice p-0">
           <table class="table table-hover text-nowrap">
		      <thead>
			      <tr>
			      	<th>학생 이름</th>
			      	<th>학생 아이디</th>
			      	<th>시험점수</th>
			      	<th class="col-sm-1">과제 점수<button id="paperTogleBtn" type="button" class="btn btn-block btn-secondary">수정</button></th>
			      	<th>출석 점수</th>
			      	<th>총점</th>
			      	<th>등수</th>
			      	<th>학점</th>
			      </tr>
		      </thead>
		      <tbody>
			      <c:forEach items="${stuGradeList}" var="s">
			      
				      <tr>
				      	<td>${s.stName}</td>
				      	<td>${s.userId}</td>
				      	<td>${s.gradeTest}</td>
				      	<td><input type="number" min="0" max="100" class="paper" name="paper" value="${s.gradePaper}" readonly></td>
				      	<td>${s.gradeAtt}</td><td>${s.gradeTotal}</td><td>${s.gradeRank}</td><td>${s.totalGrade}</td>
				      </tr>
				  </c:forEach>
		      </tbody>
	      </table>
	       </div>
	  </div>
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

<script>

//과제 토글 버튼 컨트롤
//누르고 끄는걸로 입력을 조절할 수 있다.
$('#paperTogleBtn').click(function(){
	if($('.paper').prop('readonly')){
		alert('이제 과제 점수를 수정할 수 있습니다.');
		$('.paper').attr('readonly', false);
		const btnElement = document.getElementById('paperTogleBtn');
		  btnElement.innerText = '완료';
		
		console.log($('.paper').prop('readonly'));
	} else{
		alert('과제 점수 수정을 완료합니다. 성적 산출 버튼을 클릭해야 값이 저장됩니다.');
		$('.paper').attr('readonly', true);
		const btnElement = document.getElementById('paperTogleBtn');
		  btnElement.innerText = '수정';
	}
	
})

</script>
<script>
    var data =
    {
        labels: ["1월", "2월", "3월", "4월", "5월", "6월"],
        datasets:
            [{
                label: "My First dataset",
                fillColor: "rgba(150,200,250,0.5)",
                strokeColor: "rgba(150,200,250,0.8)",
                highlightFill: "rgba(150,200,250,0.75)",
                highlightStroke: "rgba(150,200,250,1)",
                data: [65, 59, 80, 81, 56, 55]
            }]
    };

    var options = { animation: false };
    var ctx = $('#myChart').get(0).getContext('2d');
    var myBarChart = new Chart(ctx).Bar(data, options); 
</script>
</body>
</html>

