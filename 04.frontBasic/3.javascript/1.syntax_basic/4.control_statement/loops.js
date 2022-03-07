console.log('기본 반복문 : 고전 방식');
for (let index = 0; index < 5; index++) {
    console.log(`${index} 번 반복`);;
    
}

const rainbow = 'rainbow';
for (let index = 0; index < rainbow.length; index++) {
    console.log(rainbow[index]);
    
}

console.log('배열 반복');
const foods = ['apple', 'orange-cookie', 'avocado', 'plum', 'kiwi'];
let favorite = 'My favorite food is ';
const para = document.querySelector('p');
const len = foods.length
for (let index = 0; index < len; index++) {
    // favorite += foods[index];
    // console.log(favorite)
    // favorite = 'My favorite food is ';

    if (index === len - 1) {
        favorite += ' and ' + foods[index] + '.';
        console.log(favorite);
    } else{
        favorite += foods[index] + ', ';
        console.log(favorite);
    }
    
}

// para.textContent = favorite;

console.log('배열인지 확인 : Array.isArray(foods)');
console.log(`foods가 array인지 확인 : ${Array.isArray(foods)}`);

console.log('forEach()');
const fruits = ['apple', 'banana', 'coconut'];
// fruits.forEach(i => console.log(i));
fruits.forEach(fruit => console.log(fruit));

console.log('for in (enumarable) / for of (iterable)');
let cookie = { //enumarable
    'product_name' : 'HERSHEY',
    'product_vendor' : 'costco',
    'product_id' : 'c1',
};
for(const key in cookie) { //객체의 각 key에 대한 임시 변수를 세팅
    console.log(key + ` : ${cookie[key]}`);
}
const scores = [33, 52, 21, 15, 28]
for (const index of scores) { //iterable
    //iterable 이므로 순서가 있는것만 가져올 수 있음 like 배열
    console.log(index);
}
console.log('ITERABLE 은 for in / for of 다 가능');
for(const item in scores){
    console.log(`in : ${item} : ${scores[item]}`);
}

for(const item of scores){
    console.log(`of : ${item}`);
}