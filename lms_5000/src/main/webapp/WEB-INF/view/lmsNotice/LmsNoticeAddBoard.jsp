<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LMS 공지사항 작성</title>
</head>
<body>
<div class="container">
    <h1>LMS 공지사항 작성</h1>
    <form action="${pageContext.request.contextPath}/lmsNotice/LmsNoticeAddBoard//add" method="get" enctype="multipart/form-data">
		<input type="hidden" name="boardNo" id="boardNo" value="${lmsNoticeNo}">
		<table border="1" bordercolor="green">
			
			<tbody>
				<tr>
					<th>제목</th>
					<td><input type="text" name="lmsNoticeTitle" id="lmsNoticeTitle"></td>
				</tr>
				
				<tr>
				<!-- 작성자는 db에는 없기 때문에 혹시나 입력된대로 게시판에 들어가면 어떨까 생각해봤습니다. -->
				<!-- 그래서 만약 잘만 된다면 db에 작성자란을 만들고 거기에 직접 입력하는 식으로 만드는거죠. -->
					<th>작성자</th>
					<td><input type="text" name="lmsNoticeName" id="LmsNoticeName" value="작성자의 이름을 쓰시오" ></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea name="lmsNoticeContent" id="lmsNoticeContent"></textarea></td>
				</tr>		
				<tr>
					<th>파일</th>
					<td><input type="file" name="noticeFile" id="noticeFile"></td>
					
				</tr>		
			</tbody>
		</table>
		<button type="submit">작성하기</button>
		<button type="submit" onclick="javascript:form.action='${pageContext.request.contextPath}/lmsNotice/LmsNoticeList'">글목록</button>
		
	</form>
</div>

</body>
</html>