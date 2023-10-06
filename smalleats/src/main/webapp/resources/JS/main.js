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