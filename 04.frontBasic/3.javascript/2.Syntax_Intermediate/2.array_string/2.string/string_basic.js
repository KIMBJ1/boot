/**
 * string을 사용하는 방식 : '', "", ``(backtick)
 */

// 템플릿 리터럴 방식(Template literal)
const novel = 'The Little Prince';
const author = 'Saint-Exupéry';
console.log(`My favorite novel is ${novel} written by ${author}`);

const address =
    'Homer J.Simson\n' +
    '742 Ecergreen Terrace\n' +
    'Springfield'
console.log(address);
//backtick
const address2 = `Homer J.Simson
742 Ecergreen Terrace
Springfield`
console.log(address2);