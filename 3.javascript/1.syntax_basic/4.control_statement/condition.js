const shoppingDone = false; //쇼핑 끝나지 않음
let childAllowance; //내 용돈

if (shoppingDone == true) { //쇼핑을 도와주면 용돈 추가
    childAllowance = 10;
} else {
    childAllowance = 5;
}
console.log(`내 용돈은 ${childAllowance}`);

const select = document.querySelector('select'); //select tag를 js코드로 가지고 왔다
// console.log(select);

const paragraph = document.querySelector('p'); // p tag를 js 코드로 가지고 왔다.
console.log(paragraph);

function setResult() {
    // console.log(select.value);
    const choice = select.value;

    if (choice === 'one') {
        paragraph.textContent = '올ㅋ';
    } else if (choice === 'two') {
        paragraph.textContent = '꿀꿀꿀~';
    } else if (choice === 'random') {
        paragraph.textContent = '안 돼';
    } else {
        paragraph.textContent = '다른걸 눌러 ㅡㅡ';
    }
}

select.addEventListener('change', setResult); // select tag에 change 이벤트가 발생(선택지를 고르면)한 것을 확인(listen)하면 setResult 함수 호출