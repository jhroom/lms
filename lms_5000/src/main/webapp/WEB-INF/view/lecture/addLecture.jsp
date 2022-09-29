<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>강의 추가</title>
</head>
<body>
<div>
	<h3>강의추가</h3>
</div>
<div>
	<form action="${pageContext.request.contextPath}/lmsLecture/addLecture/add" method="get">
		<table border="1" bordercolor="green">
		<tbody>
			<tr>
				<th>강의시간</th>
				<td>
					<select name="lectureTime">
						<option value="default">시간을 선택하세요.</option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
					</select> 
				</td>
			</tr>
			<tr>
				<th>시작시간</th>
				<td>
					<input type="datetime-local" name="lectureStarttime">
				</td>
			</tr>
			<tr>
				<th>종료시간</th>
				<td>
					<input type="datetime-local" name="lectureEndtime">
				</td>
			</tr>
			<tr>
				<th>요일</th>
				<td>
					<select name="lectureDay">
						<option value="default">요일을 선택하세요.</option>
						<option value="1">월</option>
						<option value="2">화</option>
						<option value="3">수</option>
						<option value="4">목</option>
						<option value="5">금</option>
					</select>
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