/**
 * 변수 키워드의 종류
 * var / let / const
 * 
 * 변수와 상수(Variables &nd Constants)
 * Java와 마찬가지로 변수의 선언(Declaration)과 초기화(Initialization) or 정의(Definition)
 * 
 * 초기화 or 할당(Assignment)
 * 
 */

// 변수 (Variable)
console.log(tiger); //undefined
var tiger; // 변수 호이스팅 때문에 최상단에 등록

/* 호이스팅 된 소스 코드 */
var tiger; 
tiger = 2022;
console.log(tiger);

// let : var의 대체로 사용하는 키워드
// console.log(rabbit); // Error : Cannot access 'rabbit' before initialization
// let rabbit
let rabbit
rabbit = 'rabbit';
console.log(rabbit); // Error : Cannot access 'rabbit' before initialization

// 변수 네이밍 컨벤션(Naming convention) : Camelcase
let userName = 'Kim';
console.log(userName);
// document.write(userName); chrome f12에서 해볼 것
userName = 'Lee';
console.log(userName);

// 상수(Constant)
const allUsers = 20;
console.log(allUsers);

// allUsers = 5; //이미 사용한 상수 키워드 const 변수에는 재할당 불가능
// console.log(allUsers);