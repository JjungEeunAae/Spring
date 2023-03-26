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
<title>전체조회</title>
<style>
    table, tr, th, td{
        border: 1px solid black;
    }
</style>
</head>
<body>
    <table>
        <thead>
            <tr>
                <th>employee_id</th>
                <th>first_name</th>
                <th>last_name</th>
                <th>email</th>
                <th>hire_date</th>
                <th>job_id</th>
                <th>salary</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${empList}" var="emp">
                <tr>
                    <td>${emp.employeeId}</td>
                    <td>${emp.firstName}</td>
                    <td>${emp.lastName}</td>
                    <td>${emp.email}</td>
                    <td><fmt:formatDate value="${emp.hireDate}" pattern="yyyy-MM-dd"/></td>
                    <td>${emp.jobId}</td>
                    <td>${emp.salary}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <script>
        function printAlert(message){
        	Swal.fire({
        				icon: 'success',
        				title: '확인해주세요',
        				text: message,
        	});
        };
        printAlert(`${result}`);
    </script>
</body>
</html>