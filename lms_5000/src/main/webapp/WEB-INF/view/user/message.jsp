<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>5000LMS | Login</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta name="viewport" content="width=device-width, initial-scale=1">

<%@include file="../import/reference.jsp" %>

</head>
<style>
	/* 받는사람ID가 db에 존재하는경우 = id가 유효한경우. */
	.trueMsg{
		color : green;
		display : none;
	}
	
	.falseMsg{
		color : red;
		display : none;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script>
	$(document).ready(function(){
		var idPass;
		
		$('#userId').on("propertychange change keyup paste input",function(){
			/* console.log("key up 테스트"); */
			var userId = $('#userId').val();
			var data = {userId : userId}
			
			$.ajax({
				type : "post",
				url : "/lms/user/idCheck",
				data : data,
				success : function(result){
					/* console.log("성공 여부 " + result); */
					if(result == 'true'){
						idPass = 'ok';
						$('.trueMsg').css("display","block");
						$('.falseMsg').css("display","none");
					} else {
						idPass = 'no';
						$('.falseMsg').css("display","block");
						$('.trueMsg').css("display","none");
					}
				}
			}); // ajax 종료
		});
		
		//아이디 검증
		verifyId = function(){
			if( $('#userId').val()== "" || idPass == 'ok' ){
				alert('Id를 확인해주세요');
				return false;
			}
			return true;
		};
		
		//회원가입 버튼 클릭시 각 항목 검증 성공시 제출
		$("#btn").click(function(){
			
			if(!verifyId()){
				console.log('false 테스트');
				return;
			} else{
				$('#form').submit();
			}
		});
		
	});
</script>
<body class="hold-transition sidebar-mini">

<!-- 전체 페이지 래퍼 -->
<div class="wrapper">


<!-- 페이지 삽입 - nav bar -->
<%@include file="../import/nav.jsp" %>

<!-- 페이지 삽입 - side bar -->
<%@include file="../import/sidebar.jsp" %>
<div>
	<c:if test="${errMsg != null }">
		<p>${errMsg }</p>
	</c:if>
</div>
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
              <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/user/messageList">MessageList</a></li>
              <li class="breadcrumb-item active">Message</li>
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
	  <form action="${pageContext.request.contextPath}/user/message" id="form" method="post">
	  		보낸이
			<input type="hidden" value="${loginUser.userId}" name="sendId">
			<c:choose>
          	<c:when test="${loginUser.userId != null}">
          		 ${loginUser.userId}님
          	</c:when>
          	<c:otherwise>
          		Guest님
          	</c:otherwise>
          	</c:choose>
          	<br>
			받는사람
			<!-- Id입력공간 -->
          	<input type="text" name="receiveId" id="userId">
          	<div class="trueMsg">받는사람 ID를 확인해주세요.</div>
			<div class="falseMsg"></div>
			<br>
			제목
			<input type="text" name="messageTitle">
			<br>
			<!-- 같은 강의 듣는사람 강의 교수 리스트 선택할수 있거나 검색하는방법으로 -->
			 내용 
			<textarea rows="20" cols="100" name="messageContent"></textarea>
			
			<br>
			<button type="button" class="btn btn-sm btn-primary">메시지 전송</button>
      </form>
		<div style="position: absolute; right: 0px; bottom :60px;">
		 <a href="${pageContext.request.contextPath}/user/messageList"><button type="submit" class="btn btn-sm btn-primary" > 보관함으로 돌아가기 </button></a>
		</div>
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

<!-- jQuery -->
<script src="${pageContext.request.contextPath}/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="${pageContext.request.contextPath}/dist/js/adminlte.min.js"></script>

</body>
</html>
