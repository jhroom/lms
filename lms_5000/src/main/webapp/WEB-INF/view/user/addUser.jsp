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

  <!-- Font Awesome -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/fontawesome-free/css/all.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
  <!-- icheck bootstrap -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/icheck-bootstrap/icheck-bootstrap.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/dist/css/adminlte.min.css">
  <!-- Google Font: Source Sans Pro -->
  <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
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
			if( $('#userId').val()== "" || idPass == 'no' ){
				alert('Id를 확인해주세요');
				 $("#userId").focus();
				return false;
			}
			return true;
		}
		
		// 비밀번호 검증
		verifyPw = function() {
		  
		  var pwVal = $("#userPw").val();
		  
		  var regExp = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{4,}$/;
		  console.log(pwVal.match(regExp));
		  
		  if (pwVal.match(regExp) == null) {
			  console.log('비번 검증 실패');
			  alert('최소 4자 + 한개의 영문자, 한개의 숫자로 입력해주세요');
			  $("#userPw").focus();
			  return false;
		  }
		  console.log('비번 검증 성공');
		  return true;
		};
		
		// 이름 검증
		verifyName = function() {
		  
		  var nameVal = $("#userName").val();
	
		  if ( nameVal == "" ) {
			  alert('이름을 확인해주세요');
			  $("#userName").focus();
			  return false;
		  }
		  return true;
		};
		
		// 이메일 검증
		verifyEmail = function() {
		  
		  var emailVal = $("#userEmail").val();
		  
		  var regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	
		  if (emailVal.match(regExp) == null) {
			  console.log('이메일 검증 실패');
			  alert('이메일형식에 맞지 않습니다');
			  $("#userEmail").focus();
			  return false;
		  }
		  console.log('이메일 검증 성공');
		  return true;
		};
		
		// 핸드폰번호 검증
		verifyTel = function() {
		  
		  var telVal = $("#userTel").val();
		  // 검증에 사용할 정규식 변수 regExp에 저장
		  var regExp = /^\d{3}-\d{3,4}-\d{4}$/;
	
		  if (telVal.match(regExp) == null) {
			  alert('전화번호 형식에 맞지 않습니다\r\n000-0000-0000 형식으로 입력해주세요');
			  $("#userTel").focus();
			  return false;
		  }
		  return true;
		};
		
		//회원가입 버튼 클릭시 각 항목 검증 성공시 제출
		$("#btn").click(function(){
			
			if(!verifyId() || !verifyPw() || !verifyName() || !verifyEmail() || !verifyTel() ){
				console.log('false 테스트');
				return;
			} else{
				$('#form').submit();
			}
		});
		
	});
</script>
<body class="hold-transition login-page">
<div>
	<c:if test="${errMsg != null }">
		<p>${errMsg }</p>
	</c:if>
</div>

<div class="login-box">
  <div class="login-logo">
    <a href="${pageContext.request.contextPath}/index"><b>5000</b>LMS</a>
  </div>
  <!-- /.login-logo -->
  
  <div class="card">
  
  <div class=" row" >
  	<div class="col-sm-6 text-center" style="height: 35px;" >
  		<div style="padding-top: 10px">
  			<a  href="${pageContext.request.contextPath}/user/addUser">학생 / 교수</a>
  		</div>
  	</div>
  	<div class="col-sm-6 text-center" style="background-color:#e9ecef">
  		<div style="padding-top: 10px">
  			<a href="${pageContext.request.contextPath}/user/addAdmin">운영자(직원)</a>
  		</div>
  	</div>
  </div>
  
    <div class="card-body login-card-body">
      <p class="login-box-msg"></p>

      <form action="${pageContext.request.contextPath}/user/addUser" id="form" method="post">
      	
      	<div>
      	<!-- Id입력공간 -->
        <div class="input-group mb-3">
          <input type="text" name="userId" id="userId" class="form-control" placeholder="Id">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-id-badge"></span>
            </div>
          </div>
        </div>
       	<div class="trueMsg">사용 가능한 아이디입니다.</div>
		<div class="falseMsg">사용 불가능한 아이디입니다.</div>
        
        <!-- Pw입력공간 -->
        <div class="input-group mb-3">
          <input type="password" name="userPw" id="userPw" class="form-control" placeholder="Password">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-lock"></span>
            </div>
          </div>
        </div>
        
        <!-- 사용자 유형 -->
        <div class="input-group mb-3">
          	<select name="userLevel" class="form-control">
				<option value="3">학생</option>
				<option value="2">교수</option>
			</select>
            <div class="input-group-text">
              <span class="fas fa-user"></span>
            </div>
        </div>
        
        <!-- 학과 -->
        <div class="input-group mb-3">
          	<select name="majorNo" class="form-control">
          		<c:forEach var="list" items="${majorList}">
          				<option value="${list.majorNo}">${list.majorName}</option>
          		</c:forEach>
			</select>
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-graduation-cap"></span>
            </div>
          </div>
        </div>
         
        <!-- 이름입력공간 -->
        <div class="input-group mb-3">
          <input type="text" name="userName" id="userName" class="form-control" placeholder="이름">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-signature"></span>
            </div>
          </div>
        </div>
        
        <!-- 이메일 -->
        <div class="input-group mb-3">
          <input type="email" name="userEmail" id="userEmail" class="form-control" placeholder="Email">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-envelope"></span>
            </div>
          </div>
        </div>
        
        <!-- 전화번호 -->
        <div class="input-group mb-3">
          <input type="tel" name="userTel" id="userTel" class="form-control" placeholder="010-0000-0000">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-phone"></span>
            </div>
          </div>
        </div>
        
        <!-- 성별 -->
        <div class="input-group mb-3">
          	남<input type="radio" name="userGender" id="m" value="M" checked>
		  	여<input type="radio" name="userGender" id="f" value="F">
		  	 <!-- <div class="input-group-text">
              <span class="fas fa-neuter"></span>
            </div> -->
        </div>
        
        </div>
        
        <hr>
        
        <div class="row">
          <div class="col-8">
            <p class="mb-0">
        		<a href="${pageContext.request.contextPath}/index/login">이미 회원이신가요?</a>
      		</p>
          </div>
          <!-- /.col -->
          <div class="col-4">
            <button type="button" id="btn" class="btn btn-primary btn-block">회원가입</button>
          </div>
          <!-- /.col -->
        </div>
        
      </form>

      
    </div>
    <!-- /.login-card-body -->
  </div>
</div>
<!-- /.login-box -->

<!-- jQuery -->
<script src="${pageContext.request.contextPath}/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="${pageContext.request.contextPath}/dist/js/adminlte.min.js"></script>

</body>
</html>
