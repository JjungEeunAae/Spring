<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<nav>
	<ul class="nav">
		<%-- <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/empList"></a>전체조회</li>
        	<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/empInsert"></a>등록</li> --%>
		<li class="nav-item">
			<a class="nav-link" href="${pageContext.request.contextPath}/getBoardList">게시판</a>
		</li>
		<li class="nav-item">
			<a class="nav-link" href="${pageContext.request.contextPath}/boardInsert">게시글등록</a>
		</li>
	</ul>
</nav>