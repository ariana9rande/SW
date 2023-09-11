const {MongoClient} = require("mongodb");
const uri = "mongodb://127.0.0.1:27017";
const client = new MongoClient(uri);

async function connectMongo()
{
    await client.connect();
    const adminDB = client.db('test').admin();
    const listDatabases = await adminDB.listDatabases();
    console.log(listDatabases);
    return "OK";
}

connectMongo()
.then(console.log)
.catch(console.error)
.finally(() => client.close());