const express = require('express');
const app = express();
const cors = require('cors');
const bodyParser = require("body-parser");
const {MongoClient} = require("mongodb");
const url = "mongodb://127.0.0.1:27017";
const client = new MongoClient(url);

app.use(bodyParser.json());
app.use(cors({
    origins : "*",
}));
const members = [];

app.listen(8080, async () => 
{
    console.log("waiting 8080");
    await client.connect();
    collection = client.db('test').collection('members');
    //const listDatabases = await collection.listDatabases();
    //console.log(listDatabases);

    members.push({id: 'admin', pwd: '1234', name: 'teddy', isAdmin: true});
    members.push({id: 'user1', pwd: '1234', name: 'eddy', isAdmin: false});
    members.push({id: 'user2', pwd: '1234', name: 'emmy', isAdmin: false});
    console.log(members);
})

//login

app.post('/login', (req, res) => {
    let check = false;
    const { id, pwd } = req.body;
    const member = getData(id)[1];
    if(member.pwd == pwd)
        check = true;
  
    if (check) {
      res.json({ success: true, message: '로그인 성공' });
    } else {
      res.json({ success: false, message: '로그인 실패' });
    }
  });

//read all
app.get("/", async (req, res) => 
{
    //res.send("root request success");
    const documents = await collection.find().toArray();
    res.send(JSON.stringify(documents));
})

//read
app.get("/:id", async (req, res) => 
{
    let userId = req.params.id;
    const document = await collection.find({id:userId}).toArray();
    console.log("document: ", document);
    const member = getData(userId);
    console.log(member);
    res.send(member[1]);
})

//create
app.post("/", async (req, res) =>
{
    //console.log(req.body);
    const member =
    {
        id : req.body.id,
        pwd : req.body.pwd,
        name : req.body.name,
        isAdmin : req.body.isAdmin
    }

    const result = await collection.insertOne(member);
    console.log(result);
    
    if(getData(req.body.id)[0] == -1)
    {
        members.push(member);
        res.send(member);
    }
})

function getData(userId)
{
    let temp = null;
    let index = -1;
    for(const idx in members)
    {
        if(userId == members[idx].id)
        {
            temp = members[idx];
            index = idx;
            break;
        }
    }
    return [index, temp];
}

//update
app.put("/:id", async (req, res) =>
{
    console.log(req.body);
    let data = getData(req.params.id);

    let userId = req.params.id;
    const result = await collection.updateOne({id:userId}), {$set: {name:req.body.name}};
    console.log(result);

    /*if(req.body.id)
        data[1].id = req.body.id;
    data[1].name = req.body.name;
    data[1].pwd = req.body.pwd;
    data[1].isAdmin = req.body.isAdmin;

    members[data[0]] = data[1];
    data = getData(req.params.id);*/
    res.send(JSON.stringify(data[1]));
})

//delete
app.delete("/:id", async (req, res) =>
{
    let userId = req.params.id; 
    let deleteResult = await collection.deleteOne({id:userId});
    console.log(deleteResult);

    //members.splice(getData(userId)[0], 1);

    const result = {result: true};
    res.send(JSON.stringify(result));
})