<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	  href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	  crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<title>등록</title>
</head>
<!--ContextPath
        1) C태그
            <씨:유알엘 />
        2) el
            ${pageContext.request.contextPath}/empInsert}-->
<body>
	<h1>사원등록</h1>
    <form action="empInsert" method="post">
        <div>
            <label>frist_name : <input type="text" name="firstName"></label>
        </div>
        <div>
            <label>last_name : <input type="text" name="lastName"></label>
        </div>
        <div>
            <label>email : <input type="email" name="email"></label>
        </div>
        <div>
            <label>job_id : <input type="text" name="jobId"></label>
        </div>
        <div>
            <label>salary : <input type="number" name="salary"></label>
        </div>
        <button type="submit" class="btn btn-success">등록</button>
        <button type="button" class="btn btn-primary">목록</button>
    </form>
</body>
</html>