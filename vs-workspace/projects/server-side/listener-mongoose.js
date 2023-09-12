const express = require('express');
const app = express();

// const {MongoClient} = require("mongodb");
const url = "mongodb://127.0.0.1:27017";
// const client = new MongoClient(url);

const mongoose = require('mongoose');
const Member = require('./members-model');

const cors = require('cors');
const bodyParser = require("body-parser");
app.use(bodyParser.json());
app.use(cors({
    origins : "*",
}));
mongoose.set("strictQuery", false);

//const members = [];
// let collection = null; 
app.listen(8080, async ()=>{
    console.log('start member mongoose service~');
    console.log('listening...');
    // await client.connect();
    // collection = client.db('test').collection('users');

    mongoose.connect(url, {useNewUrlParser: true})
    .then(console.log("Connected to mongooseDB"));
})
//Restful API

//readAll
app.get("/", async (req,resp)=>{
    console.log('in');
    // const documents = await collection.find().toArray();
    //console.log(documents);

    const members = await Member.find({});
    console.log(members);
    resp.send(members);
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
    const member = await Member.find({id:userId});
    //const member = getData(userId);
    //console.log(member[0]);
    console.log(member);
    resp.send(member);
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
    const result = new Member(req.body);
    result.save();
    console.log(result);
    //members.push(member);
    resp.send(member);
})

//update
app.put("/:id", async (req,resp)=>{
    console.log(req.body);
    let userId = req.params.id;
    // let { pwd, name, isAdmin } = req.body;
    // const result = await collection.updateOne({id:userId}, {$set: {pwd, name, isAdmin}});
    // console.log(result);
    const member = await Member.findOneAndUpdate({id:userId}, {$set: req.body}, {new : true});
    console.log(member);
    // let data = await collection.find({name:userId}).toArray();  
    //let data = getData(req.params.id);
    // data[1].name = req.body.name;
    // data[1].pwd = req.body.pwd;
    // data[1].isAdmin = req.body.isAdmin;
    // members[data[0]] = data[1];
    // data = getData(req.params.id);
    // resp.send(JSON.stringify(data[0]));
    resp.send(member);
})

//delete
app.delete("/:id", async (req,resp)=>{
    //id에 해당하는 객체를 삭제하는 코드 작성하시오.
    //let data = getData(req.params.id);
    //members.splice(data[0],1);
    //console.log('length: ',members.length);
    
    let userId = req.params.id;
    // let deleteResult = await collection.deleteOne({id:userId});
    // console.log(deleteResult);
    const deleteResult = await Member.deleteOne({id:userId});
    console.log(deleteResult);
    const result = {flag:deleteResult.acknowledged};
    resp.send(result);       
})
