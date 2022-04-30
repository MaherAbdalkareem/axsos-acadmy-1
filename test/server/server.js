const express=require("express");
const cors = require('cors')
const app = express();
require('./Config/TrelloConfig')
app.use(cors())
app.use(express.json())
app.use(express.urlencoded({ extended: true }));

require('./Routes/TrelloRoute')(app);
app.listen(8000, () => console.log(`listen in port : 8000`))