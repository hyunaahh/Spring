<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="container">
	<h1>게시글 수정</h1>
	<form name="updateForm">
		<table>
			<tr>
				<th>번호</th>
				<td><input type="text" name="bno" value="${boardInfo.bno }" readonly></td>
			</tr>
		
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" value="${boardInfo.title }"></td>
			</tr>
			
			
			<tr>
				<th>작성자</th>
				<td><input type="text" name="writer" value="${boardInfo.writer }"></td>
			</tr>
			
			<tr>
				<th>내용</th>
				<td><textarea name="contents">${boardInfo.contents }</textarea></td>
			</tr>
			
			<tr>
				<th>이미지</th> <!-- app.jpg -->
				<td><input type="text" name="image" value="${boardInfo.image }"></td>
			</tr>
			
		</table>
		
		<button type="button"> 저장 </button>
	</form>
</div>


<script>

//jQuery ver.
//얘는 submit에 event 안걸림. 단순 버튼이니까 click! (boardInsert랑 다름!)

$('form > button:contains(저장)').on('click', boardUpdateAjax); // 여기서부터 console 찍어보면서 확인! 

function boardUpdateAjax(event){

 //통신 진행여부 결정 - 수정대상[제목, 작성자 : not null 제약조건 o  CHECK]
 if(!validation()) return;
 
 //통신하기 위한 데이터 가져오기
 let boardDta = getBoardInfo();
 	console.log('boardDta', boardDta);

 //현재 controller 기준.
 $.ajax('boardUpdate', {
     type : 'post',
     
     //Controller에 따라서 달라짐 
     //1번 ver) 단순 커맨드객체 (@RequestBody X)
     //data : boardDta
     
     //2번 ver) @RequestBody 컨트롤러에 붙이면 쓰는 거! (JSON)
     contentType : 'application/json', 
     data : JSON.stringify(boardDta)
 })
 .then(result => {
 console.log(result);
 })
 .fail(err => console.log(err));
 
 
 }
 
 
function validation(){
	let title = $('[name="title"]');
	let writer = $('[name="writer"]');

		if(title.val() == ''){
			alert('제목입력해 제이쿼리');
			title.focus();
			return false; //boardupdtaeAjax 동작 종료되도록 
		}
		
		if(writer.val() == ''){
			alert('작성자입력해 제이쿼리');
			writer.focus();
			return false;
		}
	
	return true; 
}


function getBoardInfo(){
	
	//일단 얘는 외워라... 
	let formAry = $('form[name="updateForm"]').serializeArray(); //안에있는 값들 꺼내는 법 (textarea도 있으니까! ) - name : ~, value :~ => 객체속성 object로 넘겨줘야함 ! 
		console.log(formAry);
	
	let formObj = {};
	$(formAry).each((idx, tag)=>{
		console.log(tag);
		formObj[tag.name] = tag.value;
	})
	
	return formObj;
}



</script>