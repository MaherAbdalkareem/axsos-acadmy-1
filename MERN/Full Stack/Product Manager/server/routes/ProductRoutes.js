const ProductController = require('../controllers/ProductController');

module.exports = function (app){
    app.post('/api/product/new', ProductController.createProduct);
    app.get('/api/product/new',ProductController.getAllProduct);
    app.get('/api/product/:id',ProductController.getProduct);
    app.put('/api/product/:id/edit',ProductController.updateProduct)
    app.delete('/api/product/delete/:id',ProductController.deleteProduct)
}