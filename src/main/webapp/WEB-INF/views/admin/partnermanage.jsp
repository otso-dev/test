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
                        <th>타입</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach var="partnerUserList" items="${partnerUserList}">
                    <tr style="cursor: pointer" onclick="location='/admin/partnermanage/partner/${partnerUserList.partnerId}'">
                        <td>${partnerUserList.partnerUserName}</td>
                        <td>${partnerUserList.partnerUserEmail}</td>
                        <c:if test="${partnerUserList.roleName eq 'ROLE_PARTNER'}">
                            <td>파트너</td>
                        </c:if>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

        </div>
    </main>
</body>
</html>
