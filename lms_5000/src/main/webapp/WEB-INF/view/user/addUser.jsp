<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="x-ua-compatible" content="ie=edge">

<title>Insert title here</title>
<!-- 페이지 삽입 - 필수적인 레퍼런스(css, font) -->
<%@include file="../import/reference.jsp" %>
</head>
<style>
	.trueMsg{
		color : green;
		display : none;
	}
	/* 중복아이디 존재하는 경우 */
	.falseMsg{
		color : red;
		display : none;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script>
	$(document).ready(function(){
		var pass;
		
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
						pass = 'ok';
						$('.trueMsg').css("display","block");
						$('.falseMsg').css("display","none");
					} else {
						pass = 'no';
						$('.falseMsg').css("display","block");
						$('.trueMsg').css("display","none");
					}
				}
			}); // ajax 종료
		});
		
		$("#btn").click(function(){
			console.log($('#m').val());
			
			if( $('#userId').val()== "" || pass == 'no' ){
				alert('Id를 확인해주세요');
				return;
			}
			
			else{
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
	<a href="${pageContext.request.contextPath}/user/addUser">학생/교수</a>
	<a href="${pageContext.request.contextPath}/user/addAdmin">운영자(직원)</a>
	<div>
		<form action="${pageContext.request.contextPath}/user/addUser" method="post" id="form">
			<table border="1">
				
				<tr>
					<td>Id</td>
					<td><input type="text" name="userId" id="userId">
						<span class="trueMsg">사용 가능한 아이디입니다.</span>
						<span class="falseMsg">사용 중인 아이디입니다.</span>
					</td>
				</tr>
				
				<tr>
					<td>Pw</td>
					<td><input type="password" name="userPw"></td>
				</tr>
				<tr>
					<td>사용자유형</td>
					<td>
						<select name="userLevel">
							<option value="3">학생</option>
							<option value="2">교수</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>학과</td>
					<td>
						<select name="majorNo">
							<option value="1">컴퓨터</option>
							<option value="2">국어국문</option>
							<option value="3">경영학</option>
						</select>
						<!-- 학과리스트 받아오는거 추가해야함 -->
					</td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="userName"></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="text" name="userEmail"></td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td><input type="text" name="userTel"></td>
				</tr>
				<tr>
					<td>성별</td>
					<td>
						남<input type="radio" name="userGender" id="m" value="M" checked>
						여<input type="radio" name="userGender" id="f" value="F">
					</td>
				</tr>
			</table>
			
			<button type="button" id="btn">회원가입</button>
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