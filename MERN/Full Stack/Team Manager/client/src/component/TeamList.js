import React, { useEffect, useState } from 'react'
import 'bootstrap/dist/css/bootstrap.min.css';
import {Table , Button , Row , Col} from 'react-bootstrap'
import axios from 'axios'
import DeleteButton from '../component/DeleteButton'
const TeamList = () => {
    const [team,setTeam]=useState([])
    useEffect(()=>{
        axios.get('http://localhost:8000/')
        .then(res  => setTeam(res.data))
        .catch(err => console.log(err))
    })
    const removeFromDom = teamId => {
        setTeam(team.filter(team => team._id !== teamId));
    }
  return (
    <div>
        <Table>
        <Table className="table table-striped">
          <thead>
            <tr>
            <th>Team Name</th>
            <th>Prefered Position</th>
            <th>Action</th>
          </tr>
          </thead>
          <tbody>
            
          
            {team.map((team,inx) =>
            <tr>
             <td key={inx}>
                {team.name}
                </td>
                <td >
                {team.position}
                </td>
                <td>
                <Row>
                  <Col><DeleteButton  teamID={team._id} successCall={() => {removeFromDom(team._id)}}/></Col>
                </Row>
              </td>
              </tr>
                )  
            }
            
          </tbody>
          

        </Table>
        </Table>
    </div>
  )
}

export default TeamList