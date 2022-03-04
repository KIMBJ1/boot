/**
 * Modular Programming
 * 
 * 코드를 여러 파일로 쪼개서 모듈화 시키는 방식
 * 관계있는 기능, 파일끼리 서로 module의 형태로 불러와서 필요한 코드만 사용
 * 
 * ES6(ECMA2015)에서 모듈화를 할 수 있는 import export 키워드 사용
 */

export function sum(x, y) {
    return x + y;
}

export function sub(x, y) {
    return x - y;
}

export function mul(x, y) {
    return x *y;
}

export function div(x, y) {
    return x / y;
}

//Primitive values
export const num = 100;
export const str = 'string';
const obj = {name: 'Homer'};
const array = ['Bart', 'Lisa', 'Maggie'];

export{obj, array}