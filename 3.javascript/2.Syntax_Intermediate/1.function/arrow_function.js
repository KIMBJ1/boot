/**
 * Arrow Function
 * 2015년 발표된 ECMAScript Spectation(ES6)는 arrow function 추가
 * 익명함수 표현식을 작성하는 새로운 방법
 * 파이썬의 lambda function과 비슷
 */

// sum이라는 변수에 덧셈 기능을 제공하는 화살표 함수
const sum = (a, b) => a + b;
console.log(sum(2, 3));

/*화살표 함수의 특징
암묵적인 return
기존 함수는 {}도 필요하고 return 키워드도 쓰지만 화삺표 함수는 둘 다 쓰지 않음
*/

// body(함수 몸체) 부분이 2줄 이상일 경우 {} 및 return 추가해야 함
const sub = (a, b) => {
    console.log("뺄셈");
    return a - b;
}
console.log(sub(5, 2));

/**객체를 반환하는 경우
 * body를 ()로 감싸줘야 함
 * {}를 객체 리터럴 기호가 아닌 함수 body block으로 인식하기 때문
 * ()를 쓰지 않으면 block트로 인식함
 * 그래서 ()를 써주면 {}를 객체 리터럴 기호로 인식해서 객체가 반환
 */

// const div = (a, b) => {
//     const result = {
//         res: a / b
//     };
//     return result;
// }
const div = (a, b) => ({ 나누기: a / b });
const res = div(8, 5);
console.log(res);
//이걸 한줄로 하면
console.log(div(7, 4));

// parameter가 하나면 ()생략 가능
const square = x => x * x;
console.log(square(10));

// parameter가 없으면 () 필수
const greet = () => 'hello';
console.log(greet);
console.log(greet());