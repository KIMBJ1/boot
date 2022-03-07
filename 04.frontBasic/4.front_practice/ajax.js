/*
Value   |	State   |	Description
0	| UNSENT    |	클라이언트가 생성. open() 아직 호출되지 않음
1	|   OPENED	|   open() 호출
2	|   HEADERS_RECEIVED	|   send() 가 호출되었으며, 헤더 및 상태를 사용 가능
3	|   LOADING |   다운로드 중; responseText는 부분 데이터를 보관
4	|   DONE	|   작업 완료
*/

// XMLHttpRequest 객체 생성, open() 호출 전
const xhr = new XMLHttpRequest(); // vanilla JS 방식(순수 JS 코드만 사용)
console.log(`UNSENT, ${xhr.readyState}`); // 클라이언트가 생성. open() 아직 호출되지 않음

// 요청 보낼 준비
xhr.open("GET", "https://jsonplaceholder.typicode.com/todos/1");
console.log(`OPENED, ${xhr.readyState}`); //open() 호출

// onreadystatechange 이벤트 발생마다 arrow function 호출
xhr.onreadystatechange = () => {
    if (xhr.readyState == 2) { // send() 가 호출되었으며, 헤더 및 상태를 사용 가능
        console.log(`Ready state Loaded, ${xhr.readyState}`);
    }

    // 데이터 응답(로딩) 완료 == onload()
    if (xhr.readyState == 4 && xhr.status == 200) { // 데이터가 성공적으로 응답 완료
        console.log(`DONE, ${xhr.readyState}`);
        console.log(`response data : ${xhr.responseText}`);
    }

}

// 브라우저가 데이터를 받는 동안 주기적으로 발생
xhr.onprogress = () => {
    console.log(`LOADING, ${xhr.readyState}`);

}

// 데이터 응답(로딩) 완료
xhr.onload = () => {
    console.log(`DONE, ${xhr.readyState}`);
}

// 
xhr.send(null);
