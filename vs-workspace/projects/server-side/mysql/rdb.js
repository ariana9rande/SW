let mysql = require('mysql2');
let con = mysql.createConnection
({
    host: 'localhost',
    user : 'root',
    password : '1234',
    port : '3306',
    database : 'skuni'
});
let sql = 'select * from members';
con.query(sql, (err, rows, fields) =>
{
    if(err)
        console.log(err);
    else
        console.log('rows : ', rows);
});
con.end();