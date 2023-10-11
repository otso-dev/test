<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
</script>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="include/main.jsp"/>
<html>
<head>
    <title>main</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/CSS/main/main.css">
</head>
<body>
    <main class="main-style">
            <div class="sidebar">
                sidebar
            </div>
        <div class="content">
            <div class="food-category">
                food-category
            </div>
            <div class="main-content">
                <div class="food-content">
                    <c:forEach var="productList" items="${productList}">
                        <div class="food-box" onclick="location='/product/productdetail/'+${productList.foodId}">
                            <div class="food-img-box">

                            </div>
                            <footer class="food-footer">
                                <div class="food-name-box">
                                    <p>음식점이름 : ${productList.foodName}</p>
                                </div>
                                <div class="food-delivery-box">
                                    <p>배달시간 : AM ${productList.foodOpen}:00 - PM ${productList.foodClose}:00</p>
                                </div>
                            </footer>
                        </div>
                    </c:forEach>

                </div>


            </div>
        </div>
    </main>
</body>
<script>


</script>
</html>
