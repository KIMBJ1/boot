/**
 * 
 * ...(spread syntax)
 * 하나로 뭉쳐있는 여러 값들의 집합을 펼쳐서(전개, 분산) 개별적인 값들의 목록으로 바꿈
 * 
 * spread 문법의 사용 가능 대상은 Array, Map, String, Set, DOM Collection 등으로 한정
 */

/* 1. spread with Array */
// 배열 연결
const fruits = ['apple', 'banana'];
const otherFruits = ['kiwi', 'grape'];

const allFruits = fruits.concat(otherFruits) // 기존 방식
console.table(allFruits);

const MyFruits =  [...fruits, ...otherFruits]; // spread
console.table(MyFruits);

//배열에 새로운 객체 추가
const users = [
    { id: 1, userName: 'asdf' },
    { id: 2, userName: 'qwer' },
];

const newUser = { id: 3, userName: 'zxcv' }; // 기존 방식
users.push(newUser);

const secondUser =  { id: 4, userName: 'dyhj' }; // spread
const updateUsers = [...users, secondUser];
console.table(updateUsers);