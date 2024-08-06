"use strict";
function printUserInfo(user) {
    console.log(`Name: ${user.name}, Age: ${user.age}, Email: ${user.email}`);
}
const userTest = {
    name: "John",
    age: 25,
    email: "john@gmail.com",
};
printUserInfo(userTest);
