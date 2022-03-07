document.getElementById('bookName').addEventListener('search', () => {
    const bookName = document.getElementById('bookName').value;

    const xhr = new XMLHttpRequest();

    const url = '/search/book';

    xhr.onreadystatechange = () => {
        if (xhr.readyState == 4 && xhr.status == 200) {
            const res = xhr.responseText;
            // parsedResult : API에서 받아온 결과값(res)을 JSON으로 파싱
            const parsedResult = JSON.parse(res);

                document.getElementById('table').textContent = ''; // 요청마다 table 초기화

                // 테이블 작성
                let table = document.createElement('table');
                let thead = document.createElement('thead');
                let tbody = document.createElement('tbody');
                
                table.appendChild(thead);
                table.appendChild(tbody);
                
                // js에서 테이블 생성 by #table
                document.getElementById('table').appendChild(table);
                
                // 테이블 헤ㅔ더 생성 
                let row_head = document.createElement('tr');
                let heading_1 = document.createElement('th');
                heading_1.innerHTML = "title";
                let heading_2 = document.createElement('th');
                heading_2.innerHTML = "image";
                let heading_3 = document.createElement('th');
                heading_3.innerHTML = "author";
                let heading_4 = document.createElement('th');
                heading_4.innerHTML = "link";
                let heading_5 = document.createElement('th');
                heading_5.innerHTML = "price";
                let heading_6 = document.createElement('th');
                heading_6.innerHTML = "duscount";
                let heading_7 = document.createElement('th');
                heading_7.innerHTML = "publisher";
                
                row_head.appendChild(heading_1);
                row_head.appendChild(heading_2);
                row_head.appendChild(heading_3);
                row_head.appendChild(heading_4);
                row_head.appendChild(heading_5);
                row_head.appendChild(heading_6);
                row_head.appendChild(heading_7);
                thead.appendChild(row_head);
                
                for(index = 0; index < 10; index++) {
                    const bookIndex = 'bookResult' + index;
                    const bookResult = document.getElementById(bookIndex);
                    const br = `검색 결과 :${parsedResult.items[index].title}, ${parsedResult.items[index].author},${parsedResult.items[index].link}`;
                
                // 파싱 데이터를 테이블에 출력
                let row_body = document.createElement('tr');
                let row_body_data_1 = document.createElement('td');
                row_body_data_1.innerHTML = parsedResult.items[index].title;
                let row_body_data_2 = document.createElement('td');
                row_body_data_2.innerHTML = `<img src=\"${parsedResult.items[index].image}\">`;
                let row_body_data_3 = document.createElement('td');
                row_body_data_3.innerHTML = parsedResult.items[index].author;
                let row_body_data_4 = document.createElement('td');
                row_body_data_4.innerHTML = `<a href=\"${parsedResult.items[index].link}\" target="blank">상세 보기</a>`;
                let row_body_data_5 = document.createElement('td');
                row_body_data_5.innerHTML = parsedResult.items[index].price;
                let row_body_data_6 = document.createElement('td');
                row_body_data_6.innerHTML = parsedResult.items[index].discount;
                let row_body_data_7 = document.createElement('td');
                row_body_data_7.innerHTML = parsedResult.items[index].publisher;
                
                row_body.appendChild(row_body_data_1);
                row_body.appendChild(row_body_data_2);
                row_body.appendChild(row_body_data_3);
                row_body.appendChild(row_body_data_4);
                row_body.appendChild(row_body_data_5);
                row_body.appendChild(row_body_data_6);
                row_body.appendChild(row_body_data_7);
                tbody.appendChild(row_body);
                
                }



            
        }
    };

    xhr.open("POST", url);

    xhr.setRequestHeader("Content-type", "application/json");

    const requestData = {
        bookName,
    };

    // object -> string
    jsonToString = JSON.stringify(requestData);

    xhr.send(jsonToString);

})
