const fs = require('fs');

const jsonFile = fs.readFileSync('./test/library.json','utf-8');
console.log('jsonFile');
var jsonFileToObject = JSON.parse(jsonFile);
console.log(jsonFileToObject);
console.log(jsonFileToObject.data.userInfo.user);