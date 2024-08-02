import React from "react";
import { Todo } from "../model";
import { AiFillDelete, AiFillEdit } from "react-icons/ai";
import { MdDone } from "react-icons/md";
import "../components/styles.css";

type Props = {
    todo: Todo;
    todos: Todo[];
    setTodos: React.Dispatch<React.SetStateAction<Todo[]>>;
};

const SingleTodo = ({ todo, todos, setTodos }: Props) => {
    const handleDone = (id: number) => {
        setTodos(
            todos.map((todo) =>
                todo.id === id ? { ...todo, isDone: !todo.isDone } : todo
            )
        );
    };

    return (
        <div>
            <form className="todosSingle">
                {todo.isDone ? (
                    <s className="todosSingleText">{todo.todo}</s>
                ) : (
                    <span className="todosSingleText">{todo.todo}</span>
                )}
                <div>
                    <span className="icon">
                        <AiFillEdit />
                    </span>
                    <span className="icon">
                        <AiFillDelete />
                    </span>
                    <span className="icon" onClick={() => handleDone(todo.id)}>
                        <MdDone />
                    </span>
                </div>
            </form>
        </div>
    );
};

export default SingleTodo;
