<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세보기</title>
</head>
<body>
	<div>
		<h3>공지 상세보기</h3>
		<table border="1" bordercolor="green">
			<tbody>
				<tr>
					<th>제목</th>
					<td>${noticeOne.lmsNoticeTitle}</td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>${noticeOne.lmsNoticeName}</td>				
				</tr>
				<tr>
					<th>내용</th>
					<td>${noticeOne.lmsNoticeContent}</td>			
				</tr>
				<tr>
					<th>작성일</th>
					<th>${noticeOne.lmsNoticeCreatetime}</th>
				</tr>
				<tr>
					<th>수정일</th>
					<th>${noticeOne.lmsNoticeUpdatetime}</th>
				</tr>
				<tr>
					<th>조회수</th>
					<th>${noticeOne.count }</th>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td>
						<a href="${pageContext.request.contextPath}/lmsNotice/downloadFile?fileName=${noticeOne.fileName}&lmsNoticeNo=${noticeOne.lmsNoticeNo}">${noticeOne.fileOriginname}</a>
					</td>
				</tr>
					
			</tbody>
			
		</table>
		
		
		<form method="get" name="form">
			<button type="submit" onclick="javascript:form.action='${pageContext.request.contextPath}/lmsNotice/updateLmsNotice?lmsNoticeNo=${lmsNoticeNo}%lmsNotice/lmsNoticeTitle=${lmsNoticeTitle}'">수정안됨</button>
			<button type="submit" onclick="javascript:form.action='${pageContext.request.contextPath}/lmsNotice/deleteLmsNotice?lmsNoticeNo=${lmsNoticeNo}&lmsNotice/lmsNoticeTitle=${lmsNoticeTitle}'">삭제안됨</button>
			<button type="submit" onclick="javascript:form.action='${pageContext.request.contextPath}/lmsNotice/LmsNoticeList'">글목록됨</button>
		</form>
		<a href="${pageContext.request.contextPath}/lmsNotice/deleteLmsNotice?lmsNoticeNo=${lmsNoticeNo}&lmsNotice/lmsNoticeTitle=${lmsNoticeTitle}">삭제</a>
		<a href="${pageContext.request.contextPath}/lmsNotice/UpdateLmsNotice?lmsNoticeNo=${lmsNoticeNo}&lmsNotice/lmsNoticeTitle=${lmsNoticeTitle}">수정</a>
		
	</div>
</body>
</html>