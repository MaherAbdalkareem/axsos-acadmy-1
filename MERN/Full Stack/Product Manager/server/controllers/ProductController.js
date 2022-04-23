
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