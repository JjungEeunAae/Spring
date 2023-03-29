<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 등록</title>
</head>
<body>
	<h3>도서 등록</h3>
	<form action="bookInsert" method="post" name="insertForm" onsubmit="return false">
        <div>
            <label>도서번호 : <input type="number" name="bookNo" value="${bookInfo.bookNo}" readonly></label>
        </div>
        <div>
            <label>도서명 : <input type="text" name="bookName"></label>
        </div>
        <div>
            <label>도서표지 : <input type="text" name="converimg"></label>
        </div>
        <div>
            <label>출판일자 : <input type="date" name="bookDate"></label>
        </div>
        <div>
            <label>출판사 : <input type="text" name="bookPublsher"></label>
        </div>
        <div>
            <label>도서소개 : <br/><textarea cols="40" rows="10" name="bookInfo"></textarea></label>
        </div>
        <br/>
        <button type="submit">등록</button>
        <button type="button" onclick="location.href='bookAllList'">조회</button>
    </form>
    
    <script>
	    function formOptionChk(){
	    	let bookName = document.getElementsByName('bookName')[0];
	    	
	    	if(bookName.value == ""){
                alert("도서명이 입력되지 않았습니다");
                bookName.focus();
                return;
            }
	    	
	    	alert("도서등록이 완료되었습니다");
	    	
	    	insertForm.submit();
	    }
	    
	    document.querySelector('button[type="submit"]')
        .addEventListener('click', formOptionChk);
    </script>
</body>
</html>