interface Animal {
    name: string;
    age: number;
    sound: string;
}

interface Fish {
    name: string;
    age: number;
    waterType: string;
}

function printPet(pet: Animal | Fish): void {
    console.log(`Name: ${pet.name}`);
    console.log(`Age: ${pet.age}`);

    if ("sound" in pet) {
        console.log(`Sound: ${pet.sound}`);
    }

    if ("waterType" in pet) {
        console.log(`Water Type: ${pet.waterType}`);
    }
}

const dog: Animal = { name: "Buddy", age: 5, sound: "Woof" };
const goldfish: Fish = { name: "Goldie", age: 2, waterType: "Freshwater" };

printPet(dog);
printPet(goldfish);
