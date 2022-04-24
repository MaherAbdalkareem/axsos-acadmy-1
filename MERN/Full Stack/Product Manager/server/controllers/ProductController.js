
const { request, response } = require('express');
const { Product } = require('../models/ProductModel');

module.exports.createProduct = (request,response) => {
    const { title , price , description } = request.body ;
    Product.create({
        title,
        price,
        description
    })
    .then(product => response.json(product))
    .catch(err => response.json(err))
}

module.exports.getAllProduct = (request,response) => {
    Product.find({})
    .then(products => response.json(products))
    .catch(err => response.json(err))
}

module.exports.getProduct = (request,response) => {
    const { id } = request.params;
    Product.findOne({_id:id})
    .then(product => response.json(product))
    .catch(err => response.json(err))
}
module.exports.updateProduct = (request , response) => {
    const {id} = request.params ;
    Product.findOneAndUpdate({_id:id}, request.body, {new:true})
    .then(product => response.json(product))
    .catch(err => response.json(err))
}
module.exports.deleteProduct = (request,response) => {
    const {id} =request.params ;
    Product.deleteOne({_id:id})
    .then(deletedProduct => response.json(deletedProduct))
    .catch(err => response.json(err))
}