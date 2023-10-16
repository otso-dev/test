class Mypage {
    static #instance = null;
    static getInstance() {
        if (this.#instance == null) {
            this.#instance = new Mypage();
        }
        return this.#instance;
    }

    constructor() {
        this.init();
    }

    init() {
        // 각 버튼과 컨텐츠 div들에 대한 참조 가져오기
        this.userInfoBtn = document.querySelector('.userinfo-btn');

        this.orderListBtn = document.querySelector('.order-list-btn');
        this.passwordListBtn = document.querySelector('.password-list-btn');
        this.addressContentBtn = document.querySelector('.address-content-btn');


        // 각 컨텐츠 div들에 대한 참조 가져오기
        this.userInfoDiv = document.querySelector('.user-info');
        this.orderListDiv = document.querySelector('.order-list');
        this.passwordChangeDiv = document.querySelector('.password-change');
        this.addressContentDiv = document.querySelector('.address-content');

        // 각 버튼에 이벤트 리스너 추가

        // 사용자 정보 버튼 클릭 시
        this.userInfoBtn.onclick = () => {
            this.showContent('user');
        };

        // 주문 조회 버튼 클릭 시
        this.orderListBtn.onclick = () => {

            this.showContent('order');
        };

        // 비밀번호 변경 버튼 클릭 시
        this.passwordListBtn.onclick = () => {

            this.showContent('password');
        };

        // 주소 변경 버튼 클릭 시
        this.addressContentBtn.onclick = () => {

            this.showContent('address');
        };

    }


    showContent(contentType) {

        switch (contentType) {

            case 'user':
                if (this.userInfoDiv.classList.contains("hidden-mypage")) {
                    this.clearAllHiddenClasses();
                    this.userInfoDiv.classList.remove("hidden-mypage");
                }
                break;

            case 'order':
                if (this.orderListDiv.classList.contains("hidden-mypage")) {
                    this.clearAllHiddenClasses();
                    this.orderListDiv.classList.remove("hidden-mypage");
                }
                break;

            case 'password':
                if (this.passwordChangeDiv.classList.contains("hidden-mypage")) {
                    this.clearAllHiddenClasses();
                    this.passwordChangeDiv.classList.remove("hidden-mypage");
                }
                break;

            case 'address':
                if (this.addressContentDiv.classList.contains("hidden-mypage")) {
                    this.clearAllHiddenClasses();
                    this.addressContentDiv.classList.remove("hidden-mypage");
                }
                break;
               default:
                console.error(`Unknown content type: ${contentType}`);
                break;
        }
    }

    clearAllHiddenClasses(){
        this.userInfoDiv.className += " hidden-mypage";
        this.orderListDiv.className += " hidden-mypage";
        this.passwordChangeDiv.className += " hidden-mypage";
        this.addressContentDiv.className += " hidden-mypage";
    }
}