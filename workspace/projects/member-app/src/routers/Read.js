import React,{useState,useEffect} from "react";
import Member from "../components/Member";
import '../components/Style.css';

function Read(){
    const [members, setMembers] = useState([]);
    useEffect(()=>{
        //alert('in');
        fetch('http://localhost:8080/')
        .then((response)=>response.json())
        .then((data)=>{
            setMembers(data);
            console.log('size ',data);
        })

         return ()=>{
             console.log('Unmount');
         };
    },[]); 

    return (
        <div id="center">
            <h1>Read</h1>
            {members.map((member)=>{
                return <Member 
                    key={member.id}
                    id={member.id}
                    pwd={member.pwd}
                    // name={member.user_name} // mysql
                    // isAdmin={member.is_admin} // mysql
                    name={member.name} // mongo
                    isAdmin={member.isAdmin} // mongo
                />
            })}
        </div>
    );
}

export default Read;
