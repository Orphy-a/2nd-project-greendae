document.addEventListener("DOMContentLoaded", function () {

    const slides=[
        {
            text:[
                "IT기술로 세상을 변화시키는 인재를 양성",
                "그린대학교 컴퓨터과학과",
                "급변하는 컴퓨터 기술의 발전에 선도적으로 참여하고 컴퓨터의 활용을 통해 미래를 만들어 나갈 수 있는 인력을 배양"
            ],
            link: "/university/naturalScience",
            background: "/images/bg-main-vi01.jpg"
        },
        {
            text:[
                "기계기술로 세상 변화 시키는 인재 양성",
                "그린대학교 기계공학과",
                "기계 미래를 이끌어갈 인재 양성"
            ],
            link: "/university/engineering",
            background: "/images/bg-main-vi02.jpg"
        },
        {
            text:[
                "교육을 이끌어갈 사범대학!",
                "그린대학교 사범대학부",
                "급변하는 교육의 발전에 도모하며 이끌어갈 인재 양성"
            ],
            link: "/university/education",
            background: "/images/bg-main-vi03.jpg"
        }
    ];
    let currentIndex = 0;
    const mainBackground = document.querySelector(".main_background");
    const textElements= mainBackground.querySelectorAll("p");
    const linkElement = mainBackground.querySelector("a");
    const indicators = document.querySelectorAll(".main_background > div > div:nth-of-type(2) div");
    const arrow = document.querySelector(".arrow");

    function  updateSlide(){

        if (!slides[currentIndex]) return;

        const slide = slides[currentIndex];
        mainBackground.style.backgroundImage = `url('${slides[currentIndex].background}')`;

        textElements.forEach((p, index) =>{
            if (slide.text[index]) {
                p.textContent = slide.text[index];
            }
        });

        linkElement.href = slide.link;

        indicators.forEach((indicators, index) => {
            indicators.style.backgroundColor = index === currentIndex ? "#ffffff" : "transparent";
        });
    }

    function nextSlide(){
        currentIndex = (currentIndex + 1 ) % slides.length;
        updateSlide();
    }

    function goToSlide(index){
        if (index < 0 || index >= slides.length) return;
        currentIndex = index;
        updateSlide();
    }

    arrow.addEventListener("click" , nextSlide);

    indicators.forEach((indicators, index) =>{
        indicators.addEventListener("click", ()=> goToSlide(index));
    });

    updateSlide();
    setInterval(nextSlide, 10000);
});