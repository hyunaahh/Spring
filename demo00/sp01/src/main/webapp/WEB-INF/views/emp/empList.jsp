<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 전체 사원 조회 </title>
</head>

<body>
	<button>버튼</button>
	<table>
		<thead>
			<tr onclick="">
				<th>No.</th>
				<th>employee_id</th>
				<th>last_name</th>
				<th>email</th>
				<th>hire_date</th>
				<th>job_id</th>
				<th>salary</th>
			</tr>
		</thead>
	
		<tbody>
			<c:forEach items="${empList}" var="info" varStatus="sts">
				<tr onclick="location.href='empInfo?employeeId=${info.employeeId}'"> 
					<td> ${sts.count } </td> <!-- 넘버링할때! index/count -->
					<td>${info.employeeId}</td>
					<td>${info.lastName}</td>
					<td>${info.email}</td>
					<td><fmt:formatDate value="${info.hireDate}" pattern="yyyy년 MM월 dd일" /></td>
					<td>${info.jobId}</td>
					<td>${info.salary}</td>
				</tr>
			</c:forEach>
		</tbody>
		</table>
</body>

</html>