<%--
  Created by IntelliJ IDEA.
  User: hhgg0
  Date: 2023-10-22
  Time: 오후 8:42
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
    <div>
        <h2>배달지역등록</h2>
        <select name="sido1" id="sido1"></select>
        <select name="gugun1" id="gugun1"></select>
    </div>
</main>
</body>
<script>
    $('document').ready(function() {
        let area0 = ["시/도 선택","서울특별시","인천광역시","대전광역시","광주광역시","대구광역시","울산광역시","부산"];
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
        });
        // 시/도 선택 박스 초기화
        $selSido.each(function() {
            let $selSido = $(this);
            $.each(eval(area0), function() {
                $selSido.append("<option value='"+this+"'>"+this+"</option>");
            });
            $selSido.next().append("<option value=''>구/군 선택</option>");
            // 기본 시/도 설정
            let defaultSido = "${pendingFood.foodAddressSido}";
            if (defaultSido) {
                $selSido.val(defaultSido).trigger('change');
                setTimeout(function() {
                    $selSido.prop('disabled', true);
                }, 100);
            }
        });

        $('#addAreaButton').click(function() {
            let selectedGugun = $('#gugun1').val();

            if (!selectedGugun) {
                alert('시/구/군을 선택해주세요.');
                return;
            }

            let foodDeliveryAreaReqDto = {
                foodId:${pendingFood.foodId},
                foodDeliveryArea: selectedGugun
            };

            $.ajax({
                url: '/partner/delivery',
                type: 'POST',
                contentType: 'application/json',
                data: JSON.stringify(foodDeliveryAreaReqDto),
                success: function(response) {
                    alert('배달 지역이 성공적으로 등록되었습니다.');
                },
                error: function(error) {
                    console.error(error);
                    alert('배달 지역 등록 중 오류가 발생했습니다.');
                }
            });
    });
</script>
</html>
