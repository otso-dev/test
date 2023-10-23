<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023-10-23
  Time: 오후 2:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../../include/adminHeader.jsp"/>
<html>
<head>
    <title>admin</title>
</head>
<body>
    <main class="main-style">
        <div class="sidebar">
        </div>
        <div>
            <label>email</label>
            <input class="adminEmail" type="email" placeholder="email"/>
            <label>이름</label>
            <input class="adminName" type="text" placeholder="이름"/>
            <label>비밀번호</label>
            <input class="adminPassword" type="password" placeholder="비밀번호"/>
            <label>전화번호</label>
            <input class="adminPhone" type="text" placeholder="전화번호"/>
            <button type="button" onclick="adminRegister()">확인</button>
        </div>
    </main>
</body>
<script>
    function adminRegister(){
        let email = $('.adminEmail').val();
        let userName = $('.adminName').val();
        let password = $('.adminPassword').val();
        let phoneNumber = $('.adminPhone').val();

        $.ajax({
            url:"/auth/admin/register",
            type: 'POST',
            contentType : 'application/json',
            data : JSON.stringify({
                userName : userName,
                password : password,
                email : email,
                phoneNumber : phoneNumber,
            }),
            dataType: "json",
            success:function (response){
                alert(response);
                window.location.href="/auth/admin/login";
            },
            error:function (response){
                alert(response.responseJSON.data.register);
            }
        })

    }
</script>
</html>
