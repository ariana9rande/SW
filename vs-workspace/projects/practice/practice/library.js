const mysql = require("mysql2");
const lineReader = require('line-reader');
console.log(lineReader);

const con = mysql.createConnection
    ({
        host: 'localhost',
        user: 'root',
        password: '1234',
        port: '3306',
        database: 'library'
    });



const insertData = con.connect((err) =>
{
    lineReader.eachLine('book1.csv', (line, lasg) =>
    {
        let sql = `insert into book_info values('${line.toString().split(",")[0]}', '${line.toString().split(",")[1]}', '${line.toString().split(",")[2]}', '${line.toString().split(",")[3]}')`;
        
        con.query(sql, (err, rows, _) =>
        {
            if (err)
            {
                console.log(err);
            }
        })
    })
    console.log("inserted");
})