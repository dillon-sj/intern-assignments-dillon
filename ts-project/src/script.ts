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

        const deleteButton = document.createElement("button");
        deleteButton.textContent = "Delete";
        deleteButton.classList.add("delete-btn");
        deleteButton.addEventListener("click", () => deleteTodo(todo.id));
        li.appendChild(deleteButton);

        const checkbox = document.createElement("input");
        checkbox.type = "checkbox";
        checkbox.checked = todo.completed;
        checkbox.addEventListener("change", () => toggleCompletion(todo.id));
        li.prepend(checkbox);

        todoList.appendChild(li);
    });
}

function deleteTodo(id: number): void {
    const index = todos.findIndex((todo) => todo.id === id);
    if (index !== -1) {
        todos.splice(index, 1);
        renderTodos();
    }
}

function toggleCompletion(id: number): void {
    const todo = todos.find((todo) => todo.id === id);
    if (todo) {
        todo.completed = !todo.completed;
        renderTodos();
    }
}
