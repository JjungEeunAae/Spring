<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글수정</title>
</head>
<body>
	<h1>게시글수정</h1>
    <form action="boardUpdate" method="post" onsubmit="return false" name="updateBoard">
        <div>
            <label>번호 : <input type="number" name="bno" value="${boardInfo.bno}" readonly></label>
        </div>
        <div>
            <label>제목 : <input type="text" name="title" value="${boardInfo.title}" ></label>
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
            <label>첨부파일 : <input type="file" name="image" value="${boardInfo.image}" ></label>
        </div>
        <div>
            <label>수정날짜 : <input type="date" name="updatedate" value="<fmt:formatDate value='${boardInfo.regdate}' pattern='yyyy-MM-dd' />"></label>
        </div>
        <button type="submit">수정하기</button>
        <button type="button" onclick="history.back()">뒤로가기</button>
    </form>

    <script>
        function formInsertChk(){
            let title = document.getElementsByName('title')[0];
            let contents = document.getElementsByName('contents')[0];

            //입력되지 않을 경우 돌아가는 조건문들
            if(title.value == "" || contents.value == ""){
                alert("필수사항이 입력되지 않았습니다");
                return;
            }

            //조건문에 걸리지 않고 순차적으로 실행되면 아래가 작동
            updateBoard.submit();
        }

        document.querySelector('button[type="submit"]')
                .addEventListener('click', formInsertChk);
    </script>
</body>
</html>