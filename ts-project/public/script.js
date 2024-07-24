var todos = [];
var newTodo = document.querySelector(".new-todo");
var addTodoBtn = document.querySelector(".add-todo");
var todoList = document.querySelector(".todo-list");
addTodoBtn.addEventListener("click", function () {
    var title = newTodo.value.trim();
    if (title != "") {
        addTodo(title);
        newTodo.value = "";
    }
});
var addTodo = function (title) {
    var todo = {
        id: Date.now(),
        title: title,
        completed: false,
    };
    todos.push(todo);
    renderTodo();
};
var renderTodo = function () {
    todoList.innerHTML = "";
    todos.forEach(function (todo) {
        var li = document.createElement("li");
        li.textContent = todo.title;
    });
};
