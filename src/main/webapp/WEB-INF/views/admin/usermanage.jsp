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

    </div>
    <div>
        <table>
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

</html>
