import axios from "axios";
import { useState } from "react";
import "./pageStyle.css";

interface Employee {
    employeeId: string;
    employeeFirstName: string;
    employeeLastName: string;
    employeeGender: string;
    designation: string;
}

const PostEmployeePage: React.FC = () => {
    const [employee, setEmployee] = useState<Employee>({
        employeeId: "",
        employeeFirstName: "",
        employeeLastName: "",
        employeeGender: "",

        designation: "",
    });
    const [posted, setPosted] = useState<boolean | null>(null);

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
            await axios.post("http://localhost:8080/api/employees", employee);
            setPosted(true);
        } catch (error) {
            console.error("Error posting employee:", error);
            setPosted(false);
        }
    };

    return (
        <div>
            <div className="main-title">Add New Employee</div>
            <div className="form-holder">
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
                                required
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
                                required
                            />
                        </label>
                    </div>
                    <div className="input-section">
                        <label>
                            Gender:
                            <input
                                className="input-field"
                                type="text"
                                name="employeeGender"
                                value={employee.employeeGender}
                                onChange={handleChange}
                                required
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
                                required
                            />
                        </label>
                    </div>
                    <button className="submit-btn" type="submit">
                        Add Employee
                    </button>
                </form>
            </div>
            <div className="employee-details-container">
                {posted === true && (
                    <p className="success-message">
                        Employee successfully added
                    </p>
                )}
                {posted === false && (
                    <p className="error-message">Failed to add employee</p>
                )}
            </div>
        </div>
    );
};

export default PostEmployeePage;
