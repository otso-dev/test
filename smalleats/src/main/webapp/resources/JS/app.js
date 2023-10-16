window.onload = () =>{
    Auth.getInstance().getAuthenticate();
    Auth.getInstance().getApiAuthorities();
    Main.getInstance().TestQuerySelecterEvent();
    Main.getInstance().testAuthorities();
}