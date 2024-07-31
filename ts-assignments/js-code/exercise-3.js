"use strict";
function printPet(pet) {
    console.log(`Name: ${pet.name}`);
    console.log(`Age: ${pet.age}`);
    if ("sound" in pet) {
        console.log(`Sound: ${pet.sound}`);
    }
    if ("waterType" in pet) {
        console.log(`Water Type: ${pet.waterType}`);
    }
}
const dog = { name: "Buddy", age: 5, sound: "Woof" };
const goldfish = { name: "Goldie", age: 2, waterType: "Freshwater" };
printPet(dog);
printPet(goldfish);
