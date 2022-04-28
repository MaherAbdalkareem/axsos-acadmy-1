
const AuthorController = require('../Controller/AuthorController')
module.exports = function (app){
    app.post('/new', AuthorController.createAuthor);
    app.get('/',AuthorController.getAllAuthor);
    app.get('/author/:id',AuthorController.getAuthor);
    app.put('/author/:id/edit',AuthorController.updateAuthor);
    app.delete('/author/delete/:id',AuthorController.deleteAuthor)
}