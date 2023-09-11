import React,{useState,useEffect} from "react";
import { useNavigate } from "react-router-dom";
function Create(){
    const [id, setId] = useState('');
    const [pwd, setPwd] = useState('');
    const [name, setName] = useState('');
    const [isAdmin, setIsAdmin] = useState(false);
    const navigate = useNavigate();
    const postData = () =>{
        console.log(id,pwd,name,isAdmin);
        const member = {
            id : id,
            name : name,
            pwd : pwd,
            isAdmin : isAdmin,
        }

        fetch('http://localhost:8080/',{
            method : 'post',
            headers : {
                "Content-Type":"application/json",
            },
            body : JSON.stringify(member),
        })
        .then(response=>response.json())
        .then(data=>{
            console.log('create: ',data);
            navigate("/Read");
        })       
    }
    return (
        <div>
            <table>
                <tbody>
                <tr>
                    <td>ID:</td>
                    <td>
                        <input type='text' id='userId' onChange={(e) => setId(e.target.value)}/>
                    </td>
                </tr> 
                <tr>
                    <td>PW:</td>
                    <td>
                        <input type='password' id='pwd' onChange={(e) => setPwd(e.target.value)}/>
                    </td>
                </tr> 
                <tr>
                    <td>NAME:</td>
                    <td>
                        <input type='text' id='name' onChange={(e) => setName(e.target.value)}/>
                    </td>
                </tr> 
                <tr><td colSpan='2'>
                    <input type='checkbox' id='isAdmin'  onChange={(e) => setIsAdmin(e.target.checked)}/>관리자입니다.</td></tr>
                <tr><td><input type='submit' id='join' value='가입하기' onClick={postData}/></td></tr> 
                </tbody>
            </table>
        </div>
    );
}

export default Create;