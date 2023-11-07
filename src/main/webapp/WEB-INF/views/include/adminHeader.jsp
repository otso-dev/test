<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023-10-23
  Time: 오후 2:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>admin</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/CSS/main/adminHeader.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/CSS/reset/reset.css">
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>
    <header class="header-style">
        <div class="header-content">
            <button class="admin-btn" onclick="location='/admin/adminpage'">SmallEats Admin</button>
        </div>
    </header>
</body>
</html>
