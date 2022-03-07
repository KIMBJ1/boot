/**
 * Destructuring
 * Destructuring assignment(분해 할당)은 객체의 property나 배열을 변수로 분해해주는 것을 의미함 -> 코드를 간결하게
 * 
 * 1. Object Destructuring
 * 2. Array Destructuring
 * 
 */

/*
1. Object Destructuring
*/
const book = {
    id: 1,
    title: 'The great Gatsby',
    pubDate: '10/04/1925',
};

// const bookId = book.id; // 기존 방식
// const bookTitle = book.title;
// const bookPubDate = book.pubDate;

const { id, title, pubDate } = book; // Object Destructuring : 변수는 객체의 property명과 동일한 이름으로 작성, Destructuring은 원본 객체 수정 없음
console.log(id);
console.log(title);
console.log(pubDate);

const { id:bookId, title:bookTitle, pubDate:bookPubDate} = book; // 다른 이름으로 저장하고 싶을 때
console.log(bookId, bookTitle, bookPubDate);

/*
2. Array Destructuring
*/
const date = ['1970', '12', '01'];
// const year = date[0];// 기존 방식, JS array는 순서를 보장받아야 하므로 인덱싱 활용

const [year, month, day] = date;//Array Destructuring
console.log(year, month, day);