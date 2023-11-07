<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023-10-19
  Time: 오후 5:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../../include/partnerHeader.jsp"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <main class="main-style">
            <div>
                <label>
                    <input class="login-email-input" type="email">
                </label>
                <label>
                    <input class="login-password-input" type="password">
                </label>
                <button type="button" onclick="partnerLogin()">로그인</button>
            </div>
        </main>
</body>
<script>
    function partnerLogin(){
        let email = $(".login-email-input").val();
        let password = $(".login-password-input").val();
        $.ajax({
            url: "/auth/partner/login",
            contentType: "application/json",
            type: "POST",
            data: JSON.stringify({
                email: email,
                password: password,
                role: "PARTNER"
            }),success:function (response){
                console.log(response);
                window.location.href="/partner/partnerpage";
            },error:function (response){
                console.log(response);
            }
        })
    }
</script>
</html>
