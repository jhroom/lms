<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학기 추가 폼</title>
</head>
<body>
	<h3>학기 추가 폼</h3>
	<div>
	
		<form action="${pageContext.request.contextPath}/lmsSemester/addSemester/add" method="post">

		<table border"1" bordercolor="green">
			<tbody>
			<tr>
				<th>년도</th>
				<td>
					<select name="semesterYear" id="semesterYear">
						<option value="default">년도를 선택하세요.</option>
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
					<select name="semesterSession" id="semesterSession">
						<option value="defualt">학기를 선택하세요</option>
						<option value="1">1학기</option>
						<option value="2">2학기</option>
						
					</select>
				</td>
			</tr>
			<tr>
				<th>개강일</th>
				<td>
					<input type="datetime-local" name="semesterStartdate" id="semesterStartdate">
				</td>				
			</tr>
			<tr>
				<th>종강일</th>
				<td>
					<input type="datetime-local" name="semesterEnddate" id="semesterEnddate">
				</td>
			</tr>
		</tbody>
		</table>
		<button type="submit">추가</button>
	</form>
	</div>

</body>
</html>