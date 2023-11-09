<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023-09-26
  Time: 오후 2:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>smalleats</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/CSS/mypage/mypage.css">
    <jsp:include page="../include/main.jsp"/>
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
                <div class="order-list hidden-mypage">
                    <table>
                        <thead>
                            <tr>
                                <th>음식점 이름</th>
                                <th>배달 요청 시간</th>
                                <th>배달 요청 날짜</th>
                                <th>배달 주소</th>
                                <th>메뉴</th>
                                <th>총 가격</th>
                                <th>상태</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="userOrderList" items="${userOrderList}">
                                <tr>
                                    <td>
                                        ${userOrderList.foodName}
                                    </td>
                                    <td>
                                        ${userOrderList.orderReqTime}
                                    </td>
                                    <td>
                                        ${userOrderList.orderDeliveryDay}
                                    </td>
                                    <td>
                                         ${userOrderList.userRoadAddress} ${userOrderList.userDetailAddress} ${userOrderList.userZoneCode}
                                    </td>
                                    <td>
                                        <c:forEach var="orderMenuList" items="${userOrderList.userOrderMenuList}">
                                            <p>${orderMenuList.menuName}</p>
                                            <p>${orderMenuList.count}</p>
                                            <p>${orderMenuList.price}</p>
                                        </c:forEach>
                                    </td>
                                    <td>
                                        ${userOrderList.paymentPrice}
                                    </td>
                                    <td>
                                        ${userOrderList.paymentOrderState}
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="password-change hidden-mypage">
                    비밀번호 변경
                    <label>
                        <input class="current-password" type="password" placeholder="현재 비밀번호"/>
                    </label>
                    <label>
                        <input class="change-password" type="password" placeholder="비밀번호 변경"/>
                    </label>
                    <label>
                        <input class="check-password" type="password" placeholder="비밀번호 확인"/>
                    </label>
                    <button type="button" onclick="changePassword()">비밀번호 변경하기</button>
                </div>
                <div class="address-content hidden-mypage">
                    <div class="address-info" id="addressList">
                        <c:forEach var="userAddressList" items="${userAddressList}">
                            <p>주소: ${userAddressList.userRoadAddress}</p>
                            <p>상세주소 : ${userAddressList.userDetailAddress}</p>
                            <p>우편번호 : ${userAddressList.userZoneCode}</p>
                            <c:choose>
                                <c:when test="${userAddressList.userAddressFlag eq 1}">
                                    <button class="user-address-default" type="button" onclick="onClickDefault(${userAddressList.userAddressId})" disabled>기본 주소지 설정</button>
                                </c:when>
                                <c:otherwise>
                                    <button class="user-address-default" type="button" onclick="onClickDefault(${userAddressList.userAddressId})">기본 주소지 설정</button>
                                </c:otherwise>
                            </c:choose>
                            <button class="user-address-update" type="button" onclick="onClickUpdate(${userAddressList.userAddressId})">변경</button>
                            <button type="button" onclick="userAddressDelete(${userAddressList.userAddressId})">삭제</button>
                        </c:forEach>
                    </div>
                    <div>
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
                        <label>
                            <input id="category" placeholder="주소 카테고리 입력" type="text">
                        </label>
                        <button class="address-button" type="button" onclick="addressInsert()">주소추가</button>
                    </div>
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
    let userAddressSido = null;
    let userAddressSigungu = null;
    const addressButton = document.querySelector('.address-button');


    function addressInsert(){
        const roadAddress = document.getElementById("road-name").value;
        const detailAddress= document.getElementById("detail-address").value;
        const zoneCode = document.getElementById("zone-code").value;
        const userAddressCategory = document.getElementById("category").value;
        $.ajax({
            url: '${pageContext.request.contextPath}/user/address/create',
            type: 'POST',
            contentType: 'application/json',
            data:JSON.stringify({
                userRoadAddress : roadAddress,
                userDetailAddress : detailAddress,
                userAddressSido: userAddressSido,
                userAddressSigungu: userAddressSigungu,
                userAddressCategory: userAddressCategory,
                userZoneCode : zoneCode
            }),
            success:function (response){
                alert(response + " 주소추가 성공");
                $("#addressList").load(location.href+' #addressList');
            },error:function (response){
                alert(response.responseJSON.message);
            }
        })
    }
    function postCard() {
        const city = ["서울","인천","대전","광주","대구","울산","부산"];
        let count = 0;
        new daum.Postcode({
            onComplete:function (data){
                city.forEach((city)=>{
                    if(city === data.sido){
                        count++;
                    }
                })
                console.log(data);
                if(data.userSelectedType === "R" && count >= 1){
                    userAddressSido = data.sido;
                    userAddressSigungu = data.sigungu;
                    document.getElementById("road-name").value = data.roadAddress;
                    document.getElementById("zone-code").value = data.zonecode;
                    // console.log(data);
                }else if(data.userSelectedType === "J"){
                    alert("지번주소는 더 이상 지원하지 않습니다.");
                    close();
                }else{
                    alert("광역시와 특별시만 지원합니다.");
                    close();
                }
            }
        }).open();
    }

    function onClickUpdate(userAddressId){
        // 주소 변경 화면 보이게 하기
        document.querySelector('.address-content').classList.remove('hidden-mypage');
        document.querySelector('.address-info').className += " hidden-mypage";

        // 버튼 텍스트 변경
        addressButton.textContent = '주소변경';



        // onclick 함수 변경
        addressButton.onclick = function() {
            userAddressUpdate(userAddressId);
            document.querySelector('.address-info').classList.remove('hidden-mypage');
            document.querySelector('.address-content').classList.remove('hidden-mypage');
            addressButton.textContent = '주소추가';
        };

    }
    function userAddressUpdate(userAddressId){
        const roadAddress = document.getElementById("road-name").value;
        const detailAddress= document.getElementById("detail-address").value;
        const zoneCode = document.getElementById("zone-code").value;
        const userAddressCategory = document.getElementById("category").value;
        $.ajax({
            url:"/user/address/update",
            type:"PUT",
            contentType: 'application/json',
            data:JSON.stringify({
                userAddressId : userAddressId,
                userAddressSido : userAddressSido,
                userAddressSigungu: userAddressSigungu,
                userRoadAddress : roadAddress,
                userDetailAddress : detailAddress,
                userAddressCategory: userAddressCategory,
                userZoneCode : zoneCode
            }),success:function (response){
                alert(response + "수정 성공");
                $("#addressList").load(location.href+' #addressList');
                addressButton.onclick = function (){
                    addressInsert();
                }
            },error:function (response){
                alert(response + "수정 실패");
            }
        })
    }
    function userAddressDelete(userAddressId){
        console.log(userAddressId);
        $.ajax({
            url:"/user/address/delete/" + userAddressId,
            type:"DELETE",
            success:function (response){
                alert(response + "삭제 성공");
                $("#addressList").load(location.href+' #addressList');
            },error:function (response){
                alert(response+"삭제 실패");
            }
        })
    }
    function changePassword(){
        const currentPassword = document.querySelector(".current-password").value;
        const changePassword = document.querySelector(".change-password").value;
        const checkPassword = document.querySelector(".check-password").value;
        $.ajax({
            url: '/user/password/change',
            type: "PUT",
            contentType: 'application/json',
            data:JSON.stringify({
                currentPassword: currentPassword,
                changePassword: changePassword,
                checkPassword: checkPassword
            }),success:function (response){
                if(response.status === 200){
                    alert("비밀번호 변경 성공");
                }
            },error:function (response){
                if(response.status === 400){
                    alert(response.responseJSON.data.password);
                }
            }
        })
    }
    function onClickDefault(addressId){
        $.ajax({
            url:'/user/address/default',
            type:'PUT',
            contentType: 'application/json',
            data: JSON.stringify({
                addressId: addressId
            }),success:function (){
                $("#addressList").load(location.href+' #addressList');
            }
        })
    }
</script>