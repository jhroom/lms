<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
${testList}
<h3>강좌별 시험 리스트</h3>
<h3>${testList[0].lectureNo} 강좌 시험</h3>

<a href="${pageContext.request.contextPath}/test/addTest">시험 만들기</a>

<table border="1">
	<thead>
		<tr>
			<th>시험 번호</th><th>시험 이름</th><th>시험 시작 일자</th><th>시험 마감 일자</th><th>생성일</th><th>수정일</th><th>응시</th><th>수정</th><th>채점</th>
		</tr>
	</thead>
	
	<tbody>
		<c:forEach items="${testList}" var="t">
			<tr>
				<td>${t.testNo}</td><td><a href="${pageContext.request.contextPath}/test/page?testNo=${t.testNo}" >${t.testName}</a></td><td>${t.testStarttime}</td><td>${t.testEndtime}</td><td>${t.testCreatedate}</td><td>${t.testUpdatedate}</td>
			</tr>
		</c:forEach>
	</tbody>

</table>

</div>

</body>
</html>