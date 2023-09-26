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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/CSS/main/main.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/CSS/reset/reset.css">
    <title>smalleats</title>
</head>
<body>
    <header class="header_style">
        <button type="button" onclick="location='../register'">회원가입</button>
        <button type="button" onclick="location='../login'">로그인</button>
    </header>

</body>
</html>
