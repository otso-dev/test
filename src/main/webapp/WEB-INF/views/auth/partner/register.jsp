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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/CSS/auth/auth.css">
</head>
<body>
    <main class="main-style">
        <div>
            <fieldset>
                <label>
                    이름
                    <input class="username-input" type="text" placeholder="이름"/>
                </label>
            </fieldset>

            <div class="fail-username-message hide">2자이상 5자이하 한글만 가능합니다.(공백불가)</div>

            <fieldset>
                <label>
                    비밀번호
                    <input class="password-input" type="password" placeholder="비밀번호"/>
                </label>
            </fieldset>

            <div class="fail-password-message hide">비밀번호는 8자이상 특수문자와 숫자를 포함해야합니다.(공백불가)</div>
            <fieldset>
                <label>
                    이메일
                    <input class="email-input" type="text" placeholder="이메일"/>
                </label>
            </fieldset>

            <div class="fail-email-message hide">이메일 형식을 지켜주세요(공백불가)</div>
            <fieldset>
                <label>
                    전화번호
                    <input class="phone-number-input" type="text" placeholder="전화번호"/>
                </label>
            </fieldset>

            <div class="fail-phone-number-message hide">전화번호는 000-0000-0000 형식입니다.(공백불가)</div>
            <fieldset>
                <label>
                    상호명
                    <input class="business-name-input" type="text" placeholder="상호명"/>
                </label>
            </fieldset>

            <div class="fail-business-name-message hide">한글만 입력가능합니다.(공백불가)</div>
            <fieldset>
                <label>
                    사업장번호
                    <input class="business-number-input" type="text" placeholder="사업장번호"/>
                </label>
            </fieldset>

            <div class="fail-business-number-message hide">숫자만 입력 가능합니다.(공백불가)</div>

            <button type="button" onclick="registerSubmit()">회원가입</button>
        </div>
    </main>
</body>
<script>
    function registerSubmit(){
        let name = $(".username-input").val();
        let password = $(".password-input").val();
        let email = $(".email-input").val();
        let phoneNumber = $(".phone-number-input").val();
        let businessName = $(".business-name-input").val();
        let businessNumber = $(".business-number-input").val();

        if(userNameFlag&&passwordFlag&&emailFlag&&
           phoneNumberFlag&&businessNumberFlag&&businessNameFlag){
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
    }
</script>
<script>
    <%--유효성 검사--%>
    const usernameValidation = /^([가-힣]){2,5}$/;
    const passwordValidation = /^(?=.*?[0-9])(?=.*[#?!@$%^&-])(?=.*?[a-z])\S{8,}$/;
    const emailValidation = /^\S+@\S+(\.\S)*$/g;
    const phoneNumberValidation = /^01([0|1|6|7|8|9])-+([0-9]{3,4})-+([0-9]{4})$/;
    const businessNameValidation = /^([가-힣|\(\)])+$/;
    const businessNumberValidation = /^[0-9]+$/;


    const username = document.querySelector(".username-input");
    const password = document.querySelector(".password-input");
    const email = document.querySelector(".email-input");
    const phoneNumber = document.querySelector(".phone-number-input");
    const businessName = document.querySelector(".business-name-input");
    const businessNumber = document.querySelector(".business-number-input");

    const failUserNameMessage = document.querySelector(".fail-username-message");
    const failPassWordMessage = document.querySelector(".fail-password-message");
    const failEmailMessage = document.querySelector(".fail-email-message");
    const failPhoneMessage = document.querySelector(".fail-phone-number-message");
    const failBusinessNameMessage = document.querySelector(".fail-business-name-message");
    const failBusinessNumberMessage = document.querySelector(".fail-business-number-message");

    let userNameFlag = false;
    let passwordFlag = false;
    let emailFlag = false;
    let phoneNumberFlag = false;
    let businessNameFlag = false;
    let businessNumberFlag = false;

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
    function  businessNameValid(phoneNumber){
        return businessNameValidation.test(phoneNumber);
    }
    function businessNumberValid(phoneNumber){
        return businessNumberValidation.test(phoneNumber);
    }

    username.onkeyup = () =>{
        if(username.value.length !== 0){
            if(!userNameValid(username.value)){
                failUserNameMessage.classList.remove("hide");
                userNameFlag = false;
            }else{
                failUserNameMessage.classList.add("hide");
                userNameFlag = true;
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

    businessName.onkeyup = () =>{
        if(businessName.value.length !== 0){
            if(!businessNameValid(businessName.value)){
                failBusinessNameMessage.classList.remove("hide");
                businessNameFlag = false;
            }else{
                failBusinessNameMessage.classList.add("hide");
                businessNameFlag = true;
            }
        }else{
            failBusinessNameMessage.classList.add("hide");
        }
    }

    businessNumber.onkeyup = () =>{
        if(businessNumber.value.length !== 0){
            if(!businessNumberValid(businessNumber.value)){
                failBusinessNumberMessage.classList.remove("hide");
                businessNumberFlag = false;
            }else{
                failBusinessNumberMessage.classList.add("hide");
                businessNumberFlag = true;
            }
        }else{
            failBusinessNumberMessage.classList.add("hide");
        }
    }

</script>
</html>
