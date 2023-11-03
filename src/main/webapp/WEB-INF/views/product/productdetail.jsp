<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hhgg0
  Date: 2023-10-03
  Time: 오후 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../include/main.jsp"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/CSS/product/productDetail.css">
    <title>Smallets</title>
</head>
<body>
<main class="main-style">
    <div class="sidebar">
            <div class="order-box">
                <h3>배달 날짜 선택</h3>
                <label for="delivery-date">
                    <input type="date" id="delivery-date" min="" max="">
                </label>
                <h3>배달 요청 시간</h3>
                    <label for="delivery-time">
                        <select id="delivery-time" required="required">
                            <option value="" selected disabled hidden="">시간 선택</option>
                        </select>
                    </label>
                <div id="selected-menu-list">
                </div>
                <p id="total-price"></p>
                <div>
                    <label>
                        <select id="userAddressSelectList">
                            <c:forEach var="userAddressList" items="${userAddressList}">
                                <option value="${userAddressList.userAddressId}">${userAddressList.userAddressCategory}</option>
                            </c:forEach>
                        </select>
                    </label>
                    <label>
                        <input id="road-name" type="text" placeholder="도로명 주소" readonly>
                    </label>
                    <label>
                        <input id="detail-address" placeholder="상세주소 입력" type="text">
                    </label>
                    <label>
                        <input id="zone-code" placeholder="우편번호" type="text" readonly>
                    </label>
                </div>
                 <button type="button" onclick="order()">결제하러가기</button>
            </div>
    </div>
    <div class="detail-box">
        <div class="detail-info">
            <h2 >${productDetail.foodName}</h2>
            <p>배달시간 : ${productDetail.foodOpen}:00 - ${productDetail.foodClose}:00</p>
            <p>최소주문 금액 : ${productDetail.foodMin}</p>
            <p>배달비 : ${productDetail.foodDeliveryPrice}</p>
        </div>

        <!-- 메뉴 리스트 -->
        <div class="menu-list">
            <c:forEach var="foodMenuList" items="${foodMenuList}">
                <div class="menu-box">
                    <h3>${foodMenuList.foodMenuName}</h3>
                    <p>${foodMenuList.foodMenuPrice}</p>
                    <button type="button" onclick="menuChoice(${foodMenuList.foodMenuId},${foodMenuList.foodMenuPrice},'${foodMenuList.foodMenuName}')">담기</button>
                </div>
            </c:forEach>
        </div>

        <!-- 배달 지역 리스트 -->
        <div class="delivery-list">
            <c:forEach var="foodDeliveryList" items="${foodDeliveryList}">
                <!-- 배달 지역 -->
                <!-- Each delivery area is a block element and will be displayed vertically -->
                <!-- 각 배달 지역은 블록 요소이며 세로로 표시됩니다. -->
                <div class="delivery-area">
                    <p class="area">${foodDeliveryList.foodDeliveryArea}</p>
                </div>
            </c:forEach>
        </div>
    </div>
