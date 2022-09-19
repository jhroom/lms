<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
<body>
	<div>
		<form action="${pageContext.request.contextPath}/user/addStudent" method="post" id="form">
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
						학생<input type="hidden" name="userLevel" value="3" placeholder="학생">
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
</body>

</html>