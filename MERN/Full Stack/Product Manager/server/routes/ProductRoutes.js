const ProductController = require('../controllers/ProductController');

module.exports = function (app){
    app.post('/api/product/new', ProductController.createProduct);
    app.get('/api/product/new',ProductController.getAllProduct)
    app.get('/api/product/:id',ProductController.getProduct)
}