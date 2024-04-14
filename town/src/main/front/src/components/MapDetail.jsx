import { useLocation, useParams } from "react-router-dom"


function MapDetail() {
    const location = useLocation();
    const player = location.state;
    const {region} = useParams();

    return (
        <p>{player.username} from {player.region} is in {region}</p>
        
    )
}

export default MapDetail