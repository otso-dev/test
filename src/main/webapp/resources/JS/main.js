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
        let authorities = Auth.getInstance().getAuthorities();
        const registerBtn = document.querySelector(".smalleats-register-btn");
        const loginBtn = document.querySelector(".smalleats-login-btn");
        const logoutBtn = document.querySelector(".smalleats-logout-btn");

        if(authFlag && authorities === 'ROLE_USER'){
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
        const partnerBtn = document.querySelector(".smalleats-partners-btn");
        if(authorities === "ROLE_USER" && myPageBtn.classList.contains("hidden-main")){
            myPageBtn.classList.remove("hidden-main");
            partnerBtn.className += " hidden-main";
        }else{
            myPageBtn.className += " hidden-main";
            partnerBtn.classList.remove("hidden-main");
        }
        if(authorities === "ROLE_PAINTER"){
            partnerBtn.value = "파트너페이지";
        }
        partnerBtn.onclick = () =>{
            if(authorities === "ROLE_PARTNER" && authorities === "ROLE_ADMIN"){
                location.href="/partner/partnerpage";
            }else{
                location.href="/auth/partner";
            }
        }
    }
    testLogout(){
        const logoutBtn = document.querySelector(".smalleats-logout-btn");
        logoutBtn.onclick = () =>{
            console.log("logout click!!");

        }
    }
}