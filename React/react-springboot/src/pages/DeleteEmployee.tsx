import axios from "axios";
import { useState, useCallback } from "react";

const DeleteEmployeePage: React.FC = () => {
    const [employeeId, setEmployeeId] = useState<string>("");
    const [message, setMessage] = useState<string | null>(null);

    const url = `http://localhost:8080/api/employees/${employeeId}`;

    const deleteEmployee = useCallback(async () => {
        try {
            await axios.delete(url);
            setMessage("Employee successfully deleted");
        } catch (error) {
            console.error("Error deleting employee", error);
            setMessage("Error deleting employee");
        }
    }, [employeeId]);

    return (
        <div>
            <h1>Delete Employee By ID</h1>
            <input
                type="text"
                value={employeeId}
                onChange={(e) => setEmployeeId(e.target.value)}
                placeholder="Enter Employee ID to delete"
            />
            <button onClick={deleteEmployee}>Delete Employee</button>
            {message && <p>{message}</p>}
        </div>
    );
};

export default DeleteEmployeePage;
