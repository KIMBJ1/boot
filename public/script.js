/* 변수 네이밍 컨벤션, 도메인과 관련된 용어 정의
source : 번역할 txt 관련 명칭
target : 번역 결과 관련 명칭
*/

// ------- textarea
const textAreaArray = document.querySelectorAll("textarea");
console.log(textAreaArray);

const [sourceTextArea, targetTextArea] = textAreaArray;
console.log(sourceTextArea);
console.log(targetTextArea);

// ------- select
const [sourceSelect, targetSelect] = document.querySelectorAll("select");

// ------- 번역할 언어의 타입(ko? en? ja?)
let targetLanguage = "en"; // 기본적으로 영어로 번역
targetSelect.addEventListener("change", () => {
    const selectedIndex = targetSelect.selectedIndex;
    targetLanguage = targetSelect.options[selectedIndex].value;

    console.log(
    `${selectedIndex}, ${targetLanguage}`,
    targetSelect.options[selectedIndex]
    );
}); // 어던 언어로 번역할지 선택하는 target selectbox의 선택자 값이 바뀔 때마다 이벤트 발생

let debouncer;

// -------
sourceTextArea.addEventListener("input", (event) => {
    if (debouncer) {
    //값이 있으면 true, 없으면 false
    clearTimeout(debouncer);
    }
    debouncer = setTimeout(() => {
    // // 어떤 이벤트? / textarea에 입력한 값 어떻게 가져와?
    // console.dir(event); //sourceTextArea에 글자 입력하면 이벤트 발생
    const text = event.target.value;
    console.log(text);

        if(text) {
            const xhr = new XMLHttpRequest();
        const url = "/detectLangs"; // node 서버의 특정 url 주소

        xhr.onreadystatechange = () => {
            if (xhr.readyState == 4 && xhr.status == 200) {
            // 데이터가 성공적으로 응답 완료
            // 서버의 응답 결과 확인 (responseText : 응답에 포함된 txt)
            console.log(
                `xhr.responseText : ${
                xhr.responseText
                }, type : ${typeof xhr.responseText}`
            );
            const responseData = xhr.responseText;
            console.log(
                `responseData : ${responseData}, type : ${typeof responseData}`
            );
            // 두 번 파싱
            const parseJsonToObject = JSON.parse(JSON.parse(responseData));

            console.log(typeof parseJsonToObject, parseJsonToObject);
            const result = parseJsonToObject["message"]["result"];

            const options = sourceSelect.options;
            for (let i = 0; i < options.length; i++) {
                if (options[i].value === result['srcLangType']) {
                    sourceSelect.selectedIndex = i;
                }
            }

            // 번역된 결과 텍스트를 결과화면에 입력
            targetTextArea.value = result["translatedText"];

            // console.log(res.length);
            // console.log(res[5]);

            // console.log(`응답 헤더 : ${xhr.getAllResponseHeaders()}`);
            }
        };

/**
 * 
xhr.addEventListener('load', () => {
    // 로딩이 완료되면 실행
    if(xhr.status == 200) {
        
    }
})
 */


        xhr.open("POST", url);
        // 서버에 보내는 요청 데이터 형식이 json 형식임을 명시
        xhr.setRequestHeader("Content-type", "application/json");

        const requestData = {
            text,
            targetLanguage,
        };

        // JSON 타입 string, 서버에 보낼 데이터를 문자열화 시킴
        jsonToString = JSON.stringify(requestData);
        console.log(typeof jsonToString);

        xhr.send(jsonToString);
    } else {
        console.log("txt를 입력하세요");
    }}, 3000); // 3000 : 3초


});
