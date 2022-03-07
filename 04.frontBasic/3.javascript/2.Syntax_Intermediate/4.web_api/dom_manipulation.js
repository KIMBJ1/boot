console.log(document.querySelector('h1'));
console.log(document.querySelector('#main-title')); // DOM 조작
console.log(document.getElementById('main-title'));
console.dir(document.getElementById('main-title'));
console.dir(document.querySelector('p'))

const h1 = document.querySelector('#main-title'); //h1의 텍스트 바꾸는 property는?

console.log(h1.innerText);

// 여기부터는 dev tool실습
console.log(document.getElementsByClassName('list-item'));

//CSS Select를 통한 조회, 선택자 기호 필수
console.log(document.querySelector('#main-title'));
console.log(document.querySelectorAll('.list-item'));

console.log(document.querySelector('ul li')); // space bar 자손 선택자
console.log(document.querySelector('ul li:last-of-type')); // first-of-type
