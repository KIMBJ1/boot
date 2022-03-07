import {sum, sub, mul, div} from './function.js'; // ./ : 현재 경로

// console.log(sum(1, 2)); // 함수 동작 확인

const x = 18;
const y = 9;

document.getElementById('x').textContent = x;
document.getElementById('y').textContent = y;

document.getElementById('add').textContent = sum(x, y);
document.getElementById('sub').textContent = sub(x, y);
document.getElementById('mul').textContent = mul(x, y);
document.getElementById('div').textContent = div(x, y);

import{ num as number, str, obj, array } from './function.js';
console.log(number);
console.log(str, obj, array);