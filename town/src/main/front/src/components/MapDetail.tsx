import { CompatClient, Stomp } from "@stomp/stompjs";
import { useEffect, useRef } from "react";
import { useLocation, useParams } from "react-router-dom"
import SockJS from "sockjs-client";

function MapDetail() {
    const location = useLocation();
    const player = location.state;
    const { region } = useParams();
    const client = useRef<CompatClient>();
    const connect = () => {
        client.current = Stomp.over(() => {
            const sock = new SockJS("ws://sturdy-parakeet-p6jr6r9p65qf7p7r-8080.app.github.dev/gatertown")
            return sock
        })
        client.current.connect({
        }, () => {
            client.current?.subscribe(`/topic/gatertown/${region}`, (message) => {
                console.log(message);
            })
        })
    }

    const send = () => {
        client.current?.publish({ destination: `/gatertown/update/${region}`, body: "Hello, STOMP" });
    }

    useEffect(() => {
        connect();
        
    })

    return (
        <p>{player.username} from {player.region} is in {region}</p>
        
    )
}

export default MapDetail