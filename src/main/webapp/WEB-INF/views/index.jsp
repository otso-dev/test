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
        <label for="foodName">음식점 이름:</label>
        <input type="text" id="foodName" name="foodName">
        <select id="categorySelect" onchange="getSelectedCategoryId(this.value)">
            <option value='0'>음식점 카테고리 선택</option>
            <c:forEach var="categoryList" items="${categoryList}">
                <option value="${categoryList.categoryName}">${categoryList.categoryName}</option>
            </c:forEach>
        </select>
        <select name="sido1" id="sido1"></select>
        <select name="gugun1" id="gugun1"></select>
        <button type="button" onclick="searchFood(false)">검색하기</button>
    </div>
    <div class="content">
        <div class="food-category">
            <c:forEach var="categoryList" items="${categoryList}">
                <div class="category-box" onclick="categorySearch('${categoryList.categoryName}')">
                        ${categoryList.categoryName}
                </div>
            </c:forEach>
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
    let selectedGugun = null;
    let selectedSido = null;
    let selectedCategoryName = null;
    function getSelectedCategoryId(value) {
        selectedCategoryName = value;
        return selectedCategoryName;
    }

    function categorySearch(categoryName) {
        selectedCategoryName = categoryName;
        searchFood();
    }

    function searchFood(){
        let foodName = $('#foodName').val();
        $.ajax({
            url: '/auth/search',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify({
                foodAddressSiGunGu: selectedGugun,
                foodAddressSido: selectedSido,
                foodName: foodName,
                categoryName: selectedCategoryName
            }),
            success: function(data) {
                // 검색 결과를 화면에 표시
                let searchResultsElement = $('.food-content');
                searchResultsElement.empty();
                data.forEach(function(foodProduct) {
                    let foodProductElement =
                        "<div class='food-box' onclick=\"location='/product/productdetail/'+" + foodProduct.foodId + "\">" +
                        "<div class='food-img-box'></div>" +
                        "<footer class='food-footer'>" +
                        "<div class='food-name-box'>" +
                        "<p>음식점이름 : " + foodProduct.foodName + "</p>" +
                        "</div>" +
                        "<div class='food-delivery-box'>" +
                        "<p>배달시간 : AM " + foodProduct.foodOpen + ":00 - PM " + foodProduct.foodClose + ":00</p>" +
                        "</div>" +
                        "</footer>" +
                        "</div>";// 음식점 정보를 표시하는 요소
                    searchResultsElement.append(foodProductElement);
                });
                selectedGugun = null;
                selectedSido = null;
                selectedCategoryName = null;
            },
            error: function(response) {
                console.error('Ajax 요청 실패:', response);
                selectedGugun = null;
                selectedSido = null;
                selectedCategoryName = null;
            }
        });
    }

</script>
<script>
    $('document').ready(function() {
        let area0 = ["시/도 선택","서울","인천","대전","광주","대구","울산","부산"];
        let area1 = ["강남구","강동구","강북구","강서구","관악구","광진구","구로구","금천구","노원구","도봉구","동대문구","동작구","마포구","서대문구","서초구","성동구","성북구","송파구","양천구","영등포구","용산구","은평구","종로구","중구","중랑구"];
        let area2 = ["계양구","남구","남동구","동구","부평구","서구","연수구","중구","강화군","옹진군"];
        let area3 = ["대덕구","동구","서구","유성구","중구"];
        let area4 = ["광산구","남구","동구","북구","서구"];
        let area5 = ["남구","달서구","동구","북구","서구","수성구","중구","달성군"];
        let area6 = ["남구","동구","북구","중구","울주군"];
        let area7 = ["강서구","금정구","남구","동구","동래구","부산진구","북구","사상구","사하구","서구","수영구","연제구","영도구","중구","해운대구","기장군"];
        let $selSido = $("select[name^=sido]");
        // 시/도 선택시 구/군 설정
        $selSido.change(function() {
            selectedSido = $(this).val();
            let area = "area"+$("option",$(this)).index($("option:selected",$(this))); // 선택지역의 구군 Array
            let $gugun = $(this).next(); // 선택영역 군구 객체
            $("option",$gugun).remove(); // 구군 초기화

            if(area === "area0")
                $gugun.append("<option value=''>구/군 선택</option>");
            else {
                $.each(eval(area), function() {
                    $gugun.append("<option value='"+this+"'>"+this+"</option>");
                });
            }
            $gugun.change(function() {
                selectedGugun = $(this).val(); // 선택된 시/군/구 값
            });
        });
        // 시/도 선택 박스 초기화
        $selSido.each(function() {
            let $selSido = $(this);
            $.each(eval(area0), function() {
                $selSido.append("<option value='"+this+"'>"+this+"</option>");
            });
            $selSido.next().append("<option value=''>구/군 선택</option>");
        });
    });
</script>
</html>
