// EventHandler property way : HTML과 js를 분리
const evPropButton = document.querySelector('#btn-ev-prop');
// console.log(evPropButton); //잘 가지고 왔는지 확인용
// js에서 함수는 일급객체이므로 객체는 값이고 값은 property에 할당 가능
evPropButton.onclick = function(){ // 익명함수를 만들고 onClick property에 할당, onclick 소문자
    console.log('by event property');
}
//하나의 이벤트만 등록 가능함
evPropButton.onclick = ()=> console.log('새롭게 등록된 EventHandler');

// addEventListener - EventHandler property에 영향 미치지 않으므로 등록한 모든 이벤트가 호출됨, on 생략
const addEvLsnrButton = document.querySelector('#btn-add-ev-lsnr');

// 함수 선언문 방식으로 작성
function buttonHandler(){
    console.log('double clicked!');
    console.log('by addEventListener with 함수 선언문');
}
addEvLsnrButton.addEventListener("dblclick",buttonHandler); // callback 함수, dblclick 더블 클릭

//화살표 함수로 작성
const addEvLsnrButton2 = document.querySelector('#btn-add-ev-lsnr2');
addEvLsnrButton2.dblclick = () => {console.log('화살표 함수로 addEventListener');};
addEvLsnrButton2.addEventListener("dblclick",addEvLsnrButton2.dblclick);

//마우스를 버튼 위로 올리면 발생
const addEvLsnrButton3 = document.querySelector('#btn-add-ev-lsnr3');
addEvLsnrButton3.mouseenter = () => console.log('마우스를 올리면 발생!');
addEvLsnrButton3.addEventListener("mouseenter",addEvLsnrButton3.mouseenter);

// Arrow function을 Callback function parameter에 직접 작성
const addEvLsnrButton4 = document.querySelector('#btn-add-ev-lsnr4')
addEvLsnrButton4.addEventListener("mouseenter", () => console.log('Arrow function을 Callback function parameter에 직접 작성'));


/*eventHandler의 제거
1. EventHandler attribute way : onclick attribute 코드 제거
2. EventHandler property way : 해당 property에 null값 할당
console.log(evPropButton.onclick); 하면 ()=> console.log('새롭게 등록된 EventHandler')
    evPropButton.onclick = null;
    console.log(evPropButton.onclick); 하면 null
3. addEventListener way
addEvLsnrButton.removeEventListener('dblclick', buttonHandler);
addEvLsnrButton2.removeEventListener('dblclick', addEvLsnrButton2.dblclick);
addEvLsnrButton3.removeEventListener('mouseenter', addEvLsnrButton3.mouseenter);
addEvLsnrButton4는 익명함수라 제거 못 함
*/
