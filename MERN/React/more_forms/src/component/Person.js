import React, { useState } from 'react'

const Person = (props) => {
    const [firstname, setFirstname] = useState("")
    const [firstnameerror, setFirstnameError] = useState("")
    const [lastname, setLastname] = useState("")
    const [lastnameerror, setLastnameError] = useState("")
    const [email, setEmail] = useState("")
    const [emailerror, setEmailError] = useState("")
    const [password, setPassword] = useState("")
    const [passworderror, setPasswordError] = useState("")
    const [confirm, setConfirm] = useState("")
    const [confirmerror, setConfirmError] = useState("")
    const handelfirstname=(e) =>{
        if(e.target.value.length < 3){
            setFirstnameError("First Name Should at least 2 charactor ");
        }
        else{
            setFirstnameError("")
            setFirstname(e.target.value);
        }
    }
    const handellastname=(e) =>{
        if(e.target.value.length < 3){
            setLastnameError("Last Name Should at least 2 charactor ");
        }
        else{
            setLastnameError("")
            setLastname(e.target.value);
        }
    }
    const handelemail=(e) =>{
        if(e.target.value.length < 3){
            setEmailError("Email Should at least 2 charactor ");
        }
        else{
            setEmailError("")
            setEmail(e.target.value);
        }
    }
    const handelpassword=(e) =>{
        if(e.target.value.length < 9){
            setPasswordError("Email Should at least 8 charactor ");
        }
        else{
            setPasswordError("")
            setPassword(e.target.value);
        }
    }
    const handelconfrim=(e) =>{
        if(e.target.value != password){
            setConfirmError("Password must match ");
        }
        else{
            setConfirmError("")
            setConfirm(e.target.value);
        }
    }
    return (
        <div>
            <div>
                <label>First name: </label>
                <input type="text" onChange={handelfirstname} />
                {firstnameerror?
                <p style={{color:'red'}}>{firstnameerror}</p>:
                ''}
            </div>
            <div>
                <label>Last name: </label> 
                <input type="text" onChange={ handellastname } />
                {lastnameerror?
                <p style={{color:'red'}}>{lastnameerror}</p>:
                ''}
            </div>
            <div>
                <label>Email : </label> 
                <input type="text" onChange={handelemail} />
                {
                    emailerror?
                    <p style={{color:'red'}}>{emailerror}</p>:
                    ''
                }
            </div>
            <div>
                <label>Password : </label> 
                <input type="text" onChange={ handelpassword } />
                {
                    passworderror?
                    <p style={{color:'red'}}>{passworderror}</p>:
                    ''
                }
            </div>
            <div>
                <label>Confirm Password : </label> 
                <input type="text" onChange={ handelconfrim } />
                {
                    confirmerror?
                    <p style={{color:'red'}}>{confirmerror}</p>:
                    ''
                }
            </div>
            <div>
            <h1>Your Data </h1>
                <p>first Name :{firstname}</p>
                <p>last Name : {lastname}</p>
                <p>Email : {email}</p>
                <p>Password : {password}</p>
                <p>Confirm Password : {confirm}</p>
            </div>
        </div>
    )
}

export default Person