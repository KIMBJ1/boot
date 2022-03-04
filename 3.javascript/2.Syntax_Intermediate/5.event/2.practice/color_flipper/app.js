
const btn = document.querySelector('#btn');
const color = document.querySelector('.color');


btn.addEventListener("click", () => {
    // console.log('button clicked') // addEventListener로 btn을 click했을때 button clicked 출력
    const [r, g, b] = getRandomNumber(0, 255);
    // console.log(r, g, b);
    const rgbColor = `rgba(${r}, ${g}, ${b})`;
    document.body.style.background = rgbColor;
    color.textContent = rgbColor;
    color.style.color = rgbColor;
});

//랜덤 rgb값 추출 함수
function getRandomNumber(min, max) {
    let randomRGBArray = [];

    for (let i = 0; i < 3; i++) {
        let randomNumber = Math.floor(Math.random() * (max - min + 1)) + min; //min max사이 난수 생성
        randomRGBArray.push(randomNumber)
    }
    // console.log(randomRGBArray);
    return randomRGBArray;
}
