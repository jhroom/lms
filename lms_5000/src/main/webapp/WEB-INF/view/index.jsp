<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page import="java.util.Calendar"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%
	request.setCharacterEncoding("utf-8");

	Calendar cal = Calendar.getInstance();
	
	// 시스템 오늘날짜
	int ty = cal.get(Calendar.YEAR);
	int tm = cal.get(Calendar.MONTH)+1;
	int td = cal.get(Calendar.DATE);
	
	int year = cal.get(Calendar.YEAR);
	int month = cal.get(Calendar.MONTH)+1;
	
	// 파라미터 받기
	String sy = request.getParameter("year");
	String sm = request.getParameter("month");
	
	if(sy!=null) { // 넘어온 파라미터가 있으면
		year = Integer.parseInt(sy);
	}
	if(sm!=null) {
		month = Integer.parseInt(sm);
	}
	
	cal.set(year, month-1, 1);
	year = cal.get(Calendar.YEAR);
	month = cal.get(Calendar.MONTH)+1;
	
	int week = cal.get(Calendar.DAY_OF_WEEK); // 1(일)~7(토)
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Insert title here</title>

<!-- start calendar script -->
<link rel="icon" href="data:;base64,iVBORw0KGgo=">
<style type="text/css">
*{
	margin: 0; padding: 0;
    box-sizing: border-box;
}

body {
	font-size: 14px;
	font-family: "맑은 고딕", 나눔고딕, 돋움, sans-serif;
}

a {
  color: #000;
  text-decoration: none;
  cursor: pointer;
}
a:active, a:hover {
	text-decoration: underline;
	color: #F28011;
}

.calendar {
	width: 280px;
	margin: 30px auto;
}
.calendar .title{
	height: 37px;
	line-height: 37px;
	text-align: center;
	font-weight: 600;
}

.calendar .selectField {
	border: 1px solid #999;
	padding: 2px 7px;
	border-radius: 3px;
	font-family: "맑은 고딕", 나눔고딕, 돋움, sans-serif;
	vertical-align: baseline;
}

.calendar table {
	width: 100%;
	border-collapse: collapse;
	border-spacing: 0;
}

.calendar table thead tr:first-child{
	background: #f6f6f6;
}

.calendar table td{
	padding: 10px;
	text-align: center;
	border: 1px solid #ccc;
}

.calendar table td:nth-child(7n+1){
	color: red;
}
.calendar table td:nth-child(7n){
	color: blue;
}
.calendar table td.gray {
	color: #ccc;
}
.calendar table td.today{
	font-weight:700;
	background: #E6FFFF;
}

.calendar .footer{
	height: 25px;
	line-height: 25px;
	text-align: right;
	font-size: 12px;
}
</style>

<script type="text/javascript">
function change() {
	var f = document.frm;
	f.action="${pageContext.request.contextPath}/calendar";
	f.submit();
}
</script>
<!-- end calendar script -->

<!-- 페이지 삽입 - 필수적인 레퍼런스(css, font) -->
<%@include file="../view/import/reference.jsp" %>
</head>
<body class="hold-transition sidebar-mini">

<!-- 전체 페이지 래퍼 -->
<div class="wrapper">


<!-- 페이지 삽입 - nav bar -->
<%@include file="../view/import/nav.jsp" %>

