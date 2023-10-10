<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023-09-26
  Time: 오후 2:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../include/main.jsp"/>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/CSS/mypage/mypage.css">
    <script src="${pageContext.request.contextPath}/resources/JS/mypage.js"></script>
    <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body>
<main class="main-style">
    <div class="sidebar">
        <div class="mypage-sidebar">
            <ul class="mypage-sidebar-list">
                <li class="userinfo-btn">
                    내 정보
                </li>
                <li class="order-list-btn">
                    주문조회
                </li>
                <li class="password-list-btn">
                    비밀번호 변경
                </li>
                <li class="address-content-btn">
                    주소
                </li>
            </ul>
        </div>
    </div>
    <div class="content">
        <div class="main-content">
            <div class="mypage-content">
                <div class="user-info">
                    <p id="user-name">이름: </p>
                    <p id="email">이메일: </p>
                    <p id="phone-number">전화번호: </p>
                </div>
                <div class="address-info">
                    <c:forEach var="userAddressList" items="${userAddressList}">
                        <div>
                            <p>주소: ${userAddressList.userRoadAddress}</p>
                            <p>상세주소 : ${userAddressList.userDetailAddress}</p>
                            <p>우편번호 : ${userAddressList.userZoneCode}</p>
                            <button class="user-address-update" type="button" onclick="userAddressUpdate(${userAddressList.userAddressId})">변경</button>
                            <button type="button" onclick="userAddressDelete(${userAddressList.userAddressId})">삭제</button>
                        </div>
                    </c:forEach>
                </div>
                <div class="order-list hidden-mypage">
                    주문조회
                </div>
                <div class="password-change hidden-mypage">
                    비밀번호 변경
                </div>
                <div class="address-content hidden-mypage">
                    <button type="button" onclick="postCard()">주소찾기</button>
                    <label>
                        <input id="road-name" type="text" placeholder="도로명 주소" readonly>
                    </label>
                    <label>
                        <input id="detail-address" placeholder="상세주소 입력" type="text">
                    </label>
                    <label>
                        <input id="zone-code" placeholder="우편번호" type="text" readonly>
                    </label>
                    <button type="button" onclick="addressInsert()">주소추가</button>
                </div>
            </div>
        </div>
    </div>

</main>
</body>
</html>
<script>
    $.ajax({
        url:'${pageContext.request.contextPath}/user/userinfo',
        type: 'GET',
        dataType: 'json',
        success:function (response){
            console.log(response);
            const name = response.username;
            const email = response.email;
            const phoneNumber = response.phoneNumber;
            $('#user-name').append(name);
            $('#email').append(email);
            $('#phone-number').append(phoneNumber);
        },
        error:function (response){
            console.log(response);
        }
    })


    function addressInsert(){
        const roadAddress = document.getElementById('road-name').value;
        const detailAddress= document.getElementById('detail-address').value;
        const zoneCode = document.getElementById('zone-code').value;
        $.ajax({
            url: '${pageContext.request.contextPath}/user/address/create',
            type: 'POST',
            contentType: 'application/json',
            data:JSON.stringify({
                userRoadAddress : roadAddress,
                userDetailAddress : detailAddress,
                userZoneCode : zoneCode
            }),
            success:function (response){
                alert(response + " 주소추가 성공");
            },error:function (response){
                alert(response);
            }
        })
    }
    function postCard() {
       new daum.Postcode({
           oncomplete:function (data) {
                if(data.userSelectedType === "R"){
                    document.getElementById('road-name').value = data.roadAddress;
                    document.getElementById('zone-code').value = data.zonecode;
                }else if(data.userSelectedType ==="J"){
                    alert("지번주소는 더 이상 지원하지 않습니다.");
                    close();
                }
           }
       }).open();
    }

    function userAddressUpdate(userAddressId){
        console.log(userAddressId);
        $.ajax({
            url:"/user/address/update",
            type:"PUT",
            data:{
                userAddressId: userAddressId
            },success:function (response){
                alert(response + "수정 성공");
            },error:function (response){
                alert(response + "수정 실패");
            }
        })
    }
    function userAddressDelete(userAddressId){
        console.log(userAddressId);
        $.ajax({
            url:"/user/address/delete",
            type:"DELETE",
            data:{
                userAddressId : userAddressId
            },
            success:function (response){
                alert(response + "삭제 성공");
            },error:function (response){
                alert(response+"삭제 실패");
            }
        })
    }
</script>