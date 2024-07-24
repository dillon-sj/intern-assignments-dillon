"use strict";
const todos = [];
const newTodoInput = document.getElementById("new-todo");
const addTodoButton = document.getElementById("add-todo");
const todoList = document.getElementById("todo-list");
addTodoButton.addEventListener("click", () => {
    const text = newTodoInput.value.trim();
    if (text !== "") {
        addTodo(text);
        newTodoInput.value = "";
    }
});
function addTodo(text) {
    const newTodo = {
        id: Date.now(),
        text: text,
        completed: false,
    };
    todos.push(newTodo);
    renderTodos();
}
function renderTodos() {
    todoList.innerHTML = "";
    todos.forEach((todo) => {
        const li = document.createElement("li");
        li.textContent = todo.text;
        todoList.appendChild(li);
    });
}
