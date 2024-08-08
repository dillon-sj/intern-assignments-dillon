import axios from "axios";
import { useState } from "react";
import "./pageStyle.css";

interface Employee {
    id: string;
    employeeId: string;
    employeeFirstName: string;
    employeeLastName: string;
}

const GetEmployeesByIdPage: React.FC = () => {
    const [employeeId, setEmployeeId] = useState<string>("");
    const [employee, setEmployee] = useState<Employee | null>(null);
    const [searched, setSearched] = useState<boolean>(false);

    const fetchEmployeeById = async () => {
        try {
            const response = await axios.get<Employee>(
                `http://localhost:8080/api/employees/${employeeId}`
            );
            setEmployee(response.data);
        } catch (error) {
            console.error("Employee not found");
            setEmployee(null);
        } finally {
            setSearched(true);
        }
    };

    return (
        <div>
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
                {searched && employee ? (
                    <div className="single-employee">
                        <p>
                            Employee Id: {employee.employeeId}.<br />
                            First Name: {employee.employeeFirstName}.<br />
                            Last Name: {employee.employeeLastName}.<br />
                        </p>
                    </div>
                ) : searched && !employee ? (
                    <p className="single-employee">Employee not found</p>
                ) : null}
            </div>
        </div>
    );
};

export default GetEmployeesByIdPage;
