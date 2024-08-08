import React, { useEffect, useState } from "react";
import axios from "axios";
import "./GetAllEmployees.css";

interface Employee {
    id: string;
    employeeId: string;
    employeeFirstName: string;
    employeeLastName: string;
    employeeGender: string;
    designation: string;
}

const GetAllEmployeesPage: React.FC = () => {
    const [employees, setEmployees] = useState<Employee[]>([]);

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
                    <table className="employees-table">
                        <thead className="employee-heading">
                            <tr>
                                <th>Employee Count</th>
                                <th>Employee ID</th>
                                <th>First Name</th>
                                <th>Last Name</th>
                                <th>Gender</th>
                                <th>Designation</th>
                            </tr>
                        </thead>
                        <tbody className="emplyee-body">
                            {employees.map((employee, index) => (
                                <tr key={employee.id}>
                                    <td>Employee {index + 1}</td>
                                    <td>{employee.employeeId}</td>
                                    <td>{employee.employeeFirstName}</td>
                                    <td>{employee.employeeLastName}</td>
                                    <td>{employee.employeeGender}</td>
                                    <td>{employee.designation}</td>
                                </tr>
                            ))}
                        </tbody>
                    </table>
                ) : (
                    <p>No employees found</p>
                )}
            </div>
        </div>
    );
};

export default GetAllEmployeesPage;
