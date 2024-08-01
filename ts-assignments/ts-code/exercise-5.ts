enum DaysOfTheWeek {
    Monday = 1,
    Tuesday,
    Wednesday,
    Thursday,
    Friday,
    Saturday,
    Sunday,
}

function getDayName(day: DaysOfTheWeek): string {
    switch (day) {
        case DaysOfTheWeek.Monday:
            return "Monday";
        case DaysOfTheWeek.Tuesday:
            return "Tuesday";
        case DaysOfTheWeek.Wednesday:
            return "Wednesday";
        case DaysOfTheWeek.Thursday:
            return "Thursday";
        case DaysOfTheWeek.Friday:
            return "Friday";
        case DaysOfTheWeek.Saturday:
            return "Saturday";
        case DaysOfTheWeek.Sunday:
            return "Sunday";
        default:
            return "Invalid day";
    }
}

console.log(getDayName(DaysOfTheWeek.Monday));
console.log(getDayName(DaysOfTheWeek.Tuesday));
