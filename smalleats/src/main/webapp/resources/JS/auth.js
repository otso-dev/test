/*
     오류사항(버그) : 페이지 이동시 서블릿에 view파일을 통해 페이지를 찾고 컨트롤러에 맵핑 시켜
     페이지 이동을 하는(SSR 구조) spring mvc구조이고 customFilter에서 권한이 필요한 페이지와
     권한이 페이지를 설정하였음, 여기서 페이지 이동 자체를 GET요청으로 URI를 통해 페이지 이동을
     하기때문에 header에서 꺼낼 토큰 값이 없음
   * login을 한 후 token값을 local에 저장함, 그 값을 들고와 header에 요청을 보내야함
     페이지 이동 function
   * */
const currentUrl = window.location.href;
const protocol = window.location.protocol;
const host = window.location.host;
const pathname = window.location.pathname;
console.log("protocal: "+ protocol);
console.log("currentUrl: "+currentUrl);
console.log("host: "+host);
console.log("pathname: "+pathname);
if(pathname.startsWith("/auth")){
    $.ajax({
        url:`${pathname}`,
        type: 'GET',
        success:function (response){
            console.log(response);
        },
        error:function (response){
            console.log(response);
            alert(response.message);
        }
    })
}else {
    $.ajax({
        url:`${pathname}`,
        type: 'GET',
        headers: {"Authorization": localStorage.getItem("Token")},
        success:function (response){
            console.log(response);
        },
        error:function (response){
            console.log(response);
        }
    })
}
