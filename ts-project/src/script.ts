interface Todo {
    id: number;
    text: string;
    completed: boolean;
}

const todos: Todo[] = [];

const newTodoInput = document.getElementById("new-todo") as HTMLInputElement;
const addTodoButton = document.getElementById("add-todo") as HTMLButtonElement;
const todoList = document.getElementById("todo-list") as HTMLUListElement;

addTodoButton.addEventListener("click", () => {
    const text = newTodoInput.value.trim();
    if (text !== "") {
        addTodo(text);
        newTodoInput.value = "";
    }
});

function addTodo(text: string): void {
    const newTodo: Todo = {
        id: Date.now(),
        text: text,
        completed: false,
    };
    todos.push(newTodo);
    renderTodos();
}

function renderTodos(): void {
    todoList.innerHTML = "";
    todos.forEach((todo) => {
        const li = document.createElement("li");
        li.textContent = todo.text;
        todoList.appendChild(li);
    });
}
