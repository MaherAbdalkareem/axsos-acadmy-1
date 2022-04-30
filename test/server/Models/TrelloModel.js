const mongoose = require('mongoose')

const TrelloSchema = new mongoose.Schema({
    name : {type : String,
    required:[
        true,
        "Name is required"
    ],minlength : [3,"the min name charactor is 3"]},
    date : {type : Date,
        required:[
            true,
            "Date is required"
        ], min: [new Date(), "Date should be in the future"]
    },
        status:{type : String
        }
},{timestamps : true})

module.exports.Trello = mongoose.model('Trello',TrelloSchema);