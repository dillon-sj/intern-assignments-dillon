"use strict";
function combine3(value1, value2) {
    if (typeof value1 === "number" && typeof value2 === "number") {
        let concatNumber = parseFloat(value1.toString() + value2.toString());
        return concatNumber + typeof concatNumber;
    }
    else if (Array.isArray(value1) && Array.isArray(value2)) {
        let concatArray = value1.concat(value2);
        return concatArray + typeof concatArray;
    }
    else {
        return value1.toString() + value2.toString();
    }
}
console.log(combine3("Hello, ", "World!"));
console.log(combine3(2, 1));
console.log(combine3("Hello", 1));
console.log(combine3([1, 2, 3], [4, 5, 6]));
console.log(combine3([1, 2, 3], 4));
