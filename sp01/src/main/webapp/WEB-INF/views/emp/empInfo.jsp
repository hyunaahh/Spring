<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 사원 정보 조회 및 수정 </title>
</head>

<body>
	<form>
		<div>
			<label>
				employee_id : 
				<input type="number" name="employeeId" value="${empInfo.employeeId }">
			</label>
			<br>
			<label>
				last_name : 
				<input type="text" name="lastName" value="${empInfo.lastName }">
			</label>
			<br>
			<label>
				email : 
				<input type="text" name="email" value="${empInfo.email }">
			</label>
			<br>
			<label>
				hire_date : 
				<input type="date" name="hireDate" value= '<fmt:formatDate value="${empInfo.hireDate }" pattern="yyyy-MM-dd"/>'>
			</label>
			<br>
			<label>
				job_id : 
				<input type="text" name="jobId" value="${empInfo.jobId }">
			</label>
			<br>
			<label>
				salary : 
				<input type="number" name="salary" value="${empInfo.salary }">
			</label>
		</div>
		
		<div>
			<button type="button" onclick="location.href='empList'"> 목록으로 </button>
			<button type="button" id="updateBtn"> 수정 </button>
			<button type="button" onclick="location.href='empDelete?eid=${empInfo.employeeId}'"> 삭제 </button>
		</div>
	</form>
	
	<script>
		document.querySelector('#updateBtn')
				.addEventListener('click', updateEmpInfo);
		
		function updateEmpInfo(event){
			// form 태그 내부의 입력태그를 기반으로 정보를 가져옴
				let empInfo = getEmpInfo();
			
		//1번. 해당 정보를 기반으로 Ajax 요청
		//QueryString(key=value&key=vlaue)
			fetch('empUpdate', {
				method : 'post',
				body: new URLSearchParams(empInfo) // key : value(객체)로 전환해주는 클래스.
			})
			.then(response => response.json())
			.then(result => {
				console.log('QueryString', result);
			})
			.catch(err => console.log(err));
			
			
			
			
		//2번. JSON : {"key" : "value", "key" : "value"}
			fetch('empUpdateAjax', {
				method : 'post',
				headers : {
					'content-type' : 'application/json'
				},
				body : JSON.stringify(empInfo)
			})
			.then(response => response.json())
			.then(result => {
				console.log('JSON', result);
			})
			.catch(err => console.log(err));
		} // end updateEmpInfo
		
		
		
		
		
		function getEmpInfo(){
			
			let inputList = document.querySelectorAll('form input'); //form태그의 모든 하위 input
			
			let objData = {}
			inputList.forEach(tag => {
				objData[tag.name] = tag.value; //name 쓴거 : 필드값이랑 다 같게 해놨었음.
			});
			
			return objData;
		}
	</script>
</body>
</html>