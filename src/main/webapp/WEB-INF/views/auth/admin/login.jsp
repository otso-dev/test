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
            <label>email
                <input class="login-email" type="email"/>
            </label>

            <label>password
                <input class="login-password" type="password"/>
            </label>
            <button type="button" onclick="adminLogin()">확인</button>
        </div>
    </main>
</body>
<script>
    function adminLogin(){
        let email = $('.login-email').val();
        let password = $('.login-password').val();
        $.ajax({
            url: '/auth/login',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify({
                email: email,
                password: password,
            }),
            success:function (response){
                alert(response.data);
                window.location.href="/";
            },
            error:function (response){
                alert(response.responseJSON.data.login);
            }
        })
    }
</script>
</html>
