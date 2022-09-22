<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form>
	<table>
		<thead>
		</thead>
		<tbody>
		<tr>
			<td>
			<!-- 문제 반복문 시작 -->
				<c:forEach items="${questionList}" var="q">
					<table>
						<tr>
							<td>
							n 번 ${q.questionContent}
							</td>
						</tr>
						<!-- 보기 반복문 시작 -->
						<c:forEach items="${choiceList}" var="m">
							<c:if test="${m.questionNo eq q.questionNo}">
								<tr>
									<td>
									<input type="radio" name="${m.questionNo}" value="${m.choiceNo}">
									${m.choiceNo}번 : ${m.choiceContent}
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
</form>
</body>
</html>