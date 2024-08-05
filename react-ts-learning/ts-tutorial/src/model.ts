export interface Todo {
    id: number;
    todo: string;
    isDone: boolean;
}

// type TodoAction =
//     | {type: "ADD_TODO", payload: string}
//     | {type: "REMOVE_TODO", payload: number}
//     | {type: "DONE_TODO", payload: number}

// const TodoReducer = (state: Todo[], action: TodoAction) => {

// };

// import { useReducer } from "react";
// const ReucerExample = () => {
//     const [state, dispatch] = useReducer(TodoReducer, []);
//     return ();

// };
