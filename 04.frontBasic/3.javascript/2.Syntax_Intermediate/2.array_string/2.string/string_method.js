/**
 * Indexing / Splitting / Manipulating String
 */

// string을 생성하는 법
const stringPrimitive = 'A new string';
const stringObject = new String('A new string');

console.log(`${typeof stringPrimitive}, ${typeof stringObject}`);

const aString = 'How are you?';
console.log(aString);
console.log('0123456789');
console.log(aString[4]);
console.log(aString.charAt(5)); // 지정한 인덱스 값 조회 get the char at 5
console.log(aString.indexOf('o'));
console.log(aString.lastIndexOf('o'));
console.log(aString.slice(8, 11));
console.log(aString.length);

//Splitting strings
const originalString = 'Loning Rusted Seventeen Daybreak Frunace Nine Benign Homecoming One FreightCar';
const splitString = originalString.split(" ") //공백(whitespace character) split
console.log(splitString);
console.log(`splitString은 배열인가? ${Array.isArray(splitString)}`); //Array.isArray(), static method
console.log(`splitString[4] : ${splitString[4]}`);

//Finding &nd Replacing String value
const newString = originalString.replace('Loning', 'Winter')//Replace the 1st instance of "Loning" with "Winter"
console.log(newString);