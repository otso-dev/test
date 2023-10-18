class Main {
    static #instance = null;

    static getInstance() {
        if (this.#instance == null) {
            this.#instance = new Main();
        }
        return this.#instance;
    }

    TestQuerySelecterEvent() {
        let authFlag = Auth.getInstance().getAuthFlag();
        const registerBtn = document.querySelector(".smalleats-register-btn");
        const loginBtn = document.querySelector(".smalleats-login-btn");
        const logoutBtn = document.querySelector(".smalleats-logout-btn");

        if(authFlag){
            if(logoutBtn.classList.contains("hidden-main")){
                logoutBtn.classList.remove("hidden-main");
            }
            registerBtn.className += " hidden-main";
            loginBtn.className += " hidden-main";
        }else{
            if(loginBtn.classList.contains("hidden-main") && registerBtn.classList.contains("hidden-main")){
                loginBtn.classList.remove("hidden-main");
                registerBtn.classList.remove("hidden-main");
            }
            logoutBtn.className += " hidden-main";
        }
    }
    testAuthorities(){
        let authorities = Auth.getInstance().getAuthorities();
        console.log("authorities: "+authorities)
        const myPageBtn = document.querySelector(".smalleats-mypage-btn");
        if(authorities === "ROLE_USER" && myPageBtn.classList.contains("hidden-main")){
            myPageBtn.classList.remove("hidden-main");
        }else{
            myPageBtn.className += " hidden-main";
        }
    }
    testLogout(){
        const logoutBtn = document.querySelector(".smalleats-logout-btn");
        logoutBtn.onclick = () =>{
            console.log("logout click!!");

        }
    }
}