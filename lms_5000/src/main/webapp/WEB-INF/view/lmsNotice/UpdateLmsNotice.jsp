<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지 수정</title>
</head>
<body>
	<div>
		<h3>공지 수정</h3>
		
		<table border="1" bordercolor="green">
			<tbody>
				<tr>
					<th>제목</th>
					<td>
						<input type="text" name="lmsNoticeTitle" value="${updateNotice.lmsNoticeTitle}">
					</td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>
						<input type="text" name="lmsNoticeName" value="${updateNotice.lmsNoticeName}" readonly="readonly">
					</td>
				</tr>
				<tr>
					<th>내용</th>
					<td>
						<input type="text" name="lmsNoticeContent" value="${updateNotice.lmsNoticeContent}">
					</td>			
				</tr>
				<tr>
					<th>작성일</th>
					<td>
						<input type="text" name="lmsNoticeCreatetime" value="${updateNotice.lmsNoticeCreatetime}" readonly="readonly" >
					</td>
				</tr>
				<tr>
					<th>수정일</th>
					<td>
						<input type="text" name="lmsNoticeUpdatetime" value="${updateNotice.lmsNoticeUpdatetime}"  readonly="readonly">
					</td>
				</tr>
				<tr>
					<th>조회수</th>
					<th>${updateNotice.count }</th>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td></td>
				</tr>
					
			</tbody>
			
		</table>
		
		
		<form method="get" name="form">
			<button type="submit" onclick="javascript:form.action='${pageContext.request.contextPath}/lmsNotice/LmsNoticeListd'">수정(ㄱㄷ)</button>
			<button type="submit" onclick="javascript:form.action='${pageContext.request.contextPath}/lmsNotice/LmsNoticeList'">리스트</button>
			
		</form>
		<a href="javascript:history.back();">수정취소</a>
		<a href="${pageContext.request.contextPath}/lmsNotice/updateLmsNotice/action?lmsNoticeNo=${lmsNoticeNo}&lmsNotice/lmsNoticeTitle=${lmsNoticeTitle}">수정</a>
		
	</div>
</body>
</html>