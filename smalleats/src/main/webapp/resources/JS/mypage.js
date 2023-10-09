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
        this.userInfoBtn = document.querySelector('.user-info-btn');

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
        userInfoBtn.onclick= () => { showContent('user'); };

        // 주문 조회 버튼 클릭 시
        orderListBtn.onclick= () => { showContent('order'); };

        // 비밀번호 변경 버튼 클릭 시
        passwordListBtn.onclick= () => { showContent('password'); };

        // 주소 변경 버튼 클릭 시
        addressContentBtn.onclick= () => { showContent('address'); };
    }

    showContent(contentType) {

        switch (contentType) {

            case 'user':
                if (userInfoDiv.classList.contains("hiden-mypage")) {
                    clearAllHiddenClasses();
                    userInfoDiv.classList.remove("hiden-mypage");
                }
                break;

            case 'order':
                if (orderListDiv.classList.contains("hiden-mypage")) {
                    clearAllHiddenClasses();
                    orderListDiv.classList.remove("hiden-mypage");
                }
                break;

            case 'password':
                if (passwordChangeDiv.classList.contains("hiden-mypage")) {
                    clearAllHiddenClasses();
                    passwordChangeDiv.classList.remove("hiden-mypage");
                }
                break;

            case 'address':
                if (addressContentDiv.classList.contains("hiden-mypage")) {
                    clearAllHiddenClasses();
                    addressContentDiv.classList.remove("hiden-mypage");
                }
                break;

            default:
                console.error(`Unknown content type: ${contentType}`);
                break;
        }
    }

    clearAllHiddenClasses(){
        userInfoDiv.className += " hiden-mypage";
        orderListDiv.className += " hiden-mypage";
        passwordChangeDiv.className += " hiden-mypage";
        addressContentDiv.className += " hiden-mypage";
    }
}