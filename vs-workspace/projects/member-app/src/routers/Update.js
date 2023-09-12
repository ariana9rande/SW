import React,{useEffect,useState} from "react";
import { useParams } from "react-router-dom";
import { useNavigate } from "react-router-dom";
function Update(){
    const params = useParams();
    const navigate = useNavigate();
    const [id, setId] = useState('');
    const [pwd, setPwd] = useState('');
    const [name, setName] = useState('');
    const [isAdmin, setIsAdmin] = useState(false);
    useEffect(()=>{
        fetch(`http://localhost:8080/${params.id}`)
        .then(response=>response.json())
        .then(data=>{
            setId(data[0].id);
            setPwd(data[0].pwd);
            // setName(data[0].user_name); // mysql
            // setIsAdmin(data[0].is_admin); // mysql
            setName(data[0].name); // mongo
            setIsAdmin(data[0].isAdmin); // mongo
        })
    },[params.id,navigate]);
    const updateData = () =>{
        console.log(id,pwd,name,isAdmin);
        const member = {
            id : id,
            name : name,
            pwd : pwd,
            isAdmin : isAdmin,
        }

        fetch(`http://localhost:8080/${params.id}`,{
            method : 'put',
            headers : {
                "Content-Type":"application/json",
            },
            body : JSON.stringify(member),
        })
        .then(response=>response.json())
        .then(data=>{
            console.log(data);
            navigate("/Read");
        })       
    }
    return (
        <div>
            <h1 id="center">Update</h1>
            <table>
                <tbody>
                <tr>
                    <td>ID:</td>
                    <td>
                        <input type='text' id='userId' value={id} onChange={(e) => setId(e.target.value)}/>
                    </td>
                </tr> 
                <tr>
                    <td>PW:</td>
                    <td>
                        <input type='password' id='pwd' value={pwd} onChange={(e) => setPwd(e.target.value)}/>
                    </td>
                </tr> 
                <tr>
                    <td>NAME:</td>
                    <td>
                        <input type='text' id='name' value={name} onChange={(e) => setName(e.target.value)}/>
                    </td>
                </tr> 
                <tr><td colSpan='2'>
                    <input type='checkbox' id='isAdmin' checked={isAdmin?'checked':''}  onChange={(e) => setIsAdmin(e.target.checked)}/>관리자입니다.</td></tr>
                <tr><td><input type='submit' id='update' value='수정확인' onClick={updateData}/></td></tr> 
                </tbody>
            </table>
        </div>
    );
}

export default Update;