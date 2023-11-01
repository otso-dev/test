<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hhgg0
  Date: 2023-10-22
  Time: 오후 8:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../include/partnerHeader.jsp"/>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/CSS/partner/partner.css">
</head>
<body>
<main class="main-style">
    <div class="sidebar">
        <ul class="partner-sidebar-list">
            <li class="food-register" onclick="location='/partner/foodregister'">
                입점신청
            </li>
            <li class="menu-register" onclick="location='/partner/menu'">
                메뉴등록
            </li>
            <li class="delivery-register" onclick="location='/partner/delivery'">
                배달지역 설정
            </li>
            <li class="order-state" onclick="location='/partner/orderstate'">
                주문현황
            </li>
        </ul>
    </div>
    <div id="orderList-box">
        <h2>주문현황</h2>
        <c:forEach var="orderList" items="${orderList}">
            <div >
                <p>이름: ${orderList.userName}</p>
                <p>전화번호: ${orderList.phoneNumber}</p>
                <p>주소: ${orderList.userRoadAddress} ${orderList.userDetailAddress}</p>
                <p>우편번호: ${orderList.userZoneCode}</p>
                <p>배달요청시간: ${orderList.orderReqTime}</p>
                <p>배달요청날짜: ${orderList.orderDeliveryDay}</p>
                <c:forEach var="orderMenuList" items="${orderList.orderMenuList}">
                    <div>
                        메뉴: ${orderMenuList.foodMenuName}
                        가격: ${orderMenuList.foodMenuPrice}
                        개수: ${orderMenuList.menuNumbers}
                    </div>
                </c:forEach>
                <p>총 가격: ${orderList.paymentPrice}</p>
                <button class="order-state-btn" id="state" onclick="orderStateHandler(${orderList.orderId},'${orderList.paymentOrderState}')">${orderList.paymentOrderState}</button>
            </div>
        </c:forEach>
    </div>
</main>
</body>
<script>
    // function disabledBtn(){
    //     const orderStateBtn = document.querySelector(".order-state-btn");
    //     console.log(orderStateBtn);
    //     if(orderStateBtn.value === '배달완료'){
    //         console.log("true");
    //         orderStateBtn.disabled = true;
    //     }
    // } disabledBtn();

    function orderStateHandler(orderId,orderState){
        $.ajax({
            url:"/partner/payment/orderstate",
            type:"PUT",
            contentType:"application/json",
            data: JSON.stringify({
                orderId:orderId,
                paymentOrderState: orderState
            }),success:function (response){
                alert(response);
                $("#orderList-box").load(location.href+' #orderList-box');
            },error:function (response){
                alert(response.responseJSON.message);
            }
        })
    }
</script>
</html>
