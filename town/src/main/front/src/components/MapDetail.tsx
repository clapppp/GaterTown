import { CompatClient, Stomp } from "@stomp/stompjs";
import React, { useCallback, useEffect, useRef, useState } from "react";
import { useLocation, useParams } from "react-router-dom"
import SockJS from "sockjs-client";

type player = {
    region: string,
    username: string,
    seq: number,
    x: number,
    y: number
}

function MapDetail() {
    const location = useLocation();
    const [player, setPlayer] = useState<player>(location.state);
    const { region } = useParams();
    const client = useRef<CompatClient>();
    const canvas = useRef<HTMLCanvasElement>(null);

    const connect = useCallback(() => {
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
    }, [region])

    const send = useCallback((e: React.FormEvent<HTMLFormElement>) => {
        e.preventDefault();

        client.current?.publish({
            destination: `/app/gatertown/update/${region}`
            , body: JSON.stringify(player)
        });
    }, [region,player]);

    useEffect(() => {
        connect();
    },[connect])
    


    return (
        <>
            <p>{player.username} from {player.region} is in {region}</p>
            <form onSubmit={send}>
                <input type="submit" />
            </form>

            <canvas ref={canvas} />
        </>
    )
}

export default MapDetail