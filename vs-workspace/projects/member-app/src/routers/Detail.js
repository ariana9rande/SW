import React,{useEffect,useState} from "react";
import { useParams } from "react-router-dom";
import { useNavigate } from "react-router-dom";
function Detail(){
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
            setPwd(data[0].pwd);
            setId(data[0].id);
            // setName(data[0].user_name); // mysql
            // setIsAdmin(data[0].is_admin); // mysql
            setName(data[0].name); // mongo
            setIsAdmin(data[0].isAdmin); // mongo
        })
    },[params.id,navigate]);
    const back = ()=>{
        navigate("/Read");
    }
    return (
        <div>
            <table>
                <tbody>
                <tr>
                    <td>ID:</td>
                    <td>
                        <input type='text' id='userId' value={id}/>
                    </td>
                </tr> 
                <tr>
                    <td>PW:</td>
                    <td>
                        <input type='password' id='pwd' value={pwd}/>
                    </td>
                </tr> 
                <tr>
                    <td>NAME:</td>
                    <td>
                        <input type='text' id='name' value={name}/>
                    </td>
                </tr> 
                <tr><td colSpan='2'>
                    <input type='checkbox' id='isAdmin' checked={isAdmin?'checked':''}/>관리자입니다.</td>
                </tr>
                <tr><td><input type='submit' id='update' value='돌아가기' onClick={back}/></td></tr> 
                
                </tbody>
            </table>
        </div>
    );
}

export default Detail;