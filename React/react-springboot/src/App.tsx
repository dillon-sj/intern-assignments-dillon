import React from "react";
import "./App.css";
import { Routes, Route } from "react-router-dom";
import GetAllEmployeesPage from "./pages/GetAllEmployees";
import HomePage from "./pages/HomePage";
import GetEmployeesById from "./pages/GetEmployeesById";
import PostEmployee from "./pages/PostEmployee";
import DeleteEmployee from "./pages/DeleteEmployee";
import PutEmployee from "./pages/PutEmployee";

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
                <Route path="/postEmployee" element={<PostEmployee />} />
                <Route path="/deleteEmployee" element={<DeleteEmployee />} />
                <Route path="/putEmployee" element={<PutEmployee />} />
            </Routes>
        </div>
    );
}

export default App;
