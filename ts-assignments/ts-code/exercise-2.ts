function reverseArray<T>(array: T[]): T[] {
    return array.reverse();
}

let array = [1, 2, 3, 4, 5];
let array2 = ["a", 2, "B", 4, "C"];
let reversedarray = reverseArray(array2);
console.log(reversedarray);
