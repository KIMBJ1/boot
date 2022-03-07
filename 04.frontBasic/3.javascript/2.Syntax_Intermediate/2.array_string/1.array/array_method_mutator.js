/**
 * 배열 메서드의 반환 패턴
 * 
 * 1. 원본에 직접적인 수정(mutator method).
 * 2. 원본은 변경없이 새로운 값 생성하여 반환(accessor method)
 * 
 */

/*
Mutator method
*/

let fish = ['piranaa', 'koi', 'nimo', 'clown-fish'];

// fish가 무슨 타입인지 확인
console.group('fish type')
console.log(typeof fish);
console.log(Array.isArray(fish));
console.groupEnd();

// 원본을 직접 수정하는 mutator method

//pop()
console.group('pop()') // 원본 배열의 가장 끝 요소 제거, 해당 값 반환. 추가 parameter는 없음
console.log(fish)
console.log(`제거된 값 : ${fish.pop()}`);
console.log(fish)
console.groupEnd();

// shift()
console.group('shift()') // 원본 배열의 처음 요소 제거
console.log(fish)
console.log(`제거된 값 : ${fish. shift()}`);
console.log(fish)
console.groupEnd();

// push()
console.group('push()') // 원본 배열의 가장 끝에 새로운 요소 추가
console.log(fish)
console.log(`추가된 값 : ${fish. push('clown-fish')}`);
console.log(fish)
console.groupEnd();

// unshift()
console.group('unshift()') // 원본 배열의 가장 앞에 요소 추가
console.log(fish)
console.log(`추가된 값 : ${fish. unshift('shark')}`);
console.log(fish)
console.groupEnd();

// splice()
console.group('splice()') // 정해진 위치에 요쇼를 추가하거나 제거, 추가와 제거 동시에 가능
console.log(`원본`)
console.log(fish)
console.log(`요소 추가`);
console.log(fish.splice(1, 0, 'whale'));// 요소 추가
console.log(fish)
console.log(`요소 제거`);
console.log(fish.splice(1, 2));// 요소 제거, splice(이 index부터, 2개 삭제)
console.log(fish);
fish = ['shark', 'whale', 'koi', 'nimo', 'clown-fish'];
console.log(`원본 : ${fish}`)
console.log(`추가 제거 동시 : ${fish.splice(1, 2, 'sakana')}`);// 추가 제거 동시, splice(이 index부터, 2개 삭제)
console.log(fish)
console.groupEnd();
