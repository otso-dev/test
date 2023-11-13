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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/CSS/auth/auth.css">
</head>
<body>
    <main class="main-style">
        <div class="sidebar">
        </div>
        <div>

            <fieldset>
                <input class="email-input" type="text" placeholder="email"/>
            </fieldset>
            <div class="fail-email-message hide">이메일 형식을 지켜주세요(공백불가)</div>

            <fieldset>
                <input class="username-input" type="text" placeholder="이름"/>
            </fieldset>
            <div class="fail-username-message hide">2자이상 5자이하 한글만 가능합니다.(공백불가)</div>

            <fieldset>
                <input class="password-input" type="password" placeholder="비밀번호"/>
            </fieldset>
            <div class="fail-password-message hide">비밀번호는 8자이상 특수문자와 숫자를 포함해야합니다.(공백불가)</div>

            <fieldset>
                <input class="phone-number-input" type="text" placeholder="전화번호"/>
            </fieldset>
            <div class="fail-phone-number-message hide">전화번호는 000-0000-0000 형식입니다.(공백불가)</div>

            <button class="admin-register-btn" type="button" onclick="adminRegister()">확인</button>
        </div>
    </main>
</body>
<script>
    function adminRegister(){
        let email = $('.email-input').val();
        let userName = $('.username-input').val();
        let password = $('.password-input').val();
        let phoneNumber = $('.phone-number-input').val();

        console.log(
            "name  " + userNameFlag,
            "password  " + passwordFlag,
            "email  " + emailFlag,
            "phoneNumberFlag  " + phoneNumberFlag
        )
        if(userNameFlag&&passwordFlag&&emailFlag&&phoneNumberFlag){
            $.ajax({
                url:"/auth/admin/register",
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
                    alert(response);
                    window.location.href="/auth/admin/login";
                },
                error:function (response){
                    alert(response.responseJSON.data.register);
                }
            })

        }
    }
</script>
<script>
<%--유효성 검사--%>
const usernameValidation = /^([가-힣]){2,5}$/;
const passwordValidation = /^(?=.*?[0-9])(?=.*[#?!@$%^&-])(?=.*?[a-z])\S{8,}$/;
const emailValidation = /^\S+@\S+(\.\S)*$/g;
const phoneNumberValidation = /^01([0|1|6|7|8|9])-+([0-9]{3,4})-+([0-9]{4})$/;

const username = document.querySelector(".username-input");
const password = document.querySelector(".password-input");
const email = document.querySelector(".email-input");
const phoneNumber = document.querySelector(".phone-number-input");

const failUserNameMessage = document.querySelector(".fail-username-message");
const failPassWordMessage = document.querySelector(".fail-password-message");
const failEmailMessage = document.querySelector(".fail-email-message");
const failPhoneMessage = document.querySelector(".fail-phone-number-message");

let userNameFlag = false;
let passwordFlag = false;
let emailFlag = false;
let phoneNumberFlag = false;

function userNameValid(username){
    return usernameValidation.test(username);
}
function passwordValid(password){
    return passwordValidation.test(password);
}
function emailValid(email){
    return emailValidation.test(email);
}
function phoneNumberValid(phoneNumber){
    return phoneNumberValidation.test(phoneNumber);
}

username.onkeyup = () =>{
    if(username.value.length !== 0){
        if(!userNameValid(username.value)){
            failUserNameMessage.classList.remove("hide");
            userNameFlag = false;
        }else{
            failUserNameMessage.classList.add("hide");
            userNameFlag = true;
            console.log(userNameFlag);
        }
    }else{
        failUserNameMessage.classList.add("hide");
    }

}

password.onkeyup = () =>{
    if(password.value.length !== 0){
        if(!passwordValid(password.value)){
            failPassWordMessage.classList.remove("hide");
            passwordFlag = false;
        }else{
            failPassWordMessage.classList.add("hide");
            passwordFlag = true;
        }
    }else{
        failPassWordMessage.classList.add("hide");
    }
}

email.onkeyup = () =>{
    if(email.value.length !== 0){
        if(!emailValid(email.value)){
            failEmailMessage.classList.remove("hide");
            emailFlag = false;
        }else{
            failEmailMessage.classList.add("hide");
            emailFlag = true;
        }
    }else{
        failEmailMessage.classList.add("hide");
    }

}

phoneNumber.onkeyup = () =>{
    if(phoneNumber.value.length !== 0){
        if(!phoneNumberValid(phoneNumber.value)){
            failPhoneMessage.classList.remove("hide");
            phoneNumberFlag = false;
        }else{
            failPhoneMessage.classList.add("hide");
            phoneNumberFlag = true;
        }
    }else{
        failPhoneMessage.classList.add("hide");
    }
}

const adminRegisterBtn = document.querySelector(".admin-register-btn");


</script>
</html>
