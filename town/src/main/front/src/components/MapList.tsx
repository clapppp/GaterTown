import axios from "axios";
import { useEffect, useState } from "react";
import { Link, useLocation } from "react-router-dom";

function MapList() {
    const { state } = useLocation();
    const [list, setList] = useState([{
        "region": "",
        "players": {}
    }]);

    useEffect(() => {
        axios.get("https://sturdy-parakeet-p6jr6r9p65qf7p7r-8080.app.github.dev/rooms")
            .then(resp => setList(resp.data))
            .catch(err => console.log(err));
    })

    return (
        <>
            <header>{state.username}</header>
            {list.map(map => <Link to={`/map/${map.region}`}>{`/map/${map.region}`}</Link>)}
        </>
    )
}

export default MapList;