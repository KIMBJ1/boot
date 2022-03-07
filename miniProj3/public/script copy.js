document.getElementById('bookName').addEventListener('search', () => {
    const bookName = document.getElementById('bookName').value;
    console.log(bookName);

    const xhr = new XMLHttpRequest();

    const url = '/search/book';

    xhr.onreadystatechange = () => {
        if (xhr.readyState == 4 && xhr.status == 200) {
            const res = xhr.responseText;
            console.log(typeof res);
            const parsedResult = JSON.parse(res);
            console.log(parsedResult.items[0].title);

            const books = parsedResult.items;
            console.log(books);

            document.write('<table border="1">');
            for(index = 0; index < 10; index++) {
                const bookIndex = 'bookResult' + index;
                const bookResult = document.getElementById(bookIndex);
                const br = `검색 결과 :${parsedResult.items[index].title}, ${parsedResult.items[index].author},${parsedResult.items[index].link}`;
                // bookResult.textContent = br;
                // console.log(br);





                document.write('<tr>');
                //   for (let j = 0; j < 3; j++)  {
                document.write('<td>');
                document.write(parsedResult.items[index].title);
                document.write('</td>');
                document.write('<td>');
                document.write(parsedResult.items[index].author);
                document.write('</td>');
                document.write('<td>');
                document.write(parsedResult.items[index].link);
                document.write('</td>');
                document.write('<td>');
                document.write(parsedResult.items[index].image);
                document.write('</td>');
                document.write('<td>');
                document.write(parsedResult.items[index].price);
                document.write('</td>');
                //   }
                document.write('</tr>')

                }
            document.write('</table>');
            
        }
    };

    xhr.open("POST", url);

    xhr.setRequestHeader("Content-type", "application/json");

    const requestData = {
        bookName,
    };

    jsonToString = JSON.stringify(requestData);

    xhr.send(jsonToString);

})
