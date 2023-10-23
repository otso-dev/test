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
    <title>admin</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/CSS/admin/admin.css">
</head>
<body>
    <main class="main-style">
        <div class="sidebar">

        </div>
        <div class="food-content">
            <c:forEach var="pendingFoodList" items="${pendingFoodList}">
                <div class="food-box">
                    <div class="food-img-box">

                    </div>
                    <footer class="food-footer">
                        <div class="food-name-box">
                            <p>음식점 이름: ${pendingFoodList.foodName}</p>
                            <p>지역: ${pendingFoodList.foodAddressSido}</p>
                            <p>주소: ${pendingFoodList.foodRoadAddress}</p>
                        </div>
                        <div class="food-delivery-box">
                            <p>오픈시간: ${pendingFoodList.foodOpen}</p>
                            <p>마감시간: ${pendingFoodList.foodClose}</p>
                        </div>
                    </footer>
                    <button type="button" onclick="adminFoodSubject(${pendingFoodList.pendingFoodId})">음식점 등록</button>
                </div>
            </c:forEach>
        </div>
    </main>
</body>

<script>
    function adminFoodSubject(foodId){
        $.ajax({
            url:"/admin/food/register",
            type:"POST",
            contentType: "application/json",
            data:JSON.stringify({
                foodId: foodId
            }),success:function (response){
                alert(response + "등록성공");
            },error:function (response){
                alert(response + "등록실패");
            }
        })
    }
</script>
</html>
