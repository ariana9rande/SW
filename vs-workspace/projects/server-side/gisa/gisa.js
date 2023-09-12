const mysql = require("mysql2");
const lineReader = require('line-reader');
console.log(lineReader);

const con = mysql.createConnection
    ({
        host: 'localhost',
        user: 'root',
        password: '1234',
        port: '3306',
        database: 'skuni'
    });


const createTable = con.connect((err) =>
{
    if (err)
        throw err;
    console.log("connected");

    let sql = 'create table data' +
        '( StdNo varchar(6) primary key,' +
        'email varchar(4) not null,' +
        'kor varchar(3) not null,' +
        'eng varchar(3) not null,' +
        'math varchar(3) not null,' +
        'sci varchar(3) not null,' +
        'hist varchar(3) not null,' +
        'total varchar(3) not null,' +
        'mgr_code varchar(1) not null,' +
        'acc_code varchar(1) not null,' +
        'loc_code varchar(1) not null' +
        ');';

    con.query(sql, (err) => {
        if (err)
            throw err;
        console.log("table created");
    })
})

const insertData = con.connect((err) =>
{
    lineReader.eachLine('./gisa/Abc1115.csv', (line, lasg) =>
    {
        let sql = `insert into data values('${line.toString().split(",")[0]}', '${line.toString().split(",")[1]}', '${line.toString().split(",")[2]}', '${line.toString().split(",")[3]}', '${line.toString().split(",")[4]}', '${line.toString().split(",")[5]}', '${line.toString().split(",")[6]}', '${line.toString().split(",")[7]}', '${line.toString().split(",")[8]}', '${line.toString().split(",")[9]}', '${line.toString().split(",")[10]}')`;

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