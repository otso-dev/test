<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023-10-17
  Time: 오후 2:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="../include/main.jsp"/>
<head>
    <title>smalleats</title>
</head>
<body>
    <main class="main-style">
            <div class="sidebar">
                <p class="req-day">${currentOrder.orderDeliveryDay}</p>
                <p class="req-time">${currentOrder.orderReqTime}</p>
                <p class="req-time">${currentOrder.orderId}</p>
                <p class="req-time">${currentOrder.foodName}</p>
                <p class="req-time">${currentOrder.foodDeliveryPrice}</p>
                <p class="req-time">${currentOrder.foodId}</p>
                <c:set var="totalPrice" value="0"/><!-- 총 가격을 저장할 변수를 초기화 -->
                <p class="req-time">${currentOrder.foodDeliveryPrice}</p>
                <c:forEach var="paymentMenuList" items="${paymentMenuList}">
                    <p>${paymentMenuList.foodMenuName}</p>
                    <p>${paymentMenuList.menuNumbers}</p>
                    <p>${paymentMenuList.foodMenuPrice}</p>
                    <!-- 각 메뉴의 개수와 가격을 곱해서 총 가격에 더함 -->
                    <c:set var="totalPrice" value="${totalPrice + (paymentMenuList.menuNumbers * paymentMenuList.foodMenuPrice)}"/>
                </c:forEach>
                <!-- 배달비를 총 가격에 더함 -->
                <c:set var="totalPrice" value="${totalPrice + currentOrder.foodDeliveryPrice}"/>
                <p id="total-price">${totalPrice}</p>
                <button type="button" onclick="payment()">결제하기</button>
            </div>
            <div>

            </div>
    </main>
</body>
<script>
    function payment(){
        $.ajax({
            url:"/payment/paymentpage/paid",
            type:"POST",
            contentType: "application/json",
            data:JSON.stringify({
                orderId:${currentOrder.orderId},
                foodId:${currentOrder.foodId},
                paymentPrice: ${totalPrice}
            }),
            success:function (response){
                alert(response);
            },error:function (response){
                alert(response);
            }
        })
    }
</script>
</html>
