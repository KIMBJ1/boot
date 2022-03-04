console.log('산술 연산자');
console.log(`5 + 5 : ${5+5}`);
console.log(`5 - 10 : ${5 - 10}`);
console.log(`5 / 2 : ${5 / 2}`);
console.log(`5 * 4 : ${5 * 4}`);
console.log(`5 % 2 : ${5 % 2}`);
console.log(`5 ** 3 : ${5 ** 3}`);

console.log('증감 연산자');
let age = 5;
console.log('초기 age값 5');

console.log('후위 연산: 실행 종료 후 연산');
console.log(`age++ : ${age++}`);
console.log(`age : ${age}`);

console.log('전위 연산:연산 먼저 하고 코드 실행');
console.log(`++age : ${++age}`);
console.log(`--age++ : ${--age}`);

console.log('관계 연산자');
console.log(`age > 4 : ${age > 4}`);
console.log(`3 > 4 : ${3 > 4}`);

console.log('동등 연산자');
console.log(`1 == '1' : ${1 == '1'}, 타입이 다르면 암묵적으로(impplicit) 변환하여 비교`);
console.log(`1 === '1' : ${1 === '1'}, 엄격한 비교(strict mode)`);

console.log('논리 연산자');
console.log(`true && true : ${true && true}`);
console.log(`5 > 3 && 2 === 2 : ${5 > 3 && 2 === 2}`);
console.log(`5 > 3 || 2 !== 2 : ${5 > 3 || 2 !== 2}`);

console.log('삼항 연산자');
const yourAge = 28;
// const beverage = yourAge >= 20 ? 'Soju' : 'juice';
const beverage = (yourAge >= 20) ? 'Soju' : 'juice';
console.log(beverage);

console.log('할당 연산자 : 우선순위가 거의 아래,  변수에 값을 할당 assignment할 때 사용');
let myAge = 1;
console.log(myAge);