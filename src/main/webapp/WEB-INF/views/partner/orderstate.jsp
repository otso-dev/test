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
    <div class="order-content">
        <h2>주문현황</h2>
        <table class="tableStyle">
            <thead>
            <tr>
                <th>이름</th>
                <th>전화번호</th>
                <th>주소</th>
                <th>배달 요청 시간</th>
                <th>배달 요청 날짜</th>
                <th>메뉴</th>
                <th>총 가격</th>
                <th>주문 상태</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="orderList" items="${orderList}">
                <tr>
                    <td>이름: ${orderList.userName}</td>
                    <td>전화번호: ${orderList.phoneNumber}</td>
                    <td>주소: ${orderList.userRoadAddress} ${orderList.userDetailAddress} ${orderList.userZoneCode}</td>
                    <td>배달요청시간: ${orderList.orderReqTime}</td>
                    <td>배달요청날짜: ${orderList.orderDeliveryDay}</td>
                    <td>
                        <c:forEach var="orderMenuList" items="${orderList.orderMenuList}">
                            메뉴: ${orderMenuList.menuName}
                            가격: ${orderMenuList.price}
                            개수: ${orderMenuList.count}
                        </c:forEach>
                    </td>
                    <td>총 가격: ${orderList.paymentPrice}</td>
                    <td>
                        <button class="order-state-btn" id="state" onclick="orderStateHandler(${orderList.orderId},'${orderList.paymentOrderState}')">${orderList.paymentOrderState}</button>
                    </td>
                </tr
            </c:forEach>>
            </tbody>
        </table>
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
                $(".order-content").load(location.href+' .order-content');
            },error:function (response){
                alert(response.responseJSON.message);
            }
        })
    }
</script>
</html>
