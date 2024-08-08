import React, { useEffect, useState } from "react";
import axios from "axios";
import "./GetAllEmployees.css";

const GetAllEmployeesPage: React.FC = () => {
    const [employees, setEmployees] = useState([]);

    useEffect(() => {
        const url = "http://localhost:8080/api/employees";

        const fetchAllEmployees = async () => {
            try {
                const response = await axios.get(url);
                setEmployees(response.data);
            } catch (error) {
                console.error("Error fetching employees:", error);
            }
        };

        fetchAllEmployees();
    }, []);

    return (
        <div>
            <div className="main-title">Get All Employees Page</div>
            <div className="all-employees-container">
                {employees.length > 0 ? (
                    employees.map((employees: any) => (
                        <div key={employees.id} className="single-all-employee">
                            <p>
                                Employee Id: {employees.employeeId}.<br />
                                First Name: {employees.employeeFirstName}.<br />
                                Last Name: {employees.employeeLastName}.<br />
                            </p>
                        </div>
                    ))
                ) : (
                    <p>No employees found</p>
                )}
            </div>
        </div>
    );
};

export default GetAllEmployeesPage;
