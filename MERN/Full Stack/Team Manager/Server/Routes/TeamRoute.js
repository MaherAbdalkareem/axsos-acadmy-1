const TeamController = require('../Controller/TeamController')
module.exports = function (app){
    app.post('/new', TeamController.createTeam);
    app.get('/',TeamController.getAllTeam);
    app.get('/team/:id',TeamController.getTeam);
    app.put('/team/:id/edit',TeamController.updateTeam);
    app.delete('/team/delete/:id',TeamController.deleteTeam)
}