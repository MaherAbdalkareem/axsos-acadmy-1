const { request, response } = require('express');
const {Team}=require('../Models/TeamModel')

module.exports.createTeam = (request,response) => {
    const { name , position } = request.body ;
    Team.create({
        name,
        position
    })
    .then(team => response.json(team))
    .catch(err => response.status(400).json(err))
}

module.exports.getAllTeam = (request,response) => {
    Team.find({})
    .then(team => response.json(team))
    .catch(err => response.json(err))
}

module.exports.getTeam = (request,response) => {
    const { id } = request.params;
    Team.findOne({_id:id})
    .then(team => response.json(team))
    .catch(err => response.json(err))
}
module.exports.updateTeam = (request , response) => {
    const {id} = request.params ;
    Team.findOneAndUpdate({_id:id}, request.body, {new:true})
    .then(team => response.json(team))
    .catch(err => response.status(400).json(err))
}
module.exports.deleteTeam = (request,response) => {
    const {id} =request.params ;
    Team.deleteOne({_id:id})
    .then(deletedteam => response.json(deletedteam))
    .catch(err => response.json(err))
}