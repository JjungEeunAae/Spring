<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>상세조회</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
</head>
<body>
	<h1>사원조회</h1>
    <form onsubmit="return false" >
        <div>
            <label>
                id : <input type="number" name="employeeId"value="${empInfo.employeeId}" readonly>
            </label>
        </div>
        <div>
            <label>
                first_name : <input type="text" name="firstName"value="${empInfo.firstName}">
            </label>
        </div>
        <div>
            <label>
                last_name : <input type="text" name="lastName"value="${empInfo.lastName}">
            </label>
        </div>
        <div>
            <label>
                email : <input type="text" name="email"value="${empInfo.email}">
            </label>
        </div>
        <div>
            <label>
                phone_number : <input type="text" name="phoneNumber"value="${empInfo.phoneNumber}">
            </label>
        </div>
        <div>
            <label>
                hire_date : <input type="date" name="hireDate"value='<fmt:formatDate value="${empInfo.hireDate}" pattern="yyyy-MM-dd"/>'>
            </label>
        </div>
        <div>
            <label>
                job_id : <input type="text" name="jobId"value="${empInfo.jobId}">
            </label>
        </div>
        <div>
            <label>
                salary : <input type="number" name="salary"value="${empInfo.salary}">
            </label>
        </div>
        <div>
            <label>
                commission_pct : <input type="number" name="commissionPct"value="${empInfo.commissionPct}">
            </label>
        </div>
        <div>
            <label>
                manager_id: <input type="number" name="managerId"value="${empInfo.managerId}">
            </label>
        </div>
        <div>
            <label>
                department_id : <input type="number" name="departmentId"value="${empInfo.departmentId}">
            </label>
        </div>
        <button type="submit" class="btn btn-primary">수정</button>
        <button type="button" class="btn btn-danger">취소</button>
    </form>

    <script>

        //form을 기반으로 데이터를 보낸다

        //JSON.stringify
        //가장 대표적인 JSON을 다루는 객체

        //serializeObject()
        //form 안에 있는 데이터를 바로 하나의 객체로 원하는 형태로 가지고 오기 위함

        //fetch는 우리 의도와 상관없이 자동으로 실행되기 때문에 필요할 때만 사용할 수 있도록 함수로 감쌌다
        function updateEmpInfo(){
            fetch('empUpdate', {
                method : 'post',
                headers : {
                    'Content-Type' : 'application/json'
                },
                body : JSON.stringify(serializeObject()) 
            })
            .then(response => response.json())
            .then(data => {
                //console.log(data);
                if (data != null && data['결과'] == 'Success'){
                    //한국어는 data.'결과'로 접근할 수 없다. 한국어로 값을 받아올 땐 대괄호를 사용하면 된다
                    Swal.fire({
                        icon: 'success',
                        title: '수정완료',
                        text: '사원번호 : ' + data['사원번호'] + '의 정보가 수정되었습니다',
                    });
                } else {
                    Swal.fire({
                        icon: 'error',
                        title: '확인해주세요',
                        text: '해당 사원의 정보가 정상적으로 수정되지 않았습니다',
                    });
                } 
            })
            .catch(reject => console.log(reject))
        }

        function serializeObject(){
            //객체배열로 만들어 줌
            //[{name : 'firstName', value : 'Steven'}, {name : '', value : ''},...]
            //vo에는 name이라는 필드명이 없으므로 firstName을 키로 주기 위해서 필요한 과정
            let formDate = $('form').serializeArray();

            //내부에 있는 값을 기반으로 하여 하나의 객체로 만들어주는 작업
            let objectDate = {}
            formDate.forEach(function (obj, idx){
                objectDate[obj.name] = obj.value;
            });
            
            return objectDate;
        }
        
        //함수 실행
        document.querySelector('button[type="submit"]').addEventListener('click', updateEmpInfo);

    </script>
</body>
</html>