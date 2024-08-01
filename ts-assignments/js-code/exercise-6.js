"use strict";
class Add {
    calculate(x, y) {
        return x + y;
    }
}
class Subtract {
    calculate(x, y) {
        return x - y;
    }
}
class Multiply {
    calculate(x, y) {
        return x * y;
    }
}
class Divide {
    calculate(x, y) {
        return x / y;
    }
}
let add = new Add();
let subtract = new Subtract();
let multiply = new Multiply();
let divide = new Divide();
console.log(add.calculate(10, 5));
console.log(subtract.calculate(10, 5));
console.log(multiply.calculate(10, 5));
console.log(divide.calculate(10, 5));
