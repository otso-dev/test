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
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/JS/app.js">
    </script>
    <script src="${pageContext.request.contextPath}/resources/JS/main.js?testNm=1"></script>
    <script src="${pageContext.request.contextPath}/resources/JS/auth.js?testNm=2"></script>
    <script src="${pageContext.request.contextPath}/resources/JS/mypage.js?testNm=3"></script>
</head>
<body>
    <header class="header-style">
        <div class="header-content">
            <div class="smalleats-box">
                <button class="smalleats-btn" type="button" onclick="location='/'">SmallEats</button>
            </div>
            <div class="page-btn-content">
                <button class="smalleats-mypage-btn hidden-main" type="button" onclick="location='/user/mypage'">마이페이지</button>
                <button class="smalleats-partners-btn" type="button" onclick="location='/auth/partner'">입점문의</button>
                <button class="smalleats-admin-btn hidden-main"  type="button" onclick="location='/user/mypage'">관리자 페이지</button>
            </div>
            <div class="join-content">
                <button class="smalleats-register-btn" type="button" onclick="location='/auth/register'">회원가입</button>
                <button class="smalleats-login-btn" type="button" onclick="location='/auth/login'">로그인</button>
                <button class="smalleats-logout-btn hidden-main" type="button" onclick="logout()">로그아웃</button>
            </div>
        </div>
    </header>

<script>
    function logout(){
        console.log("??")
        $.ajax({
            url:"/user/logout",
            type: "GET",
            success:function (response){
                console.log(response)
                alert("로그아웃");
                window.location.href="/";
            },error:function (response){
                console.log(response);
            }
        })
    }

</script>
</body>
</html>
