const express = require("express");
const mysql = require("mysql2");
const cors = require('cors');

const app = express();
const port = 8080;

app.use(cors
    ({
        origins : "*",
}))

const con = mysql.createConnection({
    host: 'localhost',
    user: 'root',
    password: '1234',
    database: 'skuni'
});

con.connect((err) => {
    if (err) {
        console.error('Database connection failed:', err.stack);
        return;
    }
    console.log('Connected to database as ID:', con.threadId);
});

app.listen(port, () => {
    console.log(`Server is running on port ${port}`);
});

app.get("/getData", (req, res) => {
    con.query("SELECT * FROM data", (err, results) => {
        if (err) {
            res.status(500).json({ error: err.message });
            return;
        }
        res.json(results);
    });
});


