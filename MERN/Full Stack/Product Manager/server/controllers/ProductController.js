
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