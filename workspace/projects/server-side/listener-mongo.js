const express = require('express');
const app = express();

const {MongoClient} = require("mongodb");
const url = "mongodb://127.0.0.1:27017";
const client = new MongoClient(url);

const cors = require('cors');
const bodyParser = require("body-parser");
app.use(bodyParser.json());
app.use(cors({
    origins : "*",
}));


//const members = [];
let collection = null;
app.listen(8080, async ()=>{
    console.log('start member mongo service~');
    console.log('listening...');
    await client.connect();
    collection = client.db('test').collection('users');
    // members.push({id:'admin',pwd:'1234',name:'eddy',isAdmin:true});
    // members.push({id:'user1',pwd:'1234',name:'kim',isAdmin:false});
    // members.push({id:'user2',pwd:'1234',name:'lee',isAdmin:false});
})
//Restful API

//readAll
app.get("/", async (req,resp)=>{
    console.log('in');
    const documents = await collection.find().toArray();
    //console.log(documents);
    resp.send(JSON.stringify(documents));
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
app.get("/:id", async (req,resp)=>{
    let userId = req.params.id;
    const document = await collection.find({id:userId}).toArray();
    //const member = getData(userId);
    //console.log(member[0]);
    console.log(document);
    resp.send(document[0]);
});
//create
app.post("/", async (req,resp)=>{
    console.log(req.body);
    const member = {
        id : req.body.id,
        pwd : req.body.pwd,
        name : req.body.name,
        isAdmin : req.body.isAdmin
    }
    const result = await collection.insertOne(member);
    console.log(result);
    //members.push(member);
    resp.send(member);
})

//update
app.put("/:id", async (req,resp)=>{
    console.log(req.body);
    let userId = req.params.id;
    let { pwd, name, isAdmin } = req.body;
    const result = await collection.updateOne({id:userId}, {$set: {pwd, name, isAdmin}});
    console.log(result);
    let data = await collection.find({name:userId}).toArray();  
    //let data = getData(req.params.id);
    // data[1].name = req.body.name;
    // data[1].pwd = req.body.pwd;
    // data[1].isAdmin = req.body.isAdmin;
    // members[data[0]] = data[1];
    // data = getData(req.params.id);
    resp.send(JSON.stringify(data[0]));
})

//delete
app.delete("/:id", async (req,resp)=>{
    //id에 해당하는 객체를 삭제하는 코드 작성하시오.
    //let data = getData(req.params.id);
    //members.splice(data[0],1);
    //console.log('length: ',members.length);
    
    let userId = req.params.id;
    let deleteResult = await collection.deleteOne({id:userId});
    console.log(deleteResult);
    const result = {flag:deleteResult.acknowledged};
    resp.send(JSON.stringify(result));        
})
 