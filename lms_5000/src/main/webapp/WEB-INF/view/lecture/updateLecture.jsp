<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h3>강의 수정</h3>
	</div>
	<div>
		<form action="${pageContext.request.contextPath}/lmsLecture/updateLecture" method="post">
			<table border="1" bordercolor="green">
				<tbody>
					<tr>
						<input type="hidden" name="lectureNo" value="${lectureOne.lectureNo}">
					</tr>
					<tr>
						<th>강의번호</th>
						<td>${lectureOne.lectureNo}</td>
					</tr>
					<tr>
						<th>강의시간</th>
						<td>
						
						</td>
					</tr>
					<tr>
						<th>시작시간</th>
						<td>
						
						</td>
					</tr>
					<tr>
						<th>종료시간</th>
						<td>
						
						</td>
					</tr>
					<tr>
						<th>요일</th>
						<td>
						
						</td>
					</tr>
					<tr>
						<th>강좌번호</th>
						<td>
						
						</td>
					</tr>
					<tr>
						<th>강의실</th>
						<td>
						
						</td>
					</tr>
					<tr>
						<th>담당교수</th>
						<td>
						
						</td>
					</tr>
					<tr>
						<th>학기</th>
						<td>
						
						</td>
					</tr>
					
				</tbody>
			</table>
		</form>
	</div>

</body>
</html>