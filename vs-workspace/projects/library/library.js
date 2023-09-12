const express = require('express');
const app = express();

const mysql = require("mysql2");

const cors = require('cors');
const bodyParser = require("body-parser");
app.use(bodyParser.json());
app.use(cors({
    origins: "*",
}));
app.use(bodyParser.urlencoded({extended:true}));

//const members = [];
app.listen(8080, () => {
    console.log('start member mysql service~');
    console.log('listening...');

    
    
    // members.push({id:'admin',pwd:'1234',name:'eddy',isAdmin:true});
    // members.push({id:'user1',pwd:'1234',name:'kim',isAdmin:false});
    // members.push({id:'user2',pwd:'1234',name:'lee',isAdmin:false});
})
//Restful API

//readAll
app.get("/", (req, resp) => {
    console.log('in');
    let sql = 'select * from book_info join book_copy on book_info.book_isbn = book_copy.book_isbn';

    const con = mysql.createConnection
    ({
        host: 'localhost',
        user: 'root',
        password: '1234',
        port: '3306',
        database: 'library'
    });

    con.query(sql, (err, rows, fields) => {
        if (err)
            resp.send(err);
        else
            resp.send(rows);
        console.log(rows);
    });
    con.end();
})

//read book_info
app.get("/book_info", (req, res) =>
{
    let sql = 'select * from book_info';

    const con = mysql.createConnection
    ({
        host: 'localhost',
        user: 'root',
        password: '1234',
        port: '3306',
        database: 'library'
    });

    con.query(sql, (err, rows, _) => {
        if (err)
            res.send(err);
        else
            res.send(rows);
        console.log(rows);
    });
    con.end();
})

/* function getData(userId){
     let temp = null;
     let index = -1;
     for(let idx in members){
         if(userId==members[idx].id){
             temp = members[idx];
             index = idx;
             break;
         }
     }
     return [index,temp];
 }*/

//readDetail
app.get("/:id", (req, resp) => {
    let userId = req.params.id;
    const con = mysql.createConnection
    ({
        host: 'localhost',
        user: 'root',
        password: '1234',
        port: '3306',
        database: 'library'
    });

    let sql = 'select * from members where id = "' + userId + '"';
    con.query(sql, (err, rows, fields) => {
        if (err)
            resp.send(err);
        else
            resp.send(rows);
    });
    //const member = getData(userId);
    //console.log(member[0]);
    con.end();
});

//create
app.post("/", (req, resp) => {
    console.log(req.body);
    let isAdmin = 0;
    if(req.body.isAdmin)
        isAdmin = 1;


    const con = mysql.createConnection
    ({
        host: 'localhost',
        user: 'root',
        password: '1234',
        port: '3306',
        database: 'library'
    });

    let sql = 'insert into members values ("' + req.body.id + '", "' + req.body.pwd + '", "' + req.body.name + '", "' + isAdmin + '")';
    con.query(sql, (err, rows, fields) =>
    {
        if(err)
            resp.send(err);
        else
            resp.send(rows);
    });
    //members.push(member);
    con.end();
})

//update
app.put("/:id", (req, resp) => {
    console.log(req.body);
    let userId = req.params.id;
    let { pwd, name, isAdmin } = req.body;

    const con = mysql.createConnection
    ({
        host: 'localhost',
        user: 'root',
        password: '1234',
        port: '3306',
        database: 'library'
    });
    let sql = 'update members set pwd = "' + pwd + '", user_name = "' + name + '", is_admin = ' + isAdmin + ' where id = "' + userId + '"';
    con.query(sql, (err, rows, fields) =>
    {
        if(err)
            resp.send(err);
        else
            resp.send(rows);
    })
    //let data = getData(req.params.id);
    // data[1].name = req.body.name;
    // data[1].pwd = req.body.pwd;
    // data[1].isAdmin = req.body.isAdmin;
    // members[data[0]] = data[1];
    // data = getData(req.params.id);
    sql = 'select * from members where id = ' + userId;
    con.query(sql, (err, rows, fields) =>
    {
        if(err)
            resp.send(err);
        else
            resp.send(rows);
    })
    con.end();
})

//delete
app.delete("/:id", (req, resp) => {
    //id에 해당하는 객체를 삭제하는 코드 작성하시오.
    //let data = getData(req.params.id);
    //members.splice(data[0],1);
    //console.log('length: ',members.length);

    let userId = req.params.id;
    const con = mysql.createConnection
    ({
        host: 'localhost',
        user: 'root',
        password: '1234',
        port: '3306',
        database: 'library'
    });
    let sql = 'delete from members where id = "' + userId + '"';
    con.query(sql, (err, rows, fields) =>
    {
        if(err)
            resp.send(err);
        else
            resp.send(rows);
    })
    con.end();
})
