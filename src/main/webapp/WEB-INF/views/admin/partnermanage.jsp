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

        </div>
        <div>
            <h2>
                파트너 유저 목록
            </h2>
            <table>
                <thead>
                    <tr>
                        <th>이름</th>
                        <th>이메일</th>
                        <th>전화번호</th>
                        <th>상호명</th>
                        <th>음식점 이름</th>
                        <th>입점상태</th>
                        <th>타입</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach var="partnerUserList" items="${partnerUserList}">
                    <tr>
                        <td>${partnerUserList.partnerUserName}</td>
                        <td>${partnerUserList.partnerUserEmail}</td>
                        <td>${partnerUserList.partnerPhoneNumber}</td>
                        <td>${partnerUserList.partnerBusinessName}</td>
                        <c:choose>
                            <c:when test="${empty partnerUserList.foodName && empty partnerUserList.pendingStatus}">
                                <td>입점 미신청<td>
                                <td>파트너</td>
                            </c:when>
                            <c:otherwise>
                                <td>${partnerUserList.foodName}</td>
                                <c:if test="${partnerUserList.pendingStatus eq 'PENDING'}">
                                    <td>입점 대기중</td>
                                </c:if>
                                <c:if test="${partnerUserList.pendingStatus eq 'APPROVED'}">
                                    <td>입점완료</td>
                                </c:if>
                                <c:if test="${partnerUserList.roleName eq 'ROLE_PARTNER'}">
                                    <td>파트너</td>
                                </c:if>
                            </c:otherwise>
                        </c:choose>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

        </div>
    </main>
</body>
</html>
