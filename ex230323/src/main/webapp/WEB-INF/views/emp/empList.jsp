<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
        /*  권장방식 XXXX
            제일 많이 쓰는 속성 중 onclik
            서로 다른 언어일 땐 컴파일하는 순서가 다르다
            그렇기때문에 의도한대로 결과가 나오지않을 경우도 있다

            서로 다른 코드는 겹쳐서 쓰지않는 것을 권장한다
        */




        /*  jsp는 자바가 먼저 해석된다
            그 다음 html 해석하는 브라우저에서 css, html, script를 읽는다
        */

        //EmpController.java에서 만든 rrtt.addFlashAttribute("result", result);가 출력됨

        //printAlert(${result}); --> 잘못된 방법
        //실제로 값이 들어갈 경우 인식할 수 있는 형태가 아니기 때문에 인식할 수 있도록 따움표를 붙혀줘야한다
        //printAlert(`${result}`); --> 올바른 방법
        //따움표는 줄바꿈을 인식하지 않기 때문에 백틱(``)을 사용한다

        function printAlert(message){
            alert(message);
        };

        printAlert(`${result}`);
    </script>
</body>
</html>