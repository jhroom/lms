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
      <form  action="${pageContext.request.contextPath}/test/submit" method="post">
      <input type="hidden" name="testNo" value="${testNo}">
      <input type="hidden" name="lectureNo" value="${lectureNo}">
      
	<table>
		<thead>
		</thead>
		<tbody>
		<tr>
			<td>
			<!-- 문제 반복문 시작 -->
				<c:forEach items="${questionList}" var="q" varStatus="status">
					<table>
						<tr>
							<td>
							<br>
							<input type="hidden" name="questionNos" value="${q.questionNo}">
							${status.count}번 : ${q.questionContent}
							답 : ${q.questionAnswer}
							<a href="${pageContext.request.contextPath}/test/modify/form2?questionNo=${q.questionNo}&testNo=${testNo}&lectureNo=${lectureNo}">수정</a>
							</td>
						</tr>
						<!-- 보기 반복문 시작 -->
						<c:forEach items="${choiceList}" var="m">
							<c:if test="${m.questionNo eq q.questionNo}">
								<tr>
									<td>
									<b>${m.choiceNo}번 : </b>  ${m.choiceContent}
									</td>
								</tr>
							</c:if>
						</c:forEach>
						<!-- 보기 반복문 시작 -->
					</table>
				</c:forEach>
				<!-- 문제 반복문 끝 -->
			</td>
		</tr>
		
		
		</tbody>
	</table>
	<button type="submit">답안 제출하기</button>
</form>
      



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

