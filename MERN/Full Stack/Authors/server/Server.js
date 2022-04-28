const express=require("express");
const cors = require('cors')
const app = express();
require('./Congif/AuthorConfig')
app.use(cors())
app.use(express.json())
app.use(express.urlencoded({ extended: true }));

require('./Routes/AuthorRoute')(app);
app.listen(8000, () => console.log(`listen in port : 8000`))