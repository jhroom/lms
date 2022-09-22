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
      <h3>시험 문제 만들기</h3>
		<form action="${pageContext.request.contextPath}/test/addTest" method="post">
		<input type="hidden" name="lectureNo" value="${lectureNo}">
			<label for="testName">시험 이름</label>
			<input type="text" name="testName" id="testName">
			<label for="testStarttime">시험 시작 시간</label>
			<input type="datetime-local" name="testStarttime">
			<label for="testStarttime">시험 마감 시간</label>
			<input type="datetime-local" name="testEndtime">
			
			
			<!-- 시험문제 -->
			<table id="questions" border="1">
				<tr>
					<td>
						<label for="questionContents">문제</label>
						<input type="text" name="questionContents" id="questionContents">
						<label for="questionAnswer">답</label>
						<input type="number" id="questionAnswers" name="questionAnswers">
					<table>
						<tr>
							<td>
								<br/>
									<label for="choiceContent">보기 1</label>
									<input type="text" name="choiceContents" id="choiceContents">
					
								<br/>
									<label for="choiceContent">보기 2</label>
									<input type="text" name="choiceContents" id="choiceContents">
								<br/>
									<label for="choiceContent">보기 3</label>
									<input type="text" name="choiceContents" id="choiceContents">
								<br/>
									<label for="choiceContent">보기 4</label>
									<input type="text" name="choiceContents" id="choiceContents">
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<!-- 시험문제 끝 -->
				
				
			
			</table>
		<button type="submit" >시험 추가</button>
		</form>
		
		<button type="button"id="addQBtn">문제 추가</button>


      
      



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

<!-- 문제 추가 -->
<script>
$(document).ready(function(){
	$("#addQBtn").on("click", function(){

	var row = '<tr> <td> <label for="questionContents">문제</label> <input type="text" id="questionContents" name="questionContents"> <label for="questionAnswer">답</label> <input type="number" id="questionAnswers" name="questionAnswers"> <table> <tr> <td> <br/> <label for="choiceContent">보기 1</label> <input type="text" name="choiceContents" id="choiceContents">  <br/> <label for="choiceContent">보기 2</label> <input type="text" name="choiceContents" id="choiceContents"> <br/> <label for="choiceContent">보기 3</label> <input type="text" name="choiceContents" id="choiceContents"> <br/> <label for="choiceContent">보기 4</label> <input type="text" name="choiceContents" id="choiceContents"> </td> </tr> </table> <button class="removeQBtn">문제 삭제</button></td> </tr>';
		
	$("#questions").append(row);

	$(".removeQBtn").on("click", function(){

		$(this).prev().remove();
		$(this).prev().remove();
		$(this).prev().remove();
		$(this).prev().remove();
		$(this).prev().remove();
		$(this).next().remove();

		
		$(this).remove();
		return;
		});//end remove
	
	});	//end click

});	//end ready

</script>
</body>
</html>
