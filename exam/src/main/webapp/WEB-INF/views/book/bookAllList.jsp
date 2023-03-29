<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>도서 조회 / 수정</h3>
<table>
	<thead>
		<tr>
			<th>도서번호</th>
			<th>도서명</th>
			<th>표지</th>
			<th>출판일자</th>
			<th>금액</th>
			<th>출판사</th>
			<th>도서소개</th>
		</tr>
	</thead>
	<tbody>
<!--onclick="location.href='getBoardInfo?bno=${list.bookNo}'"-->
		<c:forEach items="${bookAllList}" var="list">
			<tr>
				<td>${list.bookNo}</td>
				<td>${list.bookName}</td>
				<td><img src="<c:url value="/resources/images/${list.bookCoverimg}"/>" style="width: 30px;"></td>
				<td><fmt:formatDate value="${list.bookDate}" pattern="yyyy/MM/dd"/></td>
				<td><fmt:formatNumber value="${list.bookPrice}" pattern="#,###"/></td>
				<td>${list.bookPublsher}</td>
				<td>${list.bookInfo}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

</body>
</html>