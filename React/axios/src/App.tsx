import React, { useEffect, useState } from "react";
import "./App.css";
import axios from "axios";

export type User = {
    userId: number;
    id: number;
    title: string;
    completed: boolean;
};

function App() {
    const [users, setUsers] = useState<User[]>([]);
    useEffect(() => {
        const url = "https://jsonplaceholder.typicode.com/todos";

        const getUsers = async () => {
            const response: any = await axios.get(url);
            console.log(response.data);
            setUsers(response.data);
        };

        getUsers();

        // axios.get(url).then((response) => {
        //     setUsers(response.data);
        // });
    }, []);

    return (
        <div>
            {users
                ? users.map((user) => {
                      return <p>{user.title}</p>;
                  })
                : null}
        </div>
    );
}

export default App;
