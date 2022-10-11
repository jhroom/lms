<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="x-ua-compatible" content="ie=edge">

<title>LMS 5000</title>

<!-- 페이지 삽입 - 필수적인 레퍼런스(css, font) -->
<script src="https://kit.fontawesome.com/2048e8eb8a.js" crossorigin="anonymous"></script>
<%@include file="../import/reference.jsp" %>
<style>
	.container_g {
	display:grid;
	grid-template-columns : 5fr 1fr 1fr;
	grid-template-rows : 1fr 1fr 1fr;
	grid-gap:20px 20px
	}
	
	.item{
	text-align:center;
	background:lightblue;
	border-radius: 30px;
	}
	
	.item:nth-child(1) {
		grid-colume:1/2;
		grid-row:1/4;
		
	}
	
	.icon_g{
	font-size:4vw;
	text-align:center;
	}
	
	.p_g{
	font-size:1.6vw;
	
	}
	
	.board_g {
	clear:both;
	margin:10px;
	}
</style>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script>
	$(document).ready(function(){
		
		/* $("[id='btn1']").click(function(){
				$("[id='form1']").submit();
				return;
		});
		
		$("[id='btn2']").click(function(){
				$("[id='form2']").submit();
				return;
		}); */
		
		
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
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
            <li class="breadcrumb-item active">${lectureName}</li>
              <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/index">메인페이지</a></li>
              
            </ol>
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content-header -->

    <!-- Main content -->
    <!-- 메인 콘텐츠 -->
    <div class="col-sm-03"></div>

    <div class="content">
	    <div class="container-fluid">
	    
	    <div class="row">
	        <div class="col-sm-12">
				<c:choose>
	      		<c:when test="${loginUser.userLevel == 3 }">	
					<div class="card card-primary card-outline">
				         <div class="card-body">
				           <h1 class="card-title"><Strong>출결현황</Strong></h1><br>
				           <table class="table table-hover text-nowrap">
					          		<tr>
					          			<th>주차</th>
						          		<c:forEach var="stuAtt" items="${stuAtt}">
						          		<td>${stuAtt.week}</td>
						          		</c:forEach>
					          		</tr>			     
					        		<tr>
					        			<th>출석상태</th>
					        		<c:forEach var="stuAtt" items="${stuAtt}">
						           		<td>
						           		<c:if test="${stuAtt.attendState eq 0}">
						           			결석
						           		</c:if>
						           		<c:if test="${stuAtt.attendState eq 1}">
						           			지각
						           		</c:if>
						           		<c:if test="${stuAtt.attendState eq 2}">
						           			조퇴
						           		</c:if>
						           		<c:if test="${stuAtt.attendState eq 3}">
						           			출석
						           		</c:if>
						           		</td>
					           		 </c:forEach>
					           		</tr>
						   </table>
				           <a href="#" class="card-link">Card link</a>
				           <a href="#" class="card-link">Another link</a>
				        </div>
				    </div><!-- /.end 출결현황 card -->
			    </c:when>
			    <c:when test="${loginUser.userLevel <= 2 }">
			    	<div class="card card-primary card-outline">
				         <div class="card-body">
				           <h1 class="card-title"><Strong>출결현황</Strong></h1><br>
				           <table class="table">
				           		<tr>
				           			<td>주차</td>
				           			
				           			<c:forEach var="w" items="${weekList}" >
			           				<td style="padding: 15px;">
				           				<form action="${pageContext.request.contextPath}/dashBoard/lectureAttendance" method="post">
				           					<input type="hidden" name="lectureNo" value="${lectureNo}">
				           					<input type="hidden" name="week" value="${w.week}">
				           					<input type="hidden" name="access" value="${w.access}">
				           					
				           					<c:if test="${w.nowWeek == 'Y'}">
				           						<button type="submit" style="background-color:transparent; color:blue; border:0px transparent solid;">${w.week}</button>
				           					</c:if>
				           					<c:if test="${w.nowWeek == 'N'}">
				           						<button type="submit" style="background-color:transparent; color:green; border:0px transparent solid;">${w.week}</button>
				           					</c:if>
				           				</form>
			           				</td>
				           			</c:forEach>
				           			
				           		</tr>
						   </table>
				           <a href="#" class="card-link">Card link</a>
				           <a href="#" class="card-link">Another link</a>
				        </div>
				    </div><!-- /.end 출결현황 card -->
			    </c:when>
			    </c:choose>
			    
			    
			    </div>
			</div>
		        <!-- /.row -->
		        		        
			<!-- 게시판. 시함 등등의 그리드 -->
			<div class="col-sm-12">
					<div class="container_g">
						<!-- 게시판 -->
						<div class="item">
								<div class="card card-primary card-outline"  style="height:100%">
							         <div class="card-body">
							           <h1 class="card-title"><strong>최근 게시글</strong></h1><br>
							           <div class="board_g">
							           <table class="table table-hover text-nowrap">
							           	 <thead>
									          <tr>
									          	<th>게시판</th><th>제목</th><th>작성자</th><th>작성일자</th>
									          </tr>
							           	 </thead>
							           	 <tbody>
								           	 <c:forEach items="${recentList}" var="d" begin="0" end="9">
									           	 <tr>
									           	 	<td>
										           	 	<c:if test="${d.boardType eq 1}">(공지)</c:if>
										           	 	<c:if test="${d.boardType eq 2}">(QnA)</c:if>
										           	 	<c:if test="${d.boardType eq 3}">${d.boardName}</c:if>
										           	 	<c:if test="${d.boardType eq 4}">과제</c:if>
									           	 	</td>
									           	 	<td>
									           	 		<a href="${pageContext.request.contextPath}/board/post/one?boardPostNo=${d.boardPostNo}&boardNo=${d.boardNo}&boardName=${d.boardName}&lectureNo=${lectureNo}&boardType=${d.boardType}">${d.boardPostTitle}</a>
									           	 	</td>
									           	 	<td>${d.boardPostWriter}</td><td>${d.boardPostCreatedate}</td>
									           	 </tr>
								           	 </c:forEach>
							           	 </tbody>
									   </table>
							           </div>
							        </div>
							    </div><!-- /.card -->
						
						</div>
						<!-- 그리드 네개 -->
						<a href="${pageContext.request.contextPath}/board/post?boardType=1&lectureNo=${lectureNo}"><div class="item"><span class="icon_g"><i class="fa-sharp fa-solid fa-circle-exclamation"></i></span><p class="p_g">공지사항</p></div></a>
						<a href="${pageContext.request.contextPath}/board/post?boardType=2&lectureNo=${lectureNo}"><div class="item"><span class="icon_g"><i class="fa-sharp fa-solid fa-question"></i></span><p class="p_g">Qna</p></div></a>
						<a href="${pageContext.request.contextPath}/board/post?boardType=4&lectureNo=${lectureNo}"><div class="item"><span class="icon_g"><i class="fa-sharp fa-solid fa-paperclip"></i></span><p class="p_g">과제</p></div></a>
						<a href="${pageContext.request.contextPath}/test/board?lectureNo=${lectureNo}"><div class="item"><span class="icon_g"><i class="fa-sharp fa-solid fa-pencil"></i></span><p class="p_g">시험</p></div></a>
						<a href="${pageContext.request.contextPath}/board/list?lectureNo=${lectureNo}">	<div class="item"><span class="icon_g"><i class="fa-sharp fa-solid fa-clipboard-list"></i></span><p class="p_g">게시판</p></div></a>
						<c:if test="${loginUser.userLevel  eq 3}">
						<a href="${pageContext.request.contextPath}/grade/stu/form?lectureNo=${lectureNo}"><div class="item"><span class="icon_g"><i class="fa-sharp fa-solid fa-square-poll-vertical"></i></span><p class="p_g">성적</p></div></a>
						</c:if>
						<c:if test="${loginUser.userLevel  eq 2}">
						<a href="${pageContext.request.contextPath}/grade/pro/form?lectureNo=${lectureNo}"><div class="item"><span class="icon_g"><i class="fa-sharp fa-solid fa-square-poll-vertical"></i></span><p class="p_g">성적</p></div></a>
						</c:if>
						
				
						
				
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
<!-- ./wrapper -->
</div>
<!-- 페이지 삽입 - 필수적인 script -->
<%@include file="../import/script.jsp" %>

</body>
</html>