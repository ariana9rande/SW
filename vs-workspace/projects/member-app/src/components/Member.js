import React from "react";
import { Link } from "react-router-dom";
import '../components/Style.css'
function Member({id,pwd,name,isAdmin}){

    return (
        <div>
            <h3>
                {id} {name} <input type="checkbox" checked={isAdmin?'checked':''}/>관리자
                <Link to={`/Detail/${id}`}>
                    <button>조회</button>
                </Link>
                <Link to={`/Update/${id}`}>
                    <button>수정</button>
                </Link>
                <Link to={`/Delete/${id}`}>
                    <button>삭제</button>
                </Link>
            </h3>
            
        </div>
    );
}

export default Member;