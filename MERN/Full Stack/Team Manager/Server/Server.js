const express=require("express");
const cors = require('cors')
const app = express();
require('./Server/Config/TeamConfig')
app.use(cors())
app.use(express.json())
app.use(express.urlencoded({ extended: true }));

require('./Server/Routes/TeamRoute')(app);
app.listen(8000, () => console.log(`listen in port : 8000`))