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
<jsp:include page="../include/main.jsp"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/CSS/product/productDetail.css">
<head>
    <title>detail</title>
</head>
<body>
<main>
    <div>
        <h2 >${productDetail.foodName}</h2>
        <p>배달시간 : ${productDetail.foodOpen}:00 - ${productDetail.foodClose}:00</p>
        <p>최소주문 금액 : ${productDetail.foodMin}</p>
        <p>배달비 : ${productDetail.foodDeliveryPrice}</p>
    </div>
    <c:forEach var="foodMenuList" items="${foodMenuList}">
        <div class="menu-box">
            <h3>${foodMenuList.foodMenuName}</h3>
            <p>${foodMenuList.foodMenuPrice}</p>
            <button type="button" onclick="menuChoice(${foodMenuList.foodMenuId},${foodMenuList.foodMenuPrice})">담기</button>
        </div>
    </c:forEach>
    <div>
        <c:forEach var="foodDeliveryList" items="${foodDeliveryList}">
            <div class="delivery-area">
                <p class="area">${foodDeliveryList.foodDeliveryArea}</p>
            </div>
        </c:forEach>
    </div>
    <div>
        <div class="order-box">

        </div>
        <button type="button" onclick="order()">주문하기</button>
    </div>
</main>
</body>
<script>
    let totalPrice = 0;
    let menuList = [];
    function menuChoice(menuId, menuPrice){
        let dupFlag = false;
        const choiceMenu = {
            menuId: 0,
            menuNumber: 0,
            menuPrice: 0
        };
        choiceMenu.menuId = menuId;
        choiceMenu.menuPrice = menuPrice;

        if(menuList.length <= 0){
            menuList.push(choiceMenu);
        }
        menuList.forEach((menu)=>{
            if(menu.menuId === menuId){
                dupFlag = true;
                menu.menuNumber += 1;
            }
        })
        if(dupFlag === false){
            menuList.push(choiceMenu);
        }
        return menuList;
    }
    const deliveryArea = document.querySelectorAll(".area");
    deliveryArea.forEach(delivery => {
        console.log(delivery.textContent);
    })
    function order(){
        $.ajax({
            url:"/order/payment",
            type: "POST",
            contentType:"application/json",
            data: JSON.stringify( {
                foodId : 1,
                orderReqTime : 1,
                orderDeliveryDay : "Date",
                orderMenu: menuList
            }),
            success:function (response){
                console.log(response);
            },
            error:function (response){
                console.log(response);
            }
        })
    }
</script>
</html>
