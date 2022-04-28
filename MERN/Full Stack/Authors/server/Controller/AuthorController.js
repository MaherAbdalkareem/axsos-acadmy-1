const { request, response } = require('express');
const {Author}=require('../Models/AuthorModel')

module.exports.createAuthor = (request,response) => {
    const { name } = request.body ;
    Author.create({
        name
    })
    .then(author => response.json(author))
    .catch(err => response.status(400).json(err))
}

module.exports.getAllAuthor = (request,response) => {
    Author.find({})
    .then(author => response.json(author))
    .catch(err => response.json(err))
}

module.exports.getAuthor = (request,response) => {
    const { id } = request.params;
    Author.findOne({_id:id})
    .then(author => response.json(author))
    .catch(err => response.json(err))
}
module.exports.updateAuthor = (request , response) => {
    const {id} = request.params ;
    Author.findOneAndUpdate({_id:id}, request.body, {new:true})
    .then(author => response.json(author))
    .catch(err => response.status(400).json(err))
}
module.exports.deleteAuthor = (request,response) => {
    const {id} =request.params ;
    Author.deleteOne({_id:id})
    .then(deletedauthor => response.json(deletedauthor))
    .catch(err => response.json(err))
}
