import axios from "axios";
import { useState } from "react";

interface Employee {
    employeeId: string;
    employeeFirstName: string;
    employeeLastName: string;
    designation: string;
}

const PutEmployeePage: React.FC = () => {
    const [employee, setEmployee] = useState<Employee>({
        employeeId: "",
        employeeFirstName: "",
        employeeLastName: "",
        designation: "",
    });
    const [updated, setUpdated] = useState<boolean | null>(null);

    const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        const { name, value } = e.target;
        setEmployee({
            ...employee,
            [name]: value,
        });
    };

    const handleSubmit = async (e: React.FormEvent<HTMLFormElement>) => {
        e.preventDefault();
        try {
            await axios.put(
                `http://localhost:8080/api/employees/${employee.employeeId}`,
                {
                    employeeFirstName: employee.employeeFirstName,
                    employeeLastName: employee.employeeLastName,
                    designation: employee.designation,
                }
            );
            setUpdated(true);
        } catch (error) {
            console.error("Error updating employee:", error);
            setUpdated(false);
        }
    };

    return (
        <div>
            <div className="main-title">Update Employee Details</div>
            <form className="employee-form" onSubmit={handleSubmit}>
                <div className="input-section">
                    <label>
                        Employee ID:
                        <input
                            className="input-field"
                            type="text"
                            name="employeeId"
                            value={employee.employeeId}
                            onChange={handleChange}
                            required
                        />
                    </label>
                </div>
                <div className="input-section">
                    <label>
                        First Name:
                        <input
                            className="input-field"
                            type="text"
                            name="employeeFirstName"
                            value={employee.employeeFirstName}
                            onChange={handleChange}
                        />
                    </label>
                </div>
                <div className="input-section">
                    <label>
                        Last Name:
                        <input
                            className="input-field"
                            type="text"
                            name="employeeLastName"
                            value={employee.employeeLastName}
                            onChange={handleChange}
                        />
                    </label>
                </div>
                <div className="input-section">
                    <label>
                        Designation:
                        <input
                            className="input-field"
                            type="text"
                            name="designation"
                            value={employee.designation}
                            onChange={handleChange}
                        />
                    </label>
                </div>
                <button className="submit-btn" type="submit">
                    Update Employee
                </button>
            </form>
            <div className="employee-details-container">
                {updated === true && (
                    <p className="success-message">
                        Employee successfully updated
                    </p>
                )}
                {updated === false && (
                    <p className="error-message">Failed to update employee</p>
                )}
            </div>
        </div>
    );
};

export default PutEmployeePage;
