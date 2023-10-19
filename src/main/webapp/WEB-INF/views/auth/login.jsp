<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023-09-26
  Time: 오후 1:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../include/main.jsp"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
<main class="main-style">
    <div class="sidebar">
        sidebar
    </div>
    <div class="content">
        <div class="main-content">
            main-content
            <div>
                <label>email
                    <input class="login-email" type="email"/>
                </label>

                <label>password
                    <input class="login-password" type="password"/>
                </label>
                <button type="button" onclick="submitLogin()">확인</button>
            </div>
        </div>
    </div>
</main>
</body>
</html>
<script>
    function submitLogin(){
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
