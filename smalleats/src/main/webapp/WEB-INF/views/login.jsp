<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023-09-26
  Time: 오후 1:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="Include/main.jsp"/>
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
                <label>email</label>
                <input class="login-email" type="email"/>
                <label>password</label>
                <input class="login-password" type="password"/>
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
            url: '${pageContext.request.contextPath}/smalleats/login',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify({
                email: email,
                password: password,
            }),
            success:function (response){
                console.log(response);
                let token ={};
                token = response;
                localStorage.setItem(token.grantType,token.accessToken);
                window.location.href="index";
            },
            error:function (response){
                console.log(response);
                alert(response.responseJSON.data.login);
            }
        })
    }
</script>
