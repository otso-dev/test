<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023-10-31
  Time: 오전 11:43
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
                <h2>파트너 상세 정보</h2>
                <p>이름: ${partnerInfo.partnerUserName}</p>
                <p>이메일: ${partnerInfo.partnerUserEmail}</p>
                <p>전화번호: ${partnerInfo.partnerPhoneNumber}</p>
                <p>상호명: ${partnerInfo.partnerBusinessName}</p>
                <p>사업장 번호: ${partnerInfo.partnerBusinessNumber}</p>
            </div>
            <div>
                <h2>입점 음식점 정보</h2>
                    <c:choose>
                        <c:when test="${pendingFoodInfo.pendingStatus eq 'PENDING'}">
                            <p>음식점 입점 심사중</p>
                        </c:when>
                        <c:when test="${pendingFoodInfo.pendingStatus eq null}">
                            <p>음식점 입점 신청 안함</p>
                        </c:when>
                        <c:otherwise>
                            <p>음식점 이름: ${pendingFoodInfo.foodName}</p>
                            <p>음식점 주소 : ${pendingFoodInfo.foodRoadAddress} ${pendingFoodInfo.foodDetailAddress}</p>
                            <p>오픈 시간: AM${pendingFoodInfo.foodOpen}:00</p>
                            <p>마감 시간: PM${pendingFoodInfo.foodClose}:00</p>
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
