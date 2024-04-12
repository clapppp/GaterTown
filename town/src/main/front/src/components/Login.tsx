import { useState } from "react";
import axios from 'axios';

function Login() {

    const [info, setInfo] = useState({
        "id": "",
        "password": ""
    });

    function handleChange(e) {
        setInfo({
            ...info,
            [e.target.name]: e.target.value
        })
    }

    function post(e) {
        e.prevent.default;
        axios.post("https://sturdy-parakeet-p6jr6r9p65qf7p7r-8080.app.github.dev/login", info);
    }

    return (
        <>
            <form onSubmit={post} >
                <input type="text" name="id" value={info.id} onChange={handleChange}/>
                <input type="text" name="password" value={info.password} onChange={handleChange}/>
                <input type="submit" />
            </form>
            
        </>
    );
}

export default Login;