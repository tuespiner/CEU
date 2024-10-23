var user = {};
user.name = "Jhon";
console.log(user);
setTimeout(user.surname = "Smith", 1000);
console.log(user)
user.name = "Peter";
console.log(user)
delete user.name;
console.log(user);