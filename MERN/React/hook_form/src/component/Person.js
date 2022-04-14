import React, { useState } from 'react'

const Person = (props) => {
    const [firstname, setFirstname] = useState("")
    const [lastname, setLastname] = useState("")
    const [email, setEmail] = useState("")
    const [password, setPassword] = useState("")
    const [confirm, setConfirm] = useState("")
    return (
        <div>
            <div>
                <label>First name: </label>
                <input type="text" onChange={(e) => setFirstname(e.target.value)} />
            </div>
            <div>
                <label>Last name: </label> 
                <input type="text" onChange={ (e) => setLastname(e.target.value) } />
            </div>
            <div>
                <label>Email : </label> 
                <input type="text" onChange={ (e) => setEmail(e.target.value) } />
            </div>
            <div>
                <label>Password : </label> 
                <input type="text" onChange={ (e) => setPassword(e.target.value) } />
            </div>
            <div>
                <label>Confirm Password : </label> 
                <input type="text" onChange={ (e) => setConfirm(e.target.value) } />
            </div>
            <div>
                <h1>Your Data </h1>
                <p>first Name : {firstname}</p>
                <p>last Name : {lastname}</p>
                <p>Email : {email}</p>
                <p>Password : {password}</p>
                <p>Confirm Password : {confirm}</p>
            </div>
        </div>
    )
}

export default Person