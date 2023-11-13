<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023-10-30
  Time: 오전 11:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../include/adminHeader.jsp"/>
<html>
<head>
    <title>Title</title>

</head>
<body>
    <main class="main-style">
        <div class="sidebar">
            <ul class="admin-sidebar-list">
                <li class="user-manage-btn" onclick="location='/admin/usermanage'">
                    유저 관리
                </li>
                <li class="user-manage-btn" onclick="location='/admin/partnermanage'">
                    파트너 유저 관리
                </li>
                <li onclick="approvedFoods()">
                    입점 음식점
                </li>
                <li onclick="pendingFoods()">
                    입점 신청 음식점
                </li>
                <li onclick="location='/admin/category'">
                    음식점 카테고리 등록
                </li>
            </ul>
        </div>
        <div>
            <div>
                <h2>유저 정보</h2>
                <p>이름: ${userInfo.userName}</p>
                <p>이메일: ${userInfo.email}</p>
                <p>전화번호: ${userInfo.phoneNumber}</p>
            </div>
            <div>
                <h2>
                    유저 주소 목록
                </h2>
                <c:choose>
                    <c:when test="${empty userAddressList}">
                        <p>주소 목록이 없습니다.</p>
                    </c:when>
                    <c:otherwise>
                        <table class="tableStyle">
                            <thead>
                            <tr>
                                <th>주소</th>
                                <th>우편번호</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="userAddressList" items="${userAddressList}">
                                <tr>
                                    <td>${userAddressList.userRoadAddress}-${userAddressList.userDetailAddress}</td>
                                    <td>${userAddressList.userZoneCode}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </c:otherwise>
                </c:choose>
            </div>
            <div>
                <h2>
                    유저 결제 목록
                </h2>
                <c:choose>
                    <c:when test="${empty userOrderList}">
                        <p>결제 목록이 없습니다.</p>
                    </c:when>
                    <c:otherwise>
                        <table class="tableStyle">
                            <thead>
                            <tr>
                                <th>음식점 이름</th>
                                <th>배달 요청 시간</th>
                                <th>배달 요청 날짜</th>
                                <th>배달 주소</th>
                                <th>메뉴</th>
                                <th>총 가격</th>
                                <th>구매날짜</th>
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
                                            ${userOrderList.paymentDay}
                            </td>
                                    <td>
                                            ${userOrderList.paymentOrderState}
                                    </td>
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
<script>
    function pendingFoods(){
        const pendingStatus = "PENDING";
        location.href = "/admin/foodmanage?pendingStatus=" + pendingStatus;
    }
    function approvedFoods(){
        const pendingStatus = "APPROVED";
        location.href = "/admin/foodmanage?pendingStatus=" + pendingStatus;
    }
</script>
</html>