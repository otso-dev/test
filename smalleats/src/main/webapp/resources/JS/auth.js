class Auth {
    static #instance = null;
    authFlag = false;
    authorities = null;
    static getInstance(){
        if(this.#instance == null){
            this.#instance = new Auth();
        }
        return this.#instance;
    }

    getAuthFlag(){
        return this.authFlag;
    }

    getAuthorities(){
        return this.authorities;
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
    getApiAuthorities(){
        let authorities = null;
        if(this.authFlag){
            $.ajax({
                url:"/auth/authorities",
                type: "GET",
                async: false,
                success:function (response){
                    console.log(response);
                    authorities = response.authorities;
                },
                error:function (response){
                    alert(response.data);
                }
            })
            this.authorities = authorities;

        }
        return this.authorities;
    }
}