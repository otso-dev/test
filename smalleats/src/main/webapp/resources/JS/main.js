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
}