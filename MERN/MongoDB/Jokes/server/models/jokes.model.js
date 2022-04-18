const mongoose = require('mongoose');
 
const JokeSchema = new mongoose.Schema({
    setUp: { type: String ,
    require:[true,"setup is required"],
minlength:[10,"setup should be 6 character at least "]},
    punchline: { type: String,
        require:[true,"setup is required"],
        minlength:[3,"setup should be 6 character at least "] }
}, { timestamps: true });
 
const Joke = mongoose.model('Joke', JokeSchema);
 
module.exports = Joke;