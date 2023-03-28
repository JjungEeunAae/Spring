<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체조회</title>
<!--제이쿼리-->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
</head>
<body>
	<h1>게시판</h1>
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${boardList}" var="list">
				<tr onclick="location.href='getBoardInfo?bno=${list.bno}'">
					<td>${list.bno}</td>
					<td>${list.title}</td>
					<td>${list.contents}</td>
					<td><fmt:formatDate value="${list.regdate}" pattern="yyyy년MM월dd일"></fmt:formatDate></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>