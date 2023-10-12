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
<head>
    <title>detail</title>
</head>
<body>
<main>
    <div>
        <h2>${productDetail.foodName}</h2>
        <p>배달시간 : ${productDetail.foodOpen}:00 - ${productDetail.foodClose}:00</p>
        <p>최소주문 금액 : ${productDetail.foodMin}</p>
        <p>배달비 : ${productDetail.foodDeliveryPrice}</p>
    </div>
    <c:forEach var="foodMenuList" items="${foodMenuList}">
        <div>
            <h3>${foodMenuList.foodMenuName}</h3>
            <p>${foodMenuList.foodMenuPrice}</p>
        </div>
    </c:forEach>
    <div>
        <c:forEach var="foodDeliveryList" items="${foodDeliveryList}">
            <p>${foodDeliveryList.foodDeliveryArea}</p>
        </c:forEach>
    </div>
</main>

</body>
</html>
