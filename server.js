const express = require("express"); // package.json의 "dependencies" "express" package import

const app = express();

// API Key를 별도 관리 : dot(.)env 활용, .env 파일에 key 보관하고 dotenv가 .env 파일을 활용해서 process.env 객체에 포함 : 민감정보 깃허브에 올리지 않음

const dotenv = require('dotenv');
dotenv.config();

const clientId = process.env.CLIENT_ID
const clientSecret = process.env.CLIENT_SECRET

// nodejs 서버가 또 다른 client가 되어 Naver 서버에 요청을 보내기 위해 사용
const request = require('request');

// express의 sttic 미들웨어 활용
app.use(express.static('public'))