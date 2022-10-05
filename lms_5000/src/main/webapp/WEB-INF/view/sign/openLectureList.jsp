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
<!-- 페이지 삽입 - nav bar -->


    <!-- Content Header (Page header) -->
    <!-- 메인페이지 헤더(제목 등) -->
    <div class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1 class="m-0 text-dark">수강신청 페이지</h1>
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="${pagaContext.request.contextPath}/lms/sign/stDash">수강목록</a></li>
              <li class="breadcrumb-item active">수강신청</li>
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
	<div class="card">
		 <div class="card-header">
           <h1 class="card-title"><Strong>개설 강좌 목록</Strong></h1><br>
           <h3>신청 가능 학점 : 21점 / <b>현수강 학점 : ${signTime}</b> </h3>
         </div>
         <div class="card-body table-responsice p-0">
           <table class="table table-hover text-nowrap">
			<thead>
				<tr>
					<th>강좌번호</th>
					<th>과목이름</th>
					<th>과목학점</th>
					<th>학기</th>
					<th>신청 가능 학년</th>
					<th>신청 가능 학과</th>
				</tr> 
			</thead>
			<tbody>
				<c:forEach var="m" items="${lectureList}">
					<tr>
						<td>${m.lecture_no}</td>
						<td>${m.subject_name}</td>
						<td>${m.subject_point}점</td>
						<td>${m.semester_no}학기</td>
						<td>${m.subject_grade}학년</td>
						<td>${m.major_name}</td>
						<td>
							<c:if test="${signTime < 21}">
						   		<a href="${pageContext.request.contextPath}/sign/addSign?lectureNo=${m.lecture_no}&userId=${loginUser.userId}">수강신청</a>
						   </c:if>
						   <c:if test="${signTime >= 21}">
						   		<p style="color:red">초과 등록 불가</p>
						   </c:if>
						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
          </div>
          </div><!-- /.card -->
          <div class="card-footer">
					  <nav aria-label="Contacts Page Navigation">
			            <ul class="pagination justify-content-center m-0">
			            	<li class="page-item "><a class="page-link" href="${pageContext.request.contextPath}/sign/openLectureList?&currentPage=1">첫페이지</a></li>
			            	<li class="page-item "><a class="page-link" href="${pageContext.request.contextPath}/sign/openLectureList?currentPage=${currentPage - 1}">이전쪽</a></li>
								<c:forEach items="${pages}" var="p">
									<c:if test="${p eq currentPage}">

						              <li class="page-item active"><a class="page-link" href="${pageContext.request.contextPath}/sign/openLectureList?currentPage=${p}">${p}</a></li>
						            </c:if>
						            <c:if test="${p ne currentPage}">
						              <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/sign/openLectureList?currentPage=${p}">${p}</a></li>
						            </c:if>
								</c:forEach>
							<li class="page-item "><a class="page-link" href="${pageContext.request.contextPath}/sign/openLectureList?currentPage=${currentPage + 1}">다음쪽</a></li>
							<li class="page-item "><a class="page-link" href="${pageContext.request.contextPath}/sign/openLectureList?currentPage=${realLastPage}">마지막페이지</a></li>
			            </ul> 
			          </nav>
	              </div>
	              <!-- /.card-footer-->
	            </div>
	    
	</div>
	<br>
	<div class="card">
	   <div class="card-header">
	        <h1 class="card-title"><Strong>수강신청 과목</Strong></h1><br>
	   </div>   
           <div class="card-body table-responsice p-0">
             <table class="table table-hover text-nowrap">
			<thead>
			<tr>
				<th>강좌번호</th>
				<th>과목이름</th>
				<th>과목학점</th>
				<th>신청 가능 학년</th>
				<th>수업진행요일</th>
				<th>강의실</th>
				<th>수강 신청 상태</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="s" items="${singList}">
			<c:if test="${s.sign_state ne 2}">
				<tr>
					<td>${s.lecture_no}</td>
					<td>${s.subject_name}</td>
					<td>${s.subject_point}점</td>
					<td>${s.subject_grade}학년</td>
					<td>
						<c:choose>
							<c:when test="${s.lecture_day eq 1}">월요일</c:when>
							<c:when test="${s.lecture_day eq 2}">화요일</c:when>
							<c:when test="${s.lecture_day eq 3}">수요일</c:when>
							<c:when test="${s.lecture_day eq 4}">목요일</c:when>
							<c:when test="${s.lecture_day eq 5}">금요일</c:when>
							<c:when test="${s.lecture_day eq 6}">토요일</c:when>
							<c:when test="${s.lecture_day eq 7}">일요일</c:when>
							<c:otherwise>요일을 다시 확인해 주세요</c:otherwise>
						</c:choose>
					</td>
					<td>${s.classroom_no}호 강의실</td>
					<td>
						<!-- session 등으로 수강신청 상태 대기 -->
						<c:choose>
							<c:when test="${s.sign_state eq 0}">신청 대기</c:when>
							<c:when test="${s.sign_state eq 1}">수강 신청 완료</c:when>
						</c:choose>
					</td>
					<td><a href="${pageContext.request.contextPath}/sign/cancelSign?userId=${loginUser.userId}&signNo=${s.sign_no}&lectureNo=${s.lecture_no}&cancelId=${loginUser.userId}">수강취소</a></td>
				</tr>
				</c:if>
			</c:forEach>
		</tbody>
		</table>
     </div>
     </div><!-- /.card -->
	 <br>
		<div class="card">
		  <div class="card-header">   
           	<h1 class="card-title"><Strong>수강 취소 내역</Strong></h1><br>
          </div>	
          <div class="card-body table-responsice p-0">
           <table class="table table-hover text-nowrap">
				<thead>
					<tr>
						<th>강좌번호</th>
						<th>취소 과목 이름</th>
						<th>학생 ID</th>
						<th>취소 주체</th>
						<th>취소 사유</th>
						<th>취소 시간</th>
					</tr>
				</thead>
				<tbody>
						<c:forEach var="c" items="${cancelSignList}">
					<tr>
						<td>${c.lecture_no}</td>
					<td>${c.subject_name}</td>
					<td>${c.user_id}</td>
					<td>	
						${c.cancel_id}
					<c:choose >
					<c:when test="${c.user_id eq c.cancel_id }">(학생)</c:when>
					<c:when test="${c.user_id ne c.cancel_id}">(운영자)</c:when>
					</c:choose>
					</td>
					<td>	
					<c:choose >
					<c:when test="${c.user_id eq c.cancel_id }">학생 개인 사유</c:when>
					<c:when test="${c.user_id ne c.cancel_id}">수강 기준 부합</c:when>
					</c:choose>
					</td>	
					<td>${c.cancel_date}</td>
					</tr>
					</c:forEach>
				</tbody>		
			</table>
		    </div><!-- /.card -->
	</div>
    <!-- /.row -->   
    <!-- /.content -->
<!-- 페이지 삽입 - footer -->
<%@include file="../import/footer.jsp" %>
<!-- ./wrapper -->

<!-- 페이지 삽입 - 필수적인 script -->
<%@include file="../import/script.jsp" %>

</body>
</html>