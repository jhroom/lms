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
    <h1>LMS 공지사항 추가</h1>
    <form id="noticeAdd" action="${pageContext.request.contextPath}/lmsNoticeAddBoard" method="post">
        <div class="form-group">
            <label for="lmsNoticeTitle">제목</label>
            <input class="form-control" name="lmsNoticeTitle" id="lmsNoticeTitle" type="text"/>
        </div>
        <div class="form-group">
            <label for="lmsNoticeContent">내용</label>
            <textarea class="form-control" name="lmsNoticeContent" id="boardContent" rows="5" cols="50"></textarea>
        </div>
       	<div>
       	
       	
       	</div>
        <div>
            <input class="btn btn-default" id="addButton" type="button" value="글입력"/>
            <input class="btn btn-default" type="reset" value="초기화"/>
            <a class="btn btn-default" href="${pageContext.request.contextPath}/lmsNoticeList">글목록</a>
        </div>
    </form>
</div>

</body>
</html>