const TrelloController = require('../Controller/TrelloController')
module.exports = function (app){
    app.post('/new', TrelloController.createTrello);
    app.get('/',TrelloController.getAllTrello);
    app.get('/trello/:id',TrelloController.getTrello);
    app.put('/trello/:id/edit',TrelloController.updateTrello);
    app.delete('/trello/delete/:id',TrelloController.deleteTrello)
}