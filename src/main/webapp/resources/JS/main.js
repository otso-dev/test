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

        if(authFlag && authorities === 'ROLE_USER' || authFlag && authorities === 'ROLE_ADMIN'){
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
        let authFlag = Auth.getInstance().getAuthFlag();
        console.log("authorities: "+ authorities)
        const myPageBtn = document.querySelector(".smalleats-mypage-btn");
        const partnerBtn = document.querySelector(".smalleats-partners-btn");
        const adminBtn = document.querySelector(".smalleats-admin-btn");
        if(authorities === "ROLE_USER" && myPageBtn.classList.contains("hidden-main")){
            myPageBtn.classList.remove("hidden-main");
            partnerBtn.className += " hidden-main";
        }else{
            myPageBtn.className += " hidden-main";
            partnerBtn.classList.remove("hidden-main");
        }
        if(authFlag && authorities === "ROLE_PAINTER" || authFlag && authorities === "ROLE_ADMIN"){
            partnerBtn.textContent = "파트너페이지";
        }
        if(authFlag && authorities === "ROLE_ADMIN" && adminBtn.classList.contains("hidden-main")){
            adminBtn.classList.remove("hidden-main");
        }else{
            adminBtn.className += " hidden-main";
        }
        partnerBtn.onclick = () =>{
            if(authFlag && authorities === "ROLE_PARTNER" || authorities === "ROLE_ADMIN"){
                location.href="/partner/partnerpage";
            }else{
                location.href="/auth/partner";
            }
        }
        adminBtn.onclick = () =>{
            if(authFlag && authorities === "ROLE_ADMIN"){
                location.href="/admin/adminpage";
            }else{
                location.href="/auth/login";
            }
        }

    }
}