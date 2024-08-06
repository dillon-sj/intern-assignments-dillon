interface User {
    name: String;
    age: Number;
    email: String;
}

function printUserInfo(user: User): void {
    console.log(`Name: ${user.name}, Age: ${user.age}, Email: ${user.email}`);
}

const userTest: User = {
    name: "John",
    age: 25,
    email: "john@gmail.com",
};

printUserInfo(userTest);
