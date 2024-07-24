interface Todo {
    id: number;
    title: string;
    completed: boolean;
}

const todos: Todo[] = [];

const newTodo = document.querySelector(".new-todo") as HTMLInputElement;
const addTodoBtn = document.querySelector(".add-todo") as HTMLButtonElement;
const todoList = document.querySelector(".todo-list") as HTMLUListElement;

addTodoBtn.addEventListener("click", () => {
    const title = newTodo.value.trim();
    if (title != "") {
        addTodo(title);
        newTodo.value = "";
    }
});

let addTodo = (title: string) => {
    const todo: Todo = {
        id: Date.now(),
        title: title,
        completed: false,
    };
    todos.push(todo);
    renderTodo();
};

let renderTodo = (): void => {
    todoList.innerHTML = "";
    todos.forEach((todo) => {
        const li = document.createElement("li");
        li.textContent = todo.title;
    });
};
