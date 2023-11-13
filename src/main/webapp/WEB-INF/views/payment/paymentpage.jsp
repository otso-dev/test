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
            <div>
                <p class="req-day">${currentOrder.orderDeliveryDay}</p>
                <p class="req-time">${currentOrder.orderReqTime}</p>
                <p class="req-time">${currentOrder.orderId}</p>
                <p class="req-time">${currentOrder.foodName}</p>
                <p class="req-time">${currentOrder.foodDeliveryPrice}</p>
                <p class="req-time">${currentOrder.foodId}</p>
                <c:set var="totalPrice" value="0"/><!-- 총 가격을 저장할 변수를 초기화 -->
                <c:set var="mentTotalPrice" value="0"/><!-- 총 가격을 저장할 변수를 초기화 -->
                <p class="req-time">${currentOrder.foodDeliveryPrice}</p>
                <c:forEach var="paymentMenuList" items="${paymentMenuList}">
                    <p>${paymentMenuList.menuName}</p>
                    <p>${paymentMenuList.count}</p>
                    <p>${paymentMenuList.price}</p>
                    <!-- 각 메뉴의 개수와 가격을 곱해서 총 가격에 더함 -->
                    <c:set var="totalPrice" value="${totalPrice + (paymentMenuList.count * paymentMenuList.price)}"/>
                    <c:set var="mentTotalPrice" value="${mentTotalPrice + (paymentMenuList.count * paymentMenuList.price)}"/>
                </c:forEach>
                <!-- 배달비를 총 가격에 더함 -->
                <c:set var="totalPrice" value="${totalPrice + currentOrder.foodDeliveryPrice}"/>
                <p id="total-price">${totalPrice}</p>
                <button type="button" onclick="payment()">결제하기</button>
                <button type="button" onclick="paymentCancel()">취소하기</button>
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
                paymentTotalPrice: ${totalPrice},
                paymentDeliveryPrice: ${currentOrder.foodDeliveryPrice},
                paymentMenuPrice: ${mentTotalPrice}
            }),
            success:function (response){
                alert(response);
                window.location.href='/';
            },error:function (response){
                alert(response.responseJSON.message);
            }
        })
    }
    function paymentCancel(){
        let con_firm = confirm("결제를 취소하면 주문정보가 사라집니다. 그래도 취소하시겠습니까?");
        if(con_firm === true){
            $.ajax({
                url: "/payment/paymentpage/cancel/"+${currentOrder.orderId},
                type: "DELETE",
                success:function (response){
                    alert(response+"취소완료");
                    window.location.href='${pageContext.request.contextPath}/product/productdetail/'+${currentOrder.foodId};
                },error:function (response){
                    alert(response+"취소실패");
                }
            })
        }else{
          return 0;
        }
    }
</script>
</html>
