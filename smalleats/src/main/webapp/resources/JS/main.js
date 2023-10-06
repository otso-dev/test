class main{
    static #instance = null;
    static getInstance(){
        if(this.#instance == null){
            this.#instance = new main();
        }
        return this.#instance;
    }
    TestQuerySelecterEvent(){
        const smalleatsBtn = document.querySelector(".smalleats-btn");
        console.log(smalleatsBtn);
    }
    //

}
function  requirePage(url,method){
    $.ajax({
        url: url,
        type : method,
        headers: {"Authorization":localStorage.getItem("Token")},
        success:function (response){
            console.log(response);
        }
    })
}