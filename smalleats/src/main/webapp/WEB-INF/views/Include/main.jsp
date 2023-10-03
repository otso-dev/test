<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023-09-26
  Time: 오전 9:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/CSS/main/main.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/CSS/reset/reset.css">
    <title>smalleats</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js">
    </script>
</head>
<body>
    <header class="header-style">
        <div class="header-content">
            <div class="smalleats-box">
                <button class="smalleats-btn" type="button" onclick="location='/'">SmallEats</button>
            </div>
            <div class="page-btn-content">
                <button class="smalleats-btn" id="mypage-btn" type="button" onclick="location='../User/mypage'">마이페이지</button>
                <button class="smalleats-btn" id="Partners-btn" type="button" onclick="location='../User/mypage'">파트너스 페이지</button>
                <button class="smalleats-btn" id="admin-btn" type="button" onclick="location='../User/mypage'">관리자 페이지</button>
            </div>
            <div class="join-content">
                <button class="smalleats-btn" id="register-btn" type="button" onclick="location='../register'">회원가입</button>
                <button class="smalleats-btn" id="login-btn" type="button" onclick="location='../login'">로그인</button>
            </div>
        </div>
    </header>

</body>
</html>
