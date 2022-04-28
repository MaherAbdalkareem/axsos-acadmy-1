import React, { useEffect, useState } from 'react'
import {Link , useNavigate} from 'react-router-dom'
import axios from 'axios'
import 'bootstrap/dist/css/bootstrap.min.css';
import {Table , Button , Row , Col} from 'react-bootstrap'
import DeleteButton from '../component/DeleteButton'
const Main = (props) => {
    const [author,setAuthor]=useState([])
    const [loaded,setLoaded]=useState(false)
    const navigate = useNavigate();
    useEffect(() => {
        axios.get('http://localhost:8000/')
        .then(res => {setAuthor(res.data);setLoaded(true)})
        .catch(err => console.log(err))
    })
    const removeFromDom = authorId => {
      setAuthor(author.filter(author => author._id !== authorId));
  }
  return (
    <div>
        <h1>Favorite Author</h1>
        <Link to={`/new`}>Add an author</Link>
        <h2>We have quotes by: </h2>
        { loaded && (<Table className="table table-striped">
          <thead>
            <tr>
            <th>Author</th>
            <th>Actions available</th>
          </tr>
          </thead>
          <tbody>
            
          
            {author.map((author,inx) =>
            <tr>
             <td key={inx}>
                {author.name}
                </td>
                <td>
                <Row>
                  <Col><DeleteButton  authorID={author._id} successCall={() => {removeFromDom(author._id)}}/></Col>
                <Col>
                <Button ><Link to={`/edit/${author._id}`} style={{textDecorationLine: 'none' ,color : 'white'}}>Update</Link></Button>
                </Col>
                </Row>
              </td>
              </tr>
                )  
            }
            
          </tbody>
          

        </Table>)}
        
    </div>
  )
}

export default Main