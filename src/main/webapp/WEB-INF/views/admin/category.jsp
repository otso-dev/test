<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023-10-24
  Time: 오전 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../include/adminHeader.jsp"/>
<html>
<head>
    <title>admin</title>
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
            <label>
                <input class="adminCategory" type="text">
                <button type="button" onclick="categorySubmit()">추가하기</button>
            </label>
        </div>
    </main>
</body>
<script>
    function categorySubmit(){
        let categoryName = $(".adminCategory").val();
        $.ajax({
            url:"/admin/category",
            type:"POST",
            contentType:"application/json",
            data: JSON.stringify({
                categoryName: categoryName
            }),success:function (response){
                alert(response + "등록 성공");
            },error:function (response){
                alert(response.responseJSON.message + " 등록 실패");
            }
        })
        categoryName.value = null;
    }
</script>
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
