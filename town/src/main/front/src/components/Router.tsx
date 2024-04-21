import { BrowserRouter, Routes, Route } from "react-router-dom"
import MapList from "./MapList"
import Login from "./Login"
import Register from "./Register"
import MapDetail from "./Socket"

function Router() {
    return (
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<Login />} />
                <Route path="/register" element={<Register />} />
                <Route path="/map" element={<MapList />} />
                <Route path="/map/:region" element={<MapDetail />} />
            </Routes>
        </BrowserRouter>
    )
}

export default Router