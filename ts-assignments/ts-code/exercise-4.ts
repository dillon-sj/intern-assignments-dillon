function combine<T, U>(param1: T, param2: U): string {
    return `${param1} ${param2}`;
}

console.log(combine("Hello, ", "World!"));
console.log(combine(2, 1));
