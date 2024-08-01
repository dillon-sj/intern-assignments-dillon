"use strict";
var DaysOfTheWeek;
(function (DaysOfTheWeek) {
    DaysOfTheWeek[DaysOfTheWeek["Monday"] = 1] = "Monday";
    DaysOfTheWeek[DaysOfTheWeek["Tuesday"] = 2] = "Tuesday";
    DaysOfTheWeek[DaysOfTheWeek["Wednesday"] = 3] = "Wednesday";
    DaysOfTheWeek[DaysOfTheWeek["Thursday"] = 4] = "Thursday";
    DaysOfTheWeek[DaysOfTheWeek["Friday"] = 5] = "Friday";
    DaysOfTheWeek[DaysOfTheWeek["Saturday"] = 6] = "Saturday";
    DaysOfTheWeek[DaysOfTheWeek["Sunday"] = 7] = "Sunday";
})(DaysOfTheWeek || (DaysOfTheWeek = {}));
function getDayName(day) {
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
