<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글등록</title>
</head>
<body>
    <h1>게시글등록페이지</h1>
    <form action="boardInsert" method="post" name="insertForm" onsubmit="return false">
        <div>
            <label>번호 : <input type="number" name="bno" value="${boardInfo.bno}" readonly></label>
        </div>
        <div>
            <label>제목 : <input type="text" name="title"></label>
        </div>
        <div>
            <label>작성자 : <input type="text" name="writer"></label>
        </div>
        <div>
            <label>내용 : <br/><textarea cols="40" rows="10" name="contents"></textarea></label>
        </div>
        <div>
            <label>첨부이미지 : <input type="text" name="image"></label>
        </div>
        <br/>
        <button type="submit">등록</button>
        <button type="button" onclick="location.href='getBoardList'">목록</button>
    </form>

    <script>
        function formOptionChk(){
            let title = document.getElementsByName('title')[0];
            let writer = document.getElementsByName('writer')[0];
            let contents = document.getElementsByName('contents')[0];

            //입력되지 않을 경우 돌아가는 조건문들
            if(title.value == ""){
                alert("제목이 입력되지 않았습니다");
                title.focus();
                return;
            }
            if(writer.value == ""){
                alert("작성자가 입력되지 않았습니다");
                writer.focus();
                return;
            }
            if(contents.value == ""){
                alert("내용이 입력되지 않았습니다");
                contents.focus();
                return;
            }

            //조건문에 걸리지 않고 순차적으로 실행되면 아래가 작동
            insertForm.submit();
        }

        document.querySelector('button[type="submit"]')
                .addEventListener('click', formOptionChk);
    </script>
</body>
</html>