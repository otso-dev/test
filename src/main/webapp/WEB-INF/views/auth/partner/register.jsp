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
    <title>partner</title>
</head>
<body>
    <main class="main-style">
        <div>
            <label>
                이름
                <input class="input-name" type="text" placeholder="이름"/>
            </label>
            <label>
                비밀번호
                <input class="input-password" type="password" placeholder="비밀번호"/>
            </label>
            <label>
                이메일
                <input class="input-email" type="email" placeholder="이메일"/>
            </label>
            <label>
                전화번호
                <input class="input-phone-number" type="text" placeholder="전화번호"/>
            </label>
            <label>
                상호명
                <input class="input-business-name" type="text" placeholder="상호명"/>
            </label>
            <label>
                사업장번호
                <input class="input-business-number" type="text" placeholder="사업장번호"/>
            </label>
            <button type="button" onclick="registerSubmit()">회원가입</button>
        </div>
    </main>
</body>
<script>
    function registerSubmit(){
        let name = $(".input-name").val();
        let password = $(".input-password").val();
        let email = $(".input-email").val();
        let phoneNumber = $(".input-phone-number").val();
        let businessName = $(".input-business-name").val();
        let businessNumber = $(".input-business-number").val();

        $.ajax({
            url:"/auth/partner/register",
            type: "POST",
            contentType:"application/json",
            data:JSON.stringify({
                partnerPassword : password,
                partnerUserEmail : email,
                partnerPhoneNumber : phoneNumber,
                partnerUserName : name,
                partnerBusinessName : businessName,
                partnerBusinessNumber : businessNumber
            }),success:function(response){
                console.log(response);
                window.location.href="/auth/partner/login";
            },error:function (response){
                console.log(response)
            }
        })
    }
</script>
</html>
