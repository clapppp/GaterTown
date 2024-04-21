import { CompatClient, Stomp } from "@stomp/stompjs";
import { useCallback } from "react";
import SockJS from "sockjs-client";

type player = {
    region: string,
    username: string,
    seq: number,
    x: number,
    y: number
}

function connect(region: string|undefined , client: React.MutableRefObject<CompatClient|undefined>) {
    useCallback(() => {
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
}

function send(region: string | undefined, client: React.MutableRefObject<CompatClient | undefined>, player: player) {
    useCallback((e: React.FormEvent<HTMLFormElement>) => {
        e.preventDefault();

        client.current?.publish({
            destination: `/app/gatertown/update/${region}`
            , body: JSON.stringify(player)
        });
    }, [region, player])
}

export { connect, send };