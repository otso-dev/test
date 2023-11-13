<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hhgg0
  Date: 2023-10-23
  Time: 오전 12:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../include/partnerHeader.jsp"/>
<html>
<head>
    <title>Title</title>
    <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/CSS/partner/partner.css">
</head>
<body>
<main class="main-style">
    <div class="sidebar">
        <ul class="partner-sidebar-list">
            <li class="food-register" onclick="location='/partner/foodregister'">
                입점신청
            </li>
            <li class="menu-register" onclick="location='/partner/menu'">
                메뉴등록
            </li>
            <li class="delivery-register" onclick="location='/partner/delivery'">
                배달지역 설정
            </li>
            <li class="order-state" onclick="location='/partner/orderstate'">
                주문현황
            </li>
        </ul>
    </div>
    <div class="food-register-box">
        <h2>음식점 입점하기</h2>
        <label>
            <input class="foodName" type="text" placeholder="음식점 이름">
        </label>
        <label>
            <select id="categorySelect" onchange="getSelectedCategoryId(this.value)">
                <option value='0'>음식점 카테고리 선택</option>
                <c:forEach var="categoryList" items="${categoryList}">
                    <option value="${categoryList.categoryId}">${categoryList.categoryName}</option>
                </c:forEach>
            </select>
        </label>
<%--              img  <label>--%>
<%--                    <input type="text" placeholder="음식점 이름">--%>
<%--                </label>--%>
        <label>
            <input class="foodOpen" type="text" placeholder="오픈시간" min="0" max="12">
        </label>
        <label>
            <input class="foodClose" type="text" placeholder="마감시간" min="1" max="12">
        </label>
        <label>
            <input class="foodMin" type="text" placeholder="최소 주문금액">
        </label>
        <label>
            <input class="foodDeliveryPrice" type="text" placeholder="배달비">
        </label>
        <label>
            <button type="button" onclick="PostCard()">주소찾기</button>
            <input class="foodAddressSido" type="text" placeholder="시/도" readonly>
        </label>
        <label>
            <input class="foodAddressSiGunGu" type="text" placeholder="시/군/구" readonly>
        </label>
        <label>
            <input class="foodRoadAddress" type="text" placeholder="도로명 주소" readonly>
        </label>
        <label>
            <input class="foodDetailAddress" type="text" placeholder="상세주소">
        </label>
        <label>
            <input class="foodZoneCode" type="text" placeholder="우편번호" readonly>
        </label>
        <button type="button" onclick="pendingSubmit()">입점신청</button>
    </div>
</main>
</body>
<script>
    let selectedCategoryId = 0;
    // 선택된 카테고리 ID를 가져오는 함수
    function getSelectedCategoryId(value) {
        selectedCategoryId = value;
        return selectedCategoryId;
    }
    // select 요소에 이벤트 리스너 추가

    function PostCard(){
        const city = ["서울","인천","대전","광주","대구","울산","부산"];
        let count = 0;
        new daum.Postcode({
            onComplete:function (data){
                city.forEach((city)=>{
                    if(city === data.sido){
                        count++;
                    }
                })
                if(data.userSelectedType === "R" && count >= 1){
                    document.querySelector(".foodAddressSido").value = data.sido;
                    document.querySelector(".foodRoadAddress").value = data.roadAddress;
                    document.querySelector(".foodZoneCode").value = data.zonecode;
                    document.querySelector(".foodAddressSiGunGu").value = data.sigungu;
                    // console.log(data);
                }else if(data.userSelectedType === "J"){
                    alert("지번주소는 더 이상 지원하지 않습니다.");
                    close();
                }else{
                    alert("광역시와 특별시만 지원합니다.");
                    close();
                }
            }
        }).open();
    }

    function pendingSubmit(){
        const foodName = $(".foodName").val();
        const foodOpen = $(".foodOpen").val();
        const foodClose= $(".foodClose").val();
        const foodMin = $(".foodMin").val();
        const foodDeliveryPrice = $(".foodDeliveryPrice").val();
        const foodAddressSido = $(".foodAddressSido").val();
        const foodAddressSiGunGu = $(".foodAddressSiGunGu").val();
        const foodRoadAddress = $(".foodRoadAddress").val();
        const foodDetailAddress = $(".foodDetailAddress").val();
        const foodZoneCode = $(".foodZoneCode").val();

        if(!foodNameValidation(foodName)){
            alert("음식점 이름은 한글로만 입력해주세요");
            return;
        }
        if(!foodOpenValidation(foodOpen)){
            alert("오픈시간은 0~12 사이의 숫자로 입력해주세요");
            return;
        }
        if(!foodCloseValidation(foodClose)){
            alert("마감시간은 0~12 사이의 숫자로 입력해주세요");
            return;
        }
        if(!foodMinValidation(foodMin)){
            alert("최소 주문금액은 숫자로만 입력해주세요");
            return;
        }
        if(!foodDeliveryPriceValidation(foodDeliveryPrice)){
            alert("배달비는 숫자로만 입력해주세요");
            return;
        }
        if(selectedCategoryId === 0){
            alert("음식점 카테고리를 선택해주세요");
            return;
        }
        if(foodAddressSido === "" || foodDetailAddress === ""){
            alert("주소를 입력해주세요");
            return;
        }
        $.ajax({
            url:"/partner/foodregister",
            type:"POST",
            contentType: "application/json",
            data: JSON.stringify({
                foodName: foodName,//한글 영어?
                categoryId: selectedCategoryId,//not null
                foodOpen: foodOpen,//0 ~ 12 숫자만
                foodClose: foodClose,// 1 ~ 12 숫자만
                foodMin: foodMin,//숫자만
                foodDeliveryPrice: foodDeliveryPrice,//숫자만
                foodAddressSido: foodAddressSido,//not null
                foodAddressSiGunGu: foodAddressSiGunGu,//not null
                foodRoadAddress: foodRoadAddress,//not null
                foodDetailAddress: foodDetailAddress,//not null + 공백 x
                foodZoneCode: foodZoneCode//not null
            }),success:function (response){
                alert(response);
            },error:function (response){
                console.log(response);
                alert(response.responseJSON.message);
            }
        })


    }
</script>

<script>
    const foodNameValid = /^[가-힇]{1,15}$/;
    const foodOpenValid = /^[0-9]{1}$|^[1-9]{1}[0-2]{1}$/;
    const foodCloseValid = /^[1-9]{1}$|^[1-9]{1}[0-2]{1}$/;
    const foodMinValid = /^[0-9]{1,5}$/;
    const foodDeliveryPriceValid = /^[0-9]{1,4}$/;

    function foodNameValidation(foodName){
        return foodNameValid.test(foodName);
    }

    function foodOpenValidation(foodOpen){
        return foodOpenValid.test(foodOpen);
    }

    function foodCloseValidation(foodClose){
        return foodCloseValid.test(foodClose);
    }

    function foodMinValidation(foodMin){
        return foodMinValid.test(foodMin);
    }

    function foodDeliveryPriceValidation(foodDeliveryPrice){
        return foodDeliveryPriceValid.test(foodDeliveryPrice);
    }
</script>
</html>
