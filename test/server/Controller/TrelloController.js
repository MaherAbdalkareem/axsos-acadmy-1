const { request, response } = require('express');
const {Trello}=require('../Models/TrelloModel')

module.exports.createTrello = (request,response) => {
    const { name , date , status } = request.body ;
    Trello.create({
        name, date , status 
    })
    .then(trello => response.json(trello))
    .catch(err => response.status(400).json(err))
}

module.exports.getAllTrello = (request,response) => {
    Trello.find({})
    .then(trello => response.json(trello))
    .catch(err => response.json(err))
}

module.exports.getTrello = (request,response) => {
    const { id } = request.params;
    Trello.findOne({_id:id})
    .then(trello => response.json(trello))
    .catch(err => response.json(err))
}
module.exports.updateTrello = (request , response) => {
    const {id} = request.params ;
    Trello.findOneAndUpdate({_id:id}, request.body, {new:true})
    .then(trello => response.json(trello))
    .catch(err => response.status(400).json(err))
}
module.exports.deleteTrello = (request,response) => {
    const {id} =request.params ;
    Trello.deleteOne({_id:id})
    .then(deletedtrello => response.json(deletedtrello))
    .catch(err => response.json(err))
}