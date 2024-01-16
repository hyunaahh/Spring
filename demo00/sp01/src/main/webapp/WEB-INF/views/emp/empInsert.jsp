<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 정보 등록</title>
</head>

<body>
	<!-- form태그가 통신일으키려면 필요함 (action 경로, method 요청방식 -->
	<!-- "name" 속성값을 기반으로 값이생성되니까 주의! 연결된 controller의 매개변수에 따라!   -->
	<form action="empInsert" method="post">
		<div>
			<label>
				employee_id : 
				<input type="number" name="employeeId">
			</label>
			<br>
			<label>
				last_name : 
				<input type="text" name="lastName" >
			</label>
			<br>
			<label>
				email : 
				<input type="text" name="email" >
			</label>
			<br>
			<label>
				hire_date : 
				<input type="date" name="hireDate" >
			</label>
			<br>
			<label>
				job_id : 
				<input type="text" name="jobId" >
			</label>
			<br>
			<label>
				salary : 
				<input type="number" name="salary" >
			</label>
		</div>
		
		<div>
			<button type="button" onclick="location.href='empList'"> 목록으로 </button>
			<button type="submit"> 등록 </button>
		</div>
	</form>
</body>
</html>