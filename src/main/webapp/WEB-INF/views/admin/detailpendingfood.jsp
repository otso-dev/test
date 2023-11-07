<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023-11-07
  Time: 오전 10:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../include/adminHeader.jsp"/>
<html>
<head>
    <title>admin</title>
</head>
<body>
    <main class="main-style">
        <div class="sidebar">

        </div>
        <div>
            <p>음식점 이름: ${pendingFood.foodName} </p>
            <p>지역: ${pendingFood.foodAddressSido}</p>
            <p>주소: ${pendingFood.foodRoadAddress} ${pendingFood.foodDetailAddress} ${pendingFood.foodZoneCode}</p>
            <p>오픈 시간: ${pendingFood.foodOpen}</p>
            <p>마감 시간: ${pendingFood.foodClose}</p>
            <p>최소 금액: ${pendingFood.foodMin}</p>
            <p>배달비: ${pendingFood.foodDeliveryPrice}</p>
            <p>음식점 카테고리: ${pendingFood.categoryName}</p>
            <p>음식점 파트너 유저: ${pendingFood.partnerUserName}</p>
            <p>음식점 파트너 전화번호: ${pendingFood.partnerPhoneNumber}</p>
            <c:choose>
                <c:when test="${pendingFood.pendingStatus eq 'PENDING'}">
                    <p>입점상태 : 입점안함</p>
                </c:when>
                <c:otherwise>
                    <p>입점상태 : 입점</p>
                </c:otherwise>
            </c:choose>
            <div>
                <h2>
                    음식점 메뉴
                </h2>
                <c:choose>
                    <c:when test="${empty foodMenuList}">
                        메뉴 등록 X
                    </c:when>
                    <c:otherwise>
                        <c:forEach var="foodMenuList" items="${foodMenuList}">
                            메뉴이름 : ${foodMenuList.foodMenuName}
                            <%--                    ${foodMenuList.foodMenuImg}--%>
                            가격 : ${foodMenuList.foodMenuPrice}
                        </c:forEach>
                    </c:otherwise>
                </c:choose>
            </div>
            <div>
                <h2>
                    배달 가능지역
                </h2>
                <c:choose>
                    <c:when test="${empty foodDeliveryAreaList}">
                        배달 가능지역 등록 X
                    </c:when>
                    <c:otherwise>
                        <c:forEach var="foodDeliveryAreaList" items="${foodDeliveryAreaList}">
                            ${foodDeliveryAreaList.foodDeliveryArea}
                        </c:forEach>
                    </c:otherwise>
                </c:choose>
            </div>
            <div>
                <h2>음식점 주문현황</h2>
                <c:choose>
                    <c:when test="${empty orderList}">
                        주문 없음
                    </c:when>
                    <c:otherwise>
                        <table>
                            <thead>
                                <tr>
                                    <th>이름</th>
                                    <th>전화번호</th>
                                    <th>주소</th>
                                    <th>배달 요청 시간</th>
                                    <th>배달 요청 날짜</th>
                                    <th>메뉴</th>
                                    <th>총 가격</th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="orderList" items="${orderList}">
                                <tr>
                                <td>${orderList.userName}</td>
                                    <td>${orderList.phoneNumber}</td>
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
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>

                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </main>
</body>
</html>
