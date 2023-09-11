const express = require('express');
const bodyParser = require('body-parser');
const fs = require('fs');

const app = express();

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended:true}));

app.listen(8080,()=>{
    console.log("start book-server");
    console.log("listening...");
});


app.get("/",(req,resp)=>{
    const data = fs.readFileSync('./library.json', 'utf8');
    resp.send(data);   
});

app.get("/b/:bookId",(req,resp)=>{
    const book = {
        bookSeq: "100",
        bookIsbn: "PM0000137904",
        bookTitle: "유창한 영어회화를 꼭 원하는 분. 10 Fluent English",
        bookAuthor: "강성구 지음",
        userId: "user1",
        borrowStart: "2023-08-05",
        borrowEnd: "2023-08-18",
        returnDate: "-"
    }
    resp.send(JSON.stringify(book));
});


app.get("/r/:bookId",(req,resp)=>{
    let data = {result:true}
    resp.send(data);
});