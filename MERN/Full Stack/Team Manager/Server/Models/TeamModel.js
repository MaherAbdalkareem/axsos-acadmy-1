const mongoose = require('mongoose')

const TeamSchema = new mongoose.Schema({
    name : {type : String,
    required:[
        true,
        "Name is required"
    ],minlength : [3,"the min name charactor is 3"]},
    position : {type : String,
        required:[
            true,
            "Postion is required"
        ],minlength : [3,"the min position charactor is 3"]}
},{timestamps : true})

module.exports.Team = mongoose.model('Team',TeamSchema);