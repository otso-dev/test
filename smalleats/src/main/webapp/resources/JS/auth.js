class Auth {
    static #instance = null;
    static getInstance(){
        if(this.#instance == null){
            this.#instance = new Auth();
        }
        return this.#instance;
    }

    constructor() {
        $.ajax({
            url:"/auth/authenticated",
            type: "GET",
            success:function (response){
                console.log(response);
            },error:function (response){
                console.log(response)
            }
        })
    }
}