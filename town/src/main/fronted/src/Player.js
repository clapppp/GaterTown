import React, {useState} from "react";

function Player() {
    let [x, setX] = useState(10);
    let [y, setY] = useState(20);

    const style = {
        top: x,
        left: y,
        position: 'absolute',
        width: 50
    }

    

    return <img src="player.png" style={style}></img>;
}

export default Player;