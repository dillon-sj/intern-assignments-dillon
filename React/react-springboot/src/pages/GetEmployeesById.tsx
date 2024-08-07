import React, { useState } from "react";
import axios from "axios";
import NavBar from "../components/NavBar";
import "./GetEmployeesById.css";

interface Employee {
    id: string;
    employeeId: string;
    employeeFirstName: string;
    employeeLastName: string;
}

const GetEmployeesByIdPage = () => {
    const [employeeId, setEmployeeId] = useState("");
    const [employee, setEmployee] = useState<Employee | null>(null);

    const fetchEmployeeById = async () => {
        try {
            const response = await axios.get<Employee>(
                `http://localhost:8080/api/employees/${employeeId}`
            );
            setEmployee(response.data);
        } catch (error) {
            console.error("Employee not found");
            setEmployee(null);
        }
    };

    return (
        <div>
            <NavBar />
            <div className="main-title">Get Employee By ID</div>
            <div className="input-section">
                <input
                    className="input-field"
                    type="text"
                    value={employeeId}
                    onChange={(e) => setEmployeeId(e.target.value)}
                    placeholder="Enter an Employee ID"
                />
                <button className="submit-btn" onClick={fetchEmployeeById}>
                    Get Employee
                </button>
            </div>
            <div className="employee-details-container">
                {employee ? (
                    <div className="single-employee">
                        <p>
                            Employee Id: {employee.employeeId}.<br />
                            First Name: {employee.employeeFirstName}.<br />
                            Last Name: {employee.employeeLastName}.<br />
                        </p>
                    </div>
                ) : (
                    <p className="single-employee">Employee not found</p>
                )}
            </div>
        </div>
    );
};

export default GetEmployeesByIdPage;
