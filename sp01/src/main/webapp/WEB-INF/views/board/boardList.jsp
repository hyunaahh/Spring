<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
   
 <div class="container">
 <h1>자유게시판</h1>
 	<table>
		<thead>
			<tr>
				<th>게시글번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th> <!-- yyyy년 MM월 dd일 -->
			
			</tr>
		</thead>
		
		<tbody>
		<c:forEach items="${boardList }" var="info"  >	
			<tr>
				<td>${info.bno }</td>
				<td>${info.title}</td>
				<td>${info.writer}</td>
				<td><fmt:formatDate value="${info.regdate}" pattern="yyyy년 MM월 dd일 " /></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div> 
 
 
 

