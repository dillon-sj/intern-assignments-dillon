function reverseArray<T>(array: T[]): T[] {
    return array.reverse();
}

var array = [1, 2, 3, 4, 5];
var reversedarray = reverseArray(array);
console.log(reversedarray);
