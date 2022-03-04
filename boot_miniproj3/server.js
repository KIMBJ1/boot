// import express
const express = require("express");

const app = express();

const dotenv = require('dotenv');
dotenv.config();

const clientId = process.env.CLIENT_ID
const clientSecret = process.env.CLIENT_SECRET

app.use(express.static('public'))

app.use(express.json());

// 첫 화면을 index.html로 설정
app.get("/", (req, res) => {
    res.sendFile(__dirname, 'index.html');
})

app.post('/search/book', (req, res) => {
    const { bookName: query} = req.body;
    console.log(query);

    const api_url = 'https://openapi.naver.com/v1/search/book?query=' + encodeURI(query);
    console.log(api_url);

    const request = require('request');
    const options = {
        url: api_url,
        headers: {
            'X-Naver-Client-Id':clientId, 
            'X-Naver-Client-Secret': clientSecret
        }
    };

    request.get(options, (error, response, body) => {
        if (!error && response.statusCode == 200) {
        res.writeHead(200, {'Content-Type': 'text/json;charset=utf-8'});
        res.end(body);
        } else {
        res.status(response.statusCode).end();
        console.log('error = ' + response.statusCode);
        }
    });
});

app.listen(3000, () => {
    console.log('http://127.0.0.1:3000/ app listening on port 3000!');
});