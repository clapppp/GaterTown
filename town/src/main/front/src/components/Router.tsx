import { BrowserRouter, Routes, Route } from "react-router-dom"
import MapList from "./MapList"
import Login from "./Login"
import Register from "./Register"
import MapDetail from "./MapDetail"

function Router() {
    return (
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<Login />} />
                <Route path="/register" element={<Register />} />
                <Route path="/map" element={<MapList />}>
                    <Route path=":region" element={<MapDetail />} />
                </Route>
            </Routes>
        </BrowserRouter>
    )
}

export default Router