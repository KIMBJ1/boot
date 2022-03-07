// callback function 기본

function greeting(a) {
    console.log(`Hello ${a}`);
}

//함수 선언부에 작성하는 값은 인자값
function processUserInput(a, callback) { //인자값arguments
    callback(name);
}

// 함수의 호출부에 작성하는 값들을 parameter라고 함
processUserInput('KIM', greeting); //동기 콜백 synchronous callback
greeting('KIM');


function coupang(package, callback){
    console.log(`쿠팡에서 ${package} 도착`);
    callback(package);
}

function eating(){
    console.log(`냠냠`);
}
coupang('apple', eating);

const button = document.querySelector('button');

console.log(button);

// button.addEventListener('click', function(){
//     console.log('button clicked');
// });
button.addEventListener('click', () => console.log('button clicked'));