<!-- 페이지 삽입 - side bar -->
<%@include file="../view/import/sidebar.jsp" %>



  <!-- Content Wrapper. Contains page content -->
  <!-- 메인 컨텐츠 래퍼 -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <!-- 메인페이지 헤더(제목 등) -->
    <div class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1 class="m-0 text-dark">메인 페이지</h1>
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
		
	<!--  상단 구역 수강 게시판 섹션 -->
	    <section class="content">
	      <div class="container-fluid">
	        <div class="row">
	          <div class="col-12">
	            <!-- Default box -->
	            <div class="card">
	            
	              <div class="card-header">
	                <h3 class="card-title"><c:if test="${loginUser.userLevel eq 3}">수강중인 강좌 목록</c:if><c:if test="${loginUser.userLevel eq 2}">강의중인 과목 목록</c:if></h3>
	                
	                <div class="card-tools">
	                	<!-- 감추거나 지우는 버튼들 -->
	                  <button type="button" class="btn btn-tool" data-card-widget="collapse" data-toggle="tooltip" title="Collapse">
	                    <i class="fas fa-minus"></i>
	                   </button>
	                  <button type="button" class="btn btn-tool" data-card-widget="remove" data-toggle="tooltip" title="Remove">
	                    <i class="fas fa-times"></i>
	                    </button>
	                </div>
	              </div><!-- End header -->
	              
	              <div class="card-body">
	              <!-- 표 시작 -->
					<table border="1">
						<thead>
							<tr>
								<th>강좌이름</th>
								<th>대상학년</th>
								<th>수업요일</th>
								<th>강좌 개강일</th>
								<th>강좌 종료일</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="lc" items="${lectureList}">
							<tr>
								<td><a href="${pageContext.request.contextPath}/dashBoard/lectureDashBoard?userId=${loginUser.userId}&lectureNo=${lc.lectureNo}">${lc.subjectName}</a></td>
								<td>${lc.subjectGrade}</td>
								<td>${lc.lectureDay}</td>
								<%-- <td><a href="${pageContext.request.contextPath}
								/board/post/one?boardPostNo=${b.boardPostNo}&boardNo=${b.boardNo}&boardName=${b.boardName}">
								${b.boardPostName}</a></td> --%>
								<td>${lc.semesterStartDate}</td>
								<td>${lc.semesterEndDate}</td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
	              </div>
	              <!-- /.card-body -->
	              <div class="card-footer">
	                Footer 취향것
	              </div>
	              <!-- /.card-footer-->
	            </div>
	            <!-- /.card -->
	          </div>
	        </div>
	      </div>
	    </section>
	    <!-- /.end-->
	    
	<!--  하단 구역 수강 게시판 섹션 -->
	    <section class="content">
	      <div class="container-fluid">
	        <div class="row">
	<!-- 하단 구역 왼쪽 공지사랑 시작 -->
	          <div class="col-6">
	            <!-- Default box -->
	            <div class="card">
	              <div class="card-header">
	                <h3 class="card-title">LMS 공지사항 게시판</h3>
	                <div class="card-tools">
	                	<!-- 감추거나 지우는 버튼들 -->
	                	<a href="">더보기</a>
	                  <button type="button" class="btn btn-tool" data-card-widget="collapse" data-toggle="tooltip" title="Collapse">
	                    <i class="fas fa-minus"></i>
	                   </button>
	                  <button type="button" class="btn btn-tool" data-card-widget="remove" data-toggle="tooltip" title="Remove">
	                    <i class="fas fa-times"></i>
	                    </button>
	                </div>
	              </div><!-- End header -->
	              
	              <div class="card-body">
	              <!-- LMS공지사항 리스트 -->
					<table border="1" bordercolor="green">
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>내용</th>
							<th>작성자</th>
							<th>작성일</th>
							<th>조회수</th>
							
						</tr>
						<c:forEach var="a" items="${lmsNoticeList}" begin="1" end="5">
							<tr>
								<td>${a.lmsNoticeNo}</td>
								<td><a href="${pageContext.request.contextPath}/lmsNotice/LmsNoticeOne?lmsNoticeNo=${a.lmsNoticeNo}&lmsNoticeTitle=${a.lmsNoticeTitle}">${a.lmsNoticeTitle}</a></td>
								<td>${a.lmsNoticeContent}</td>
								<td>${a.lmsNoticeName}</td>
								<td>${a.lmsNoticeCreatetime}</td>
								<td>${a.count}</td>
							</tr>
						</c:forEach>
					</table>
	              </div><!-- /.card-body -->
	              
	              <div class="card-footer">
	                Footer 취향것
	              </div><!-- /.card-footer-->
	            </div><!-- /.card -->
	          </div><!-- End col.6 -->
	          
	<!-- 하단구역 오른쪽 달력 시작-->
	          <div class="col-6">
	            <!-- Default box -->
	            <div class="card">
	              <div class="card-header">
	                <h3 class="card-title">달력</h3>
	                <div class="card-tools">
	                	<!-- 감추거나 지우는 버튼들 -->
	                  <button type="button" class="btn btn-tool" data-card-widget="collapse" data-toggle="tooltip" title="Collapse">
	                    <i class="fas fa-minus"></i>
	                   </button>
	                  <button type="button" class="btn btn-tool" data-card-widget="remove" data-toggle="tooltip" title="Remove">
	                    <i class="fas fa-times"></i>
	                    </button>
	                </div>
	              </div><!-- End header -->
	              
	              <div class="card-body">
