<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023-10-23
  Time: 오후 2:58
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
        <table class="tableStyle">
            <thead>
                <tr>
                    <th>이름</th>
                    <th>이메일</th>
                    <th>전화번호</th>
                    <th>타입</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="adminUserList" items="${adminUserList}">
                    <tr style="cursor: pointer" onclick="location='/admin/usermanage/user/${adminUserList.userId}'">
                        <td>
                            ${adminUserList.userName}
                        </td>
                        <td>
                            ${adminUserList.email}
                        </td>
                        <td>
                            ${adminUserList.phoneNumber}
                        </td>
                        <td>
                            <c:choose>
                                <c:when test="${adminUserList.roleName eq 'ROLE_USER'}">
                                    일반회원
                                </c:when>
                                <c:when test="${adminUserList.roleName eq 'ROLE_ADMIN'}">
                                    관리자
                                </c:when>
                            </c:choose>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
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
