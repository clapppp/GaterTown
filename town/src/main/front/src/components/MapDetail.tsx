import { CompatClient, Stomp } from "@stomp/stompjs";
import React, { useCallback, useEffect, useRef, useState } from "react";
import { useLocation, useParams } from "react-router-dom"
import SockJS from "sockjs-client";
import { connect } from "./MySocket";

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


    const send = useCallback((e: React.FormEvent<HTMLFormElement>) => {
        e.preventDefault();

        client.current?.publish({
            destination: `/app/gatertown/update/${region}`
            , body: JSON.stringify(player)
        });
    }, [region,player]);

    useEffect(() => {
        connect(region, client);
    }, [connect])


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