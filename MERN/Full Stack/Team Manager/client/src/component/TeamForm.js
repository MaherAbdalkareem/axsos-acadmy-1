import React, { useState } from 'react'
import 'bootstrap/dist/css/bootstrap.min.css';
import{Form , Button , Row ,Col} from 'react-bootstrap'
const TeamForm = (props) => {
    const {iName,iposition,onSubmitProp,errors}=props
    const [name,setName]=useState(iName);
    const[position,setPosition]=useState(iposition)
    const handelSubmit = e =>{
        e.preventDefault();
        onSubmitProp({name,position});
        
    }
  return (
    <div>
        <h2 className=' mt-5'>Add Player</h2>
        <Form onSubmit={handelSubmit}>
        {errors.map((err, index) => <p key={index}>{err}</p>)}
        <Row className='justify-content-center mt-5'>
            <Col className='col-2'>
    <label  for="exampleInputEmail1" className="form-label">Player Name</label>
    </Col>
    <Col className='col-2'>
    <input onChange={(e)=>setName(e.target.value)} value={name} type="text" className="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"/>
    </Col>
  </Row>
  <Row className='justify-content-center  mt-5'>
            <Col className='col-2'>
    <label for="exampleInputPassword1" className="form-label">Prefered Position</label>
    </Col>
    <Col className='col-2'>
    <input onChange={(e)=>setPosition(e.target.value)} value={position} type="text" className="form-control" id="exampleInputPassword1"/>
    </Col>
    </Row>
    
  <Button type="submit" className="btn btn-primary mb-3  mt-5">Submit</Button>
        </Form>
    </div>
  )
}

export default TeamForm