</main>
</body>
<script>
    let selectedMenus = {};
    let userRoadAddress = document.getElementById("road-name")
    let userDetailAddress = document.getElementById("detail-address");
    let userZoneCode = document.getElementById("zone-code");

    let userAddressList = [
        <c:forEach var="address" items="${userAddressList}" varStatus="loop">
        {
            "userAddressId": "${address.userAddressId}",
            "roadName": "${address.userRoadAddress}",
            "detailAddress": "${address.userDetailAddress}",
            "zoneCode": "${address.userZoneCode}"
        }<c:if test="${!loop.last}">,</c:if>
        </c:forEach>
    ];
    document.getElementById('userAddressSelectList').addEventListener('change', function() {
        let selectedAddressId = this.value;
        let selectedAddress = userAddressList.find(function(address) {
            return address.userAddressId === selectedAddressId;
        });

        if (selectedAddress) {
            userRoadAddress.value = selectedAddress.roadName;
            userDetailAddress.value = selectedAddress.detailAddress;
            userZoneCode.value = selectedAddress.zoneCode;
        }
    });
    function menuChoice(id, price, name) {
        if (selectedMenus[id]) {
            selectedMenus[id].count += 1;
        } else {
            selectedMenus[id] = { menuId: id, menuName: name, price: price, count: 1 };
        }
        updateSelectedMenus();
    }

    function updateSelectedMenus() {
        const menuContainer = document.getElementById('selected-menu-list');
        menuContainer.innerHTML = '';

        for (const id in selectedMenus) {
            if (selectedMenus[id].count > 0) {
                const menuItemElement = document.createElement('p');
                menuItemElement.textContent = selectedMenus[id].menuName + "가격: "+ selectedMenus[id].price + selectedMenus[id].count;


                const plusButton = document.createElement('button');
                plusButton.textContent = '+';
                plusButton.onclick = function () {
                    selectedMenus[id].count += 1;
                    updateSelectedMenus();
                };

                const minusButton = document.createElement('button');
                minusButton.textContent = '-';
                minusButton.onclick= function () {
                    selectedMenus[id].count -=1;
                    if(selectedMenus[id].count <=0 ) delete selectedMenus[id]; //갯수가 없어지면 삭제
                    updateSelectedMenus();
                };

                menuItemElement.appendChild(plusButton);
                menuItemElement.appendChild(minusButton);

                menuContainer.insertBefore(menuItemElement, menuContainer.firstChild); // 새로 추가된 메뉴 아이템을 맨 위에 추가합니다.
            }
        }
    }

    let today = new Date();
    let nextWeek = new Date(today.getFullYear(), today.getMonth(), today.getDate() + 7);

    let dd = String(today.getDate()).padStart(2, '0');
    let mm = String(today.getMonth() + 1).padStart(2, '0');
    const yyyy = today.getFullYear();

    today = yyyy + '-' + mm + '-' + dd;

    dd = String(nextWeek.getDate()).padStart(2, '0');
    mm = String(nextWeek.getMonth() + 1).padStart(2, '0');

    nextWeek = yyyy + '-' + mm + '-' + dd;

    document.getElementById("delivery-date").setAttribute("min", today);
    document.getElementById("delivery-date").setAttribute("max", nextWeek);

    const selectTimeElement = document.getElementById('delivery-time');

    let foodOpen = ${productDetail.foodOpen};
    let foodClose = ${productDetail.foodClose} + 12;

    for(let i=foodOpen; i<=foodClose; i++){
        let optionElement=document.createElement('option');
        optionElement.text=(i < 12 ? "오전 " : "오후 ") + (i <= 12 ? i : i-12) + ":00";
        optionElement.value=i;
        selectTimeElement.add(optionElement);
    }
    function order(){
        const orderReqTime = document.getElementById('delivery-time').value;
        const orderReqDeliveryDay = document.getElementById('delivery-date').value;
        const foodId = ${productDetail.foodId};
        if(orderReqTime === "" || orderReqDeliveryDay === ""){
            alert("배달 요청과 시간을 선택해주세요");
            return;
        }
        if(Object.keys(selectedMenus).length === 0 && selectedMenus.constructor === Object){
            alert("메뉴를 선택해주세요");
            return;
        }
        $.ajax({
            url:"/user/order",
            type:"POST",
            contentType: "application/json",
            async: false,
            data:JSON.stringify({
                userId: 0,
                foodId: foodId,
                orderReqTime: orderReqTime,
                orderReqDeliveryDay: orderReqDeliveryDay,
                orderRoadAddress: userRoadAddress.value,
                orderDetailAddress: userDetailAddress.value,
                orderZoneCode: userZoneCode.value,
                orderMenu: selectedMenus
            }),
            success:function (response) {
                window.location.href="/payment/paymentpage/" + response;
            },error:function (response) {
                console.log(response)
                alert(response)
            }
        })
    }

</script>
</html>
