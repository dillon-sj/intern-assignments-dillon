import React from "react";
import "./App.css";
import { Routes, Route } from "react-router-dom";
import GetAllEmployeesPage from "./pages/GetAllEmployees";
import HomePage from "./pages/HomePage";
import GetEmployeesById from "./pages/GetEmployeesById";

function App() {
    return (
        <div className="App">
            <Routes>
                <Route path="/home" element={<HomePage />} />
                <Route index element={<HomePage />} />
                <Route
                    path="/getAllEmployeesPage"
                    element={<GetAllEmployeesPage />}
                />
                <Route
                    path="/getEmployeeByIdPage"
                    element={<GetEmployeesById />}
                />
            </Routes>
        </div>
    );
}

export default App;
