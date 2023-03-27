<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script src="sweetalert2.min.js"></script>
<link rel="stylesheet" href="sweetalert2.min.css">
<link rel="stylesheet"
	  href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	  crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<title>전체조회</title>
<style>
    table, tr, th, td{
        border: 1px solid black;
    }
    button{
        cursor : pointer;
    }
</style>
</head>
<body>
	<h1>사원 리스트</h1>
    <button type="button" onclick="location.href='empInsert'" class="btn btn-primary">등록</button>
    <table class="table">
        <thead>
            <tr>
                <th scope="col">employee_id</th>
                <th scope="col">first_name</th>
                <th scope="col">last_name</th>
                <th scope="col">email</th>
                <th scope="col">hire_date</th>
                <th scope="col">job_id</th>
                <th scope="col">salary</th>
                <th scope="col">Delete</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${empList}" var="emp">
                <tr onclick="location.href='empInfo?employeeId=${emp.employeeId}'">
                    <td scope="row">${emp.employeeId}</td>
                    <td>${emp.firstName}</td>
                    <td>${emp.lastName}</td>
                    <td>${emp.email}</td>
                    <td><fmt:formatDate value="${emp.hireDate}" pattern="yyyy-MM-dd"/></td>
                    <td>${emp.jobId}</td>
                    <td>${emp.salary}</td>
                    <!-- 페이지이동이 아닌 삭제만 되어야 하며, event는 객체이므로 따움표로 감싸면 안된다 -->
                    <td>
                        <button type="button"
                                onclick="deleteInfo(${emp.employeeId}, event)"
                                class="btn btn-danger">
                            삭제
                        </button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <script>
        function printAlert(message){
            if(message == null || message == '') return;
            Swal.fire({
                        icon: 'success',
                        title: '확인해주세요',
                        text: message,
            });
        };
        printAlert(`${result}`);


        //반환되는건 데이터에 받아서 처리
        //제이쿼리의 ajax는 dataType: 'json'을 생략한 것
        //  -> html, text, json, xml은 알아서 파싱해줌
        function deleteInfo(id, event){
            $.ajax({
                url : 'empDelete',
                method : 'post',
                data: {employeeId : id},
                success : function(data){
                    console.log(data);
                },
                error : function(reject){
                    console.log(reject);
                }
            });

            //버블링 막는 메소드
            event.stopPropagation();
            //자동새로고침
            location.reload();
        }
    </script>
</body>
</html>