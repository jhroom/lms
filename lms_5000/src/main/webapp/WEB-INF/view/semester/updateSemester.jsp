<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학기 수정하기</title>
</head>
<body>
	<div>
		<h3>학기 수정</h3>
		<form action="${pageContext.request.contextPath}/lmsSemester/updateSemester" method="post">
			<table border="1" bordercolor="green">
				<tbody>
					<tr>
						<input type="hidden" name="semesterNo" value="${semesterOne.semesterNo}">
					</tr>
					<tr>
						<th>번호</th>
						<td>${semesterOne.semesterNo}번</td>
					</tr>
					<tr>
						<th>년도</th>
						<td>
							<select name="semesterYear" onchange="semesterYear(this)">
								<option value="2022">2022년</option>
								<option value="2023">2023년</option>
								<option value="2024">2024년</option>
								<option value="2025">2025년</option>
							</select>
						</td>
					</tr>
					<tr>
						<th>학기</th>
						<td>
							<select name="semesterSession" onchange="semesterSession(this)">
								<option value="1">1학기</option>
								<option value="2">2학기</option>
							</select>
						</td>
					</tr>
					<tr>
						<th>개강일</th>
						<td>
							<input type="datetime-local" name="semesterStartdate" value="semesterStartdate">
						</td>
					</tr>
					<tr>
						<th>종강일</th>
						<td>
							<input type="datetime-local" name="semesterEnddate" value="semesterEnddate">
						</td>
					</tr>
				</tbody>
			</table>
			<button type="submit">수정</button>
		</form>
	</div>


</body>
</html>