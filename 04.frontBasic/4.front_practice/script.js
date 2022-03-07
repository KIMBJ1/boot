/* 변수 네이밍 컨벤션, 도메인과 관련된 용어 정의
source : 번역할 txt 관련 명칭
target : 번역 결과 관련 명칭
*/

// ------- textarea
const textAreaArray = document.querySelectorAll('textarea');
console.log(textAreaArray);

const [sourceTextArea, targetTextArea] = textAreaArray;
console.log(sourceTextArea);
console.log(targetTextArea);

// ------- select
const[sourceSelect, targetSelect] = document.querySelectorAll('select');

// ------- 번역할 언어의 타입(ko? en? ja?)
let targetLanguage = 'en'; // 기본적으로 영어로 번역
targetSelect.addEventListener('change', () => {
    const selectedIndex = targetSelect.selectedIndex;
    targetLanguage = targetSelect.options[selectedIndex].value;

    console.log(`${selectedIndex}, ${targetLanguage}`, targetSelect.options[selectedIndex]);
}); // 어던 언어로 번역할지 선택하는 target selectbox의 선택자 값이 바뀔 때마다 이벤트 발생

// -------
sourceTextArea.addEventListener('input', (event) => {
    // // 어떤 이벤트? / textarea에 입력한 값 어떻게 가져와?
    // console.dir(event); //sourceTextArea에 글자 입력하면 이벤트 발생
    const text = event.target.value;
    console.log(text);

    const xhr = new XMLHttpRequest();
    const url = 'https://jsonplaceholder.typicode.com/todos/1';

    xhr.onreadystatechange = () => {
        if (xhr.readyState == 4 && xhr.status == 200) { // 데이터가 성공적으로 응답 완료
            console.log(xhr.responseText); // 서버의 응답 결과 확인 (responseText : 응답에 포함된 txt)
            // const res = xhr.responseText;
            // console.log(res.length);
            // console.log(res[5]);

            // console.log(`응답 헤더 : ${xhr.getAllResponseHeaders()}`);


        }
    };

    xhr.open("GET", url);
    xhr.send(null);

});