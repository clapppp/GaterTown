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
            <header>
                <p>{state.username} from {state.region}</p>
            </header>
            {list.map(map => <p><Link to={`/map/${map.region}`} state={state}>{map.region}</Link></p>)}
        </>
    )
}

export default MapList;