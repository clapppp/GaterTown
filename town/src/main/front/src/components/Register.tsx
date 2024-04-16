import { useState } from "react";
import axios from 'axios';
import { useNavigate } from "react-router-dom";

function Register() {
    const navigate = useNavigate();

    const [regist, setRegist] = useState({
        "id": "",
        "password": "",
        "username": "",
        "region": ""
    });

    function handleSubmit(e: React.FormEvent<HTMLFormElement>) {
        e.preventDefault();
        
        axios.post("https://sturdy-parakeet-p6jr6r9p65qf7p7r-8080.app.github.dev/register", regist)
            .then(result => navigate("/", { state: result.data }))
            .catch(err => console.log(err));
    }

    function handleChange(e: React.ChangeEvent<HTMLInputElement>) {
        setRegist({
            ...regist,
            [e.target.name]: e.target.value
        })
    }

    return (
        <form onSubmit={handleSubmit} >
            <input type="text" name="id" value={regist.id} onChange={handleChange} />
            <input type="text" name="password" value={regist.password} onChange={handleChange} />
            <input type="text" name="username" value={regist.username} onChange={handleChange} />
            <input type="text" name="region" value={regist.region} onChange={handleChange} />
            <input type="submit" />
        </form>
    );
}

export default Register