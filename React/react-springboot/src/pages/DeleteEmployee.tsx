import axios from "axios";
import { useState } from "react";

const DeleteEmployee: React.FC = () => {
    const [employeeId, setEmployeeId] = useState<string>("");
    const [deleted, setDeleted] = useState<boolean | null>(null);

    const deleteEmployeeById = async () => {
        try {
            await axios.delete(
                `http://localhost:8080/api/employees/${employeeId}`
            );
            setDeleted(true);
        } catch (error) {
            console.error("Error deleting employee:", error);
            setDeleted(false);
        }
    };

    return (
        <div>
            <div className="main-title">Delete Employee By ID</div>
            <div className="input-section">
                <input
                    className="input-field"
                    type="text"
                    value={employeeId}
                    onChange={(e) => setEmployeeId(e.target.value)}
                    placeholder="Enter an Employee ID"
                />
                <button className="submit-btn" onClick={deleteEmployeeById}>
                    Delete Employee
                </button>
            </div>
            <div className="employee-details-container">
                {deleted === true && (
                    <p className="success-message">
                        Employee successfully deleted
                    </p>
                )}
                {deleted === false && (
                    <p className="error-message">Failed to delete employee</p>
                )}
            </div>
        </div>
    );
};

export default DeleteEmployee;
