import React, { useEffect, useState } from "react";
import axios from 'axios';
import { Link, useLocation, useNavigate } from "react-router-dom";

function Login() {

    const { state } = useLocation();
    const navigate = useNavigate();

    const [info, setInfo] = useState({
        "id": "",
        "password": ""
    });

    useEffect(() => {
        console.log(state);
        if (state) navigate("/map", { state: state }); 
    }, [state, navigate])

    function handleChange(e: React.ChangeEvent<HTMLInputElement>) {
        setInfo({
            ...info,
            [e.target.name]: e.target.value
        })
    }

    function post(e: React.FormEvent<HTMLFormElement>) {
        e.preventDefault();
        axios.post("https://sturdy-parakeet-p6jr6r9p65qf7p7r-8080.app.github.dev/login", info)
            .then(result => {
                console.log(result.data)
                navigate("/map", { state: result.data })
            })
            .catch(err => console.log(err));
    }

    return (
        <>
            <form onSubmit={post} >
                <input type="text" name="id" value={info.id} onChange={handleChange} />
                <input type="text" name="password" value={info.password} onChange={handleChange} />
                <input type="submit" />
            </form>
            <Link to="/register">사용자 등록</Link>
        </>
    );
}

export default Login;