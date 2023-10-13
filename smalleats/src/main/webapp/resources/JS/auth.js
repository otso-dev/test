class Auth {
    static #instance = null;
    authFlag = false;
    static getInstance(){
        if(this.#instance == null){
            this.#instance = new Auth();
        }
        return this.#instance;
    }

    getAuthFlag(){
        return this.authFlag;
    }

    getAuthenticate(){
        let authFlag = false;
        $.ajax({
            url:"/auth/authenticated",
            type: "GET",
            async : false,
            success:function (response){
                console.log("success: " + response);
                authFlag = response;
            },error:function (response){
                console.log("error: "+ response)
            }
        })
        this.authFlag = authFlag;
        return this.authFlag;
    }
}