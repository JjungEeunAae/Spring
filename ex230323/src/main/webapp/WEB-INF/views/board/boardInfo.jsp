<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글조회</title>
</head>
<body>
    <h1>게시글조회</h1>
    <form>
        <div>
            <label>번호 : <input type="number" name="bno" value="${boardInfo.bno}" readonly></label>
        </div>
        <div>
            <label>제목 : <input type="text" name="title" value="${boardInfo.title}" readonly></label>
        </div>
        <div>
            <label>작성자 : <input type="text" name="writer" value="${boardInfo.writer}" readonly></label>
        </div>
        <div>
            <label>내용 : 
                <br/>
                <textarea cols="50" rows="10" name="contents">${boardInfo.contents}</textarea>
            </label>
        </div>
        <div>
            <label>첨부파일 : 
                <c:choose>
                    <c:when test="${not empty boardInfo.image}">
                        <img src="<c:url value="/resources/images/${boardInfo.image}"/>"
                        	 alt="사진"
                        	 style="width: 30px;"/>
                    </c:when>
                    <c:otherwise>
                        <span>이미지 없음</span>
                    </c:otherwise>
                </c:choose>
            </label>
        </div>
        <div>
            <label>작성일자 : <input type="text" name="regdate" value="<fmt:formatDate value='${boardInfo.regdate}' pattern='yyyy/MM/dd' />" readonly></label>
        </div>
        <button type="button" onclick="location.href='boardUpdate?bno=${boardInfo.bno}'">수정하기</button>
        <button type="button" onclick="location.href='boardDelete?bno=${boardInfo.bno}'">삭제하기</button>
    </form>
</body>
</html>