interface MathOperations {
    calculate(x: Number, y: Number): Number;
}

class Add implements MathOperations {
    calculate(x: number, y: number): number {
        return x + y;
    }
}

class Subtract implements MathOperations {
    calculate(x: number, y: number): number {
        return x - y;
    }
}

class Multiply implements MathOperations {
    calculate(x: number, y: number): number {
        return x * y;
    }
}

class Divide implements MathOperations {
    calculate(x: number, y: number): number {
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
