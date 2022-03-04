/*
객체
여러 변수들을 의미 단위로 하나ㅇ로 묶어서 사용할 수 있는 방식 중 하나

JS에서 원시 값(Primitive value)을 제외한 모든 것은 객체
array, function ...

기본적인 차이 : 원시값은 하나의 값만 나타내고
객체는 다양한 타입의 값들을 하나의 단위로 구성ㅇ한 복합 자료구조

원시값은 변경 불가능한 값(Immutable value)
객체는 변경 가능한 값(mutable value)

객체는 프로퍼티(property, 속성)로 구성된 집합,
property : key, value로 구성

JS에서 사용할 수 있는 모든 값은 property값이 될 수 있음
함수는 일급 객체이기 때문에 값이 될 수 있고
따라서 객체의 property가 될 수 있음
property값이 함수일 경우 함수와 구분하기 위해 메서드라고 함

*/
const emptyObject = {}; // 빈 객체 생성
console.log(emptyObject);

//객체 리터럴 방식을 활용한 객체 생성
let dog = {
    dogName : 'toto',
    fruit : 'kiwi',
    bark: function(){
        //this : 객체 자신을 가리키는 참조변수
        console.log(`왈왈 ! ${this.fruit}가 먹고싶어`);
    }
}


console.table(dog);
console.log('property가 함수일 경우 호출은 ()가 있어야 해');
dog.bark();

console.log(`property의 조회(접근) : ${dog.dogName} ${dog['fruit']}`);

console.log(`property의 동적 추가(존재하지 않는 property에 값 추가`);
dog.age = 2;
console.table(dog);

delete dog.age;
console.log(`property 삭제`);
console.table(dog);