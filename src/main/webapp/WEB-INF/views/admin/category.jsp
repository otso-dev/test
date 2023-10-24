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
                alert(response + "등록 실패");
            }
        })
        categoryName.value = null;
    }
</script>
</html>
