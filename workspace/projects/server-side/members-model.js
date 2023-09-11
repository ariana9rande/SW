const mongoose = require('mongoose');
const Schema = mongoose.Schema;

const memberSchema = new Schema
({
    id : String,
    pwd : String,
    name : String,
    isAdmin : {type: Boolean, required: true},
});

module.exports = mongoose.model('Member', memberSchema);