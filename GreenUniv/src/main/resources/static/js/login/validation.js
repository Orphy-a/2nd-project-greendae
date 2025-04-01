//유효성 검사에 사용할 정규표현식
const reUid   = /^(?=.*[a-zA-Z])(?=.*[0-9])[a-zA-Z0-9]{4,10}$/;
const rePass  = /^(?=.*[a-zA-z])(?=.*[0-9])(?=.*[$`~!@$!%*#^?&\\(\\)\-_=+]).{5,16}$/;
const reName  = /^[가-힣]{2,10}$/
const reNick  = /^[a-zA-Zㄱ-힣0-9][a-zA-Zㄱ-힣0-9]*$/;
const reEmail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
const reHp    = /^01(?:0|1|[6-9])-(?:\d{4})-\d{4}$/;

document.addEventListener('DOMContentLoaded', function() {

    // 유효성 검사에 사용할 상태 변수
    let isUidOk = false;
    let isPassOk = false;
    let isNameOk = false;
    let isEmailOk = false;
    let isHpOk = false;

    // 1.아이디 유효성 검사(중복체크 포함)
    const btnCheckId = document.getElementById('btnCheckId');
    const idResult = document.getElementsByClassName('idResult')[0];
    const formRegister = document.getElementById("formRegister");

    btnCheckId.onclick = function () {
        const value = formRegister.id.value;
        // 아이디 유효성 검사
        if (!value.match(reUid)) {
            idResult.innerText = '아이디 형식에 맞지 않습니다.';
            idResult.style.color = 'red';
            isUidOk = false;
            return; // 처리 종료
        }

        // 유효성 검사를 통과한 경우에만 중복 체크 실행
        fetch(`/login/register/id/${value}`)
            .then(response => response.json())
            .then((data) => {
                if (data.count > 0) {
                    idResult.innerText = '이미 사용중인 아이디 입니다.';
                    idResult.style.color = 'red';
                    isUidOk = false;
                } else {
                    idResult.innerText = '사용 가능한 아이디 입니다.';
                    idResult.style.color = 'green';
                    isUidOk = true;
                }
            })
            .catch((err) => {
                console.error(err);
                idResult.innerText = '서버와의 통신에 문제가 발생했습니다.';
                idResult.style.color = 'red';
                isUidOk = false;
            });
    }

    // 2.비밀번호 유효성 검사
    const passResult = document.getElementsByClassName('passResult')[0];

    formRegister.password2.addEventListener('focusout', function () {

        const value1 = formRegister.password.value;
        const value2 = formRegister.password2.value;

        if (!value1.match(rePass)) {
            passResult.innerText = '비밀번호는 숫자, 소문자, 대문자, 특수문자 조합 8자리';
            passResult.style.color = 'red';
            isPassOk = false;
            return;
        }

        if (value1 === value2) {
            passResult.innerText = '사용 가능한 비밀번호 입니다.';
            passResult.style.color = 'green';
            isPassOk = true;
        } else {
            passResult.innerText = '비밀번호가 일치하지 않습니다.';
            passResult.style.color = 'red';
            isPassOk = false;
        }
    });


    // 3.이름 유효성 검사
    const nameResult = document.getElementsByClassName('nameResult')[0];

    formRegister.name.addEventListener('focusout', function () {

        const value = this.value;

        if (!value.match(reName)) {
            nameResult.innerText = '이름이 유효하지 않습니다.';
            nameResult.style.color = 'red';
            isNameOk = false;
        } else {
            nameResult.innerText = '';
            isNameOk = true;
        }
    });


    // 이메일 유효성 검사(중복체크 포함)
    const email = document.getElementById("email");
    const emailResult = document.getElementsByClassName("emailResult")[0];

    formRegister.email.addEventListener('focusout', function () {
        const value = formRegister.email.value;

        // 이메일 유효성 검사
        if (!value.match(reEmail)) {
            emailResult.innerText = '이메일 형식에 맞지 않습니다.';
            emailResult.style.color = 'red';
            isEmailOk = false;
            return; // 처리 종료
        }

        // 유효성 검사를 통과한 경우에만 중복 체크 실행
        fetch(`/login/register/email/${value}`)
            .then(response => response.json())
            .then((data) => {
                if (data.count > 0) {
                    emailResult.innerText = '이미 사용중인 이메일 입니다.';
                    emailResult.style.color = 'red';
                    isEmailOk = false;
                } else {
                    emailResult.innerText = '사용 가능한 이메일 입니다.';
                    emailResult.style.color = 'green';
                    isEmailOk = true;
                }
            })
            .catch((err) => {
                console.error(err);
                emailResult.innerText = '서버와의 통신에 문제가 발생했습니다.';
                emailResult.style.color = 'red';
                isEmailOk = false;
            });
    }); // formRegister.email.addEventListener 끝



    // 6.휴대폰 유효성 검사(중복체크 포함)
    const contactResult = document.getElementsByClassName('contactResult')[0];

    formRegister.contact.addEventListener('focusout', async function(){

        const value = this.value;

        if(!value.match(reHp)){
            contactResult.innerText = '휴대폰번호가 유효하지 않습니다.(- 포함)';
            contactResult.style.color = 'red';
            isHpOk = false;
            return;
        }
        /*
            // 휴대폰 중복체크
            const response = await fetch(`/login/register/contact/${value}`);
            const data = await response.json();

            if(data.count > 0){
                contactResult.innerText = '이미 사용중인 휴대폰번호 입니다.';
                contactResult.style.color = 'red';
                isHpOk = false;
            }else{
                contactResult.innerText = '사용 가능한 휴대폰번호 입니다.';
                contactResult.style.color = 'green';
                isHpOk = true;
            }
*/
        // 유효성 검사를 통과한 경우에만 중복 체크 실행
        fetch(`/login/register/contact/${value}`)
            .then(response => response.json())
            .then((data) => {
                if (data.count > 0) {
                    contactResult.innerText = '이미 사용중인 전화번호 입니다.';
                    contactResult.style.color = 'red';
                    isHpOk = false;
                } else {
                    contactResult.innerText = '사용 가능한 전화번호 입니다.';
                    contactResult.style.color = 'green';
                    isHpOk = true;
                }
            })
            .catch((err) => {
                console.error(err);
                contactResult.innerText = '서버와의 통신에 문제가 발생했습니다.';
                contactResult.style.color = 'red';
                isHpOk = false;
            });
    });


    // 최종 폼 전송 이벤트
    formRegister.onsubmit = function(e){
        console.log("form submit!!!")

        // 1) 아이디 유효성 검사 결과
        if(!isUidOk){
            return false; // 폼 전송 취소
        }

        // 2) 비밀번호 유효성 검사 결과
        if(!isPassOk){
            return false;
        }

        // 3) 이름 유효성 검사 결과
        if(!isNameOk){
            return false;
        }

        // 4) 이메일 유효성 검사 결과
        if(!isEmailOk){
            return false;
        }

        // 5) 휴대폰 유효성 검사 결과
        if(!isHpOk){
            return false;
        }

        return true; // 폼 전송 시작
    }; // 최종 폼 전송 이벤트 끝



    // 버튼 활성화 이벤트
    const submitButton = formRegister.querySelector(".register-btn");

    // 주소 관련 input 제외한 필수 입력 필드 선택
    const requiredInputs = Array.from(formRegister.querySelectorAll("input")).filter(input =>
        !["zip", "address", "address_detail"].includes(input.name) &&
        input.type !== "hidden" &&
        input.name !== "password2"
    );

    // 입력값 검증 함수
    function validateInputs() {
        const allFilled = requiredInputs.every(input => input.value.trim() !== "");

        if (allFilled) {
            submitButton.disabled = false;
            submitButton.style.backgroundColor = "#3f97f6";
            submitButton.style.cursor = "pointer";
        } else {
            submitButton.disabled = true;
            submitButton.style.backgroundColor = "gray";
            submitButton.style.cursor = "none";
        }
    }

    // 모든 필수 input에 이벤트 리스너 추가
    requiredInputs.forEach(input => {
        input.addEventListener("input", validateInputs);
    });

    // 폼 제출 이벤트 핸들러 추가
    formRegister.addEventListener("submit", (e) => {
        if (submitButton.disabled) {
            e.preventDefault(); // 비활성화 상태일 때 제출 방지
            alert("필수 항목을 모두 입력해주세요!");
        }
        // 활성화 상태면 기본 동작(폼 제출) 실행
    });

    // 초기 상태 설정
    validateInputs();


});