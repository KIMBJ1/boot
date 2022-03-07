/**
 * 배열 메서드의 반환 패턴
 * 
 * 1. 원본에 직접적인 수정(mutator method).
 * 2. 원본은 변경없이 새로운 값 생성하여 반환(accessor method)
 * 
 */

/*
Accessor method
*/
// concat() : concatenation, 두 개 이상의 배열을 합쳐서 새로운 배열 반환

console.group('concat()');//console.group : f12창에 그룹으로 묶음
//원본 배열 생성
const disney = ['micky', 'mini', 'stitch', 'donald_duck'];
const ghibli = ['howl', 'totoro', 'mononoke', 'kiki'];
//concat
const animations = disney.concat(ghibli);
console.log(animations);
// 원본 배열 변함 없음
console.log(`원본 disney : ${disney}`);
console.log(`원본 ghibli : ${ghibli}`);
console.groupEnd();

// join() : 모든 배열 요소를 string으로 변환
console.group('join()');
let fish = ['shark', 'whale', 'koi', 'nemo', 'defense'];
const fishString = fish.join() //join() 내부에 parameter를 지정하지 않으면 ,comma 기준으로 합쳐집
console.log(typeof fishString, fishString);
console.log(fish);
console.groupEnd();

// slice() : 일부 요소를 잘라서 새로운 요소로 반환
console.group('slice()');
console.log(fish);
let slicedFishArr = fish.slice(2); //index2부터 끝까지
console.log(slicedFishArr);
slicedFishArr = fish.slice(2, 4);
console.log(slicedFishArr);
console.groupEnd();

// indexOf() : 배열에서 찾으려는 요소의 가장 처음 인덱스 위치 반환 (요소가 중복되어 있어도 처음거만 찾아줘)
console.group('indexOf()');
fish = ['shark', 'whale', 'koi', 'whale', 'nemo'];
console.log(fish);
console.log(`fish array에서 'whale'의 첫 인덱스 위치 : ${fish.indexOf('whale')}`);
console.log(`찾으려는 요소가 없으면 : ${fish.indexOf('lion')}`);
console.groupEnd();

// lastIndexOf() 배열에서 찾으려는 요소의 가장 마지막 인덱스 요소 반환
console.group('lastIndexOf()');
console.log(`fish array에서 'whale'의 마지막 인덱스 위치 : ${fish.lastIndexOf('whale')}`);
console.log(`찾으려는 요소가 없으면 : ${fish.lastIndexOf('lion')}`);
console.groupEnd();