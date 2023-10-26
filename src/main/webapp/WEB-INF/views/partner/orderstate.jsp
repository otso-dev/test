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
    <div>
        <h2>주문현황</h2>
        <c:forEach var="orderList" items="${orderList}">
            <div>
                <p>${orderList.userName}</p>
                <p>${orderList.phoneNumber}</p>
                <p>${orderList.userRoadAddress}</p>
                <p>${orderList.userDetailAddress}</p>
                <p>${orderList.userZoneCode}</p>
                <p>${orderList.orderReqTime}</p>
                <p>${orderList.orderDeliveryDay}</p>
                <c:forEach var="orderMenuList" items="${orderList.orderMenuList}">
                    <div>
                        ${orderMenuList.foodMenuName}
                        ${orderMenuList.foodMenuPrice}
                        ${orderMenuList.menuNumbers}
                    </div>
                </c:forEach>
                <p>${orderList.paymentPrice}</p>
            </div>
        </c:forEach>
    </div>
</main>
</body>
</html>
