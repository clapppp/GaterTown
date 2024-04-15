import { CompatClient, Stomp } from "@stomp/stompjs";
import { useEffect, useRef, useState } from "react";
import { useLocation, useParams } from "react-router-dom"
import SockJS from "sockjs-client";

function MapDetail() {
    const location = useLocation();
    const player = location.state;
    const { region } = useParams();
    const client = useRef<CompatClient>();

    const connect = () => {
        client.current = Stomp.over(() => {
            const sock = new SockJS("https://sturdy-parakeet-p6jr6r9p65qf7p7r-8080.app.github.dev/gatertown")
            return sock
        })
        client.current.connect({
        }, () => {
            client.current?.subscribe(`/topic/gatertown/${region}`, (message) => {
                console.log(message.body);
            })
        })
    }

    const send = (e) => {
        e.preventDefault();
        client.current?.publish({
            destination: `/app/gatertown/update/${region}`
            , body: JSON.stringify(player)
        });
    }

    useEffect(() => {
        connect();
    },[])

    return (
        <>
            <p>{player.username} from {player.region} is in {region}</p>
            <form onSubmit={send}>
                <input type="submit" />
            </form>

        </>
    )
}

export default MapDetail