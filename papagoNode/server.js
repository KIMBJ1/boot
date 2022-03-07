const express = require("express"); // package.json의 "dependencies" "express" package import

const app = express();

// API Key를 별도 관리 : dot(.)env 활용, .env 파일에 key 보관하고 dotenv가 .env 파일을 활용해서 process.env 객체에 포함 : 민감정보 깃허브에 올리지 않음

const dotenv = require('dotenv');
dotenv.config();

const clientId = process.env.CLIENT_ID
const clientSecret = process.env.CLIENT_SECRET

// nodejs 서버가 또 다른 client가 되어 Naver 서버에 요청을 보내기 위해 사용
const request = require('request');
const req = require("express/lib/request");
const res = require("express/lib/response");

// express의 static 미들웨어 활용
app.use(express.static('public'))

// express의 json 미들웨어 활용
app.use(express.json());
console.log(`현재 파일 경로 : ${__filename}`);
console.log(`index.html 파일 경로 : ${__dirname}`);

// root url : localhost:3000 / == localhost:3000
// 해당 경로로 요청이 들어왔을때 호출될 함수
// 두 인자값(argument) : req, res
app.get("/", (req, res) => {
    // root url, 즉 메인 페이지로 접속했을 때 papago의 메인 페이지가 나와야 함
    res.sendFile(__dirname, 'index.html');
});

app.post("/detectLangs", (req, res) =>{
    //'안녕' 이라는 txt를 받아야 함

    console.log(req.body); // '안녕'
    console.log(typeof req.body);

    const {text:query, targetLanguage} = req.body;

    const url = "https://openapi.naver.com/v1/papago/detectLangs";
    const options = {
    url,
    form: { query },
    headers: {
        "X-Naver-Client-Id": clientId,
        "X-Naver-Client-Secret":clientSecret,
    }
}

    // 언어 감지 요청 부분
    // options의 요청에 필요한 데이터 동봉
    // () => {} : 요청에 따른 응답 정보 확인
    request.post(options, (error, response, body) => { 
        if(!error && response.statusCode == 200){
            console.log(body);
            const parsedBody = JSON.parse(body);
            console.log(typeof parsedBody, parsedBody);

            // papago 번역 url로 redirect(재요청)
            res.redirect(`translate?lang=${parsedBody['langCode']}&targetLanguage=${targetLanguage}&query=${query}`)

        }else {
            console.log(`error : ${response.statusCode}`);
        }
    });

})

app.get("/translate", (req, res) => {
    const url = "https://openapi.naver.com/v1/papago/n2mt";
    console.log(req.query, typeof req.query);
    const options = {
        url,
        form: { 
            source: req.query['lang'], // query string으로 받은 값들 mapping (binding)
            target: req.query['targetLanguage'],
            text: req.query['query'],
        },
        headers: {
            "X-Naver-Client-Id": clientId,
            "X-Naver-Client-Secret":clientSecret,
        },
    }

    request.post(options, (error, response, body) => {
        if(!error && response.statusCode == 200){
            console.log(body);
            res.json(body) // front에 해당하는 script.js에 응답 데이터(json) 전송
        }else {
        }
    })

})

app.listen(3000, () => {
    console.log('http://127.0.0.1:3000/ app listening on port 3000!');
    
});