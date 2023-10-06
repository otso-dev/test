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
<main class="main-style">
    <div class="sidebar">
        sidebar
    </div>
    <div class="content">
        <div class="main-content">
            main-content
            <div>
                <label>email</label>
                <input class="inputemail" type="email" placeholder="email"/>
                <label>이름</label>
                <input class="inputname" type="text" placeholder="이름"/>
                <label>비밀번호</label>
                <input class="inputpassword" type="password" placeholder="비밀번호"/>
                <label>전화번호</label>
                <input class="inputphone" type="text" placeholder="전화번호"/>
                <button type="button" onclick="submitRegister()">확인</button>
            </div>
        </div>
    </div>
</main>
</html>
<script>
    function submitRegister(){
        let email = $('.inputemail').val();
        let userName = $('.inputname').val();
        let password = $('.inputpassword').val();
        let phoneNumber = $('.inputphone').val();

        $.ajax({
            url:'${pageContext.request.contextPath}/auth/register',
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
                window.location.href="../../..";
            },
            error:function (response){
                alert(response.responseJSON.data.register);
            }
        })

    }
</script>
