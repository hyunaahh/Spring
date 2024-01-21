<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="container">
	<h1>게시글 등록</h1>
	<form name="insertForm" action="boardInsert" method="post">
		<table>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title"></td>
			</tr>
			
			
			<tr>
				<th>작성자</th>
				<td><input type="text" name="writer"></td>
			</tr>
			
			<tr>
				<th>내용</th>
				<td><textarea name="contents"></textarea></td>
			</tr>
			
			<tr>
				<th>이미지</th> <!-- app.jpg -->
				<td><input type="text" name="image"></td>
			</tr>
			
		</table>
		
		<button type="submit"> 등록 </button>
	</form>
</div>



<script>

//** default_layout에 제이쿼리cdn 추가하고왔음! 

//not null 제약조건 있는거 => 화면에서 처리
//1. JavaScript .ver
 
	document.querySelector('form[name="insertForm"]')
	        .addEventListener('submit', boardInsertJs); //type 속성ㅇ이 submit이니ㅣ까
	
	function boardInsertJs(event){
	    event.preventDefault(); //일단 submit 원래 기능 일시적으로 stop 시키고! 
	
	    let title = document.getElementsByName('title')[0]; //id 속성 제외하곤 다 배열로넘어오기떄문에 index로 하나로 좁히기! 
	    let writer = document.getElementsByName('writer')[0];
	
	    //value는 null을 반환하지 않음! ''공백 기준으로 비교해야함.
	    if(title.value == ''){
	        alert('제목입력안했음');
	        title.focus();
	        return; //함수종료! (**vs break : 반복문종료)
	    }
	
	    if(writer.value == ''){
	        alert('작성자입력안함');
	        writer.focus();
	        return;
	    }
	
	    //※ form태그의 name 속성값은 하나의 "변수"로 인식 함! 
	    insertForm.submit();
	}
	
	
	document.querySelector('form[name="insertForm"]')
    .removeEventListener('submit', boardInsertJs);
	
//2. jQuery .ver
$('form[name="insertForm"]').on('submit', boardInsertJq);

function boardInsertJq (event){
	event.preventDefault();
	
	let title = $('[name="title"]');
	let writer = $('[name="writer"]');

	if(title.val() == ''){
		alert('제목입력해 제이쿼리');
		title.focus();
		return;
	}
	
	if(writer.val() == ''){
		alert('작성자입력해 제이쿼리');
		writer.focus();
		return;
	}
	  insertForm.submit();
	  
	 

	  
}


</script>