<div class="calendar">
	<div class="title">
		<form name="frm" method="post">
			<select name="year" class="selectField" onchange="change()">
				<% for(int i=year-5; i<=year+5; i++){ %>
					<option value="<%=i%>" <%=year==i?"selected='selected'":"" %>><%=i%>년</option>
				<%} %>
			</select>
			<select name="month" class="selectField" onchange="change()">
				<% for(int i=1; i<=12; i++){ %>
					<option value="<%=i%>" <%=month==i?"selected='selected'":"" %>><%=i%>월</option>
				<%} %>
			</select>
		</form>
	</div>
	
	<table>
		<thead>
			<tr>
				<td>일</td>
				<td>월</td>
				<td>화</td>
				<td>수</td>
				<td>목</td>
				<td>금</td>
				<td>토</td>
			</tr>
		</thead>
		<tbody>
<%
			// 1일 앞 달
			Calendar preCal = (Calendar)cal.clone();
			preCal.add(Calendar.DATE, -(week-1));
			int preDate = preCal.get(Calendar.DATE);
			
			out.print("<tr>");
			// 1일 앞 부분
			for(int i=1; i<week; i++) {
				//out.print("<td>&nbsp;</td>");
				out.print("<td class='gray'>"+(preDate++)+"</td>");
			}
			
			// 1일부터 말일까지 출력
			int lastDay = cal.getActualMaximum(Calendar.DATE);
			String cls;
			for(int i=1; i<=lastDay; i++) {
				cls = year==ty && month==tm && i==td ? "today":"";
				
				out.print("<td class='"+cls+"'>"+i+"</td>");
				if(lastDay != i && (++week)%7 == 1) {
					out.print("</tr><tr>");
				}
			}
			
			// 마지막 주 마지막 일자 다음 처리
			int n = 1;
			for(int i = (week-1)%7; i<6; i++) {
				// out.print("<td>&nbsp;</td>");
				out.print("<td class='gray'>"+(n++)+"</td>");
			}
			out.print("</tr>");
%>		
		</tbody>
	</table>
	
	<div class="footer">
		<a href="${pageContext.request.contextPath}/index">오늘날짜로</a>
	</div>
	
</div>
	              </div><!-- /.card-body -->
	              
	              <div class="card-footer">
	                Footer 취향것
	              </div><!-- /.card-footer-->
	            </div><!-- /.card -->
	          </div><!-- End col.6 -->
	        </div><!-- End row -->
	      </div>
	    </section>
	<!-- /.end 하단구역-->
	
    기존 링크들은 사이드바로?
		<c:choose>
			<c:when test="${loginUser != null}">
				<p>${loginUser.userName}님 환영합니다.</p>
				<c:if test="${loginUser.userLevel eq 4}">
						<!-- loginUser 레벨이 4일경우 승인 페이지로 갈수있는 링크 출력-->
				<a href="${pageContext.request.contextPath}/user/userList">승인 페이지</a>
				</c:if>
				<br>
				<a href="${pageContext.request.contextPath}/lmsNotice/LmsNoticeList">공지 리스트</a><br>
				<a href="${pageContext.request.contextPath}/sign/stDash">강좌대시보드</a><br>
				<a href="${pageContext.request.contextPath}/board/list?lectureNo=1">게시판</a><br>
				<a href="${pageContext.request.contextPath}/index/mypage">마이페이지</a><br>
				<a href="${pageContext.request.contextPath}/lmsMajor/MajorList">학과 리스트</a><br>
				<a href="${pageContext.request.contextPath}/lmsSubject/SubjectList">강좌리스트</a><br>
				<a href="${pageContext.request.contextPath}/lmsSemester/SemesterList">학기 리스트</a><br>
				<button  onclick="window.open('${pageContext.request.contextPath}/user/messageList'
				, '새창', 'width=300px, height=500px' , 'location=no' , 'toolbar=yes'); return false">메세지</button>
				
				<p><a href="${pageContext.request.contextPath}/index/logout">로그아웃</a></p>
			</c:when>
			
			<c:otherwise>
				<a href="${pageContext.request.contextPath}/index/login">로그인하러가기</a>
			</c:otherwise>
		</c:choose>
		
		
		</div>
     </div><!-- /.container-fluid -->
    </div>
    <!-- /.content -->
 <!-- 원래위치 -->
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
<%@include file="../view/import/footer.jsp" %>

 </div>
<!-- ./wrapper -->

<!-- 페이지 삽입 - 필수적인 script -->
<%@include file="../view/import/script.jsp" %>

</body>
</html>