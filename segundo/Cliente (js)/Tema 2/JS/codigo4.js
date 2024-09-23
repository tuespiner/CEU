var var1 = 'mundo';
var var2 = 'hola mundo';
console.log(var2.indexOf(var1.substring(0,1)));
var2 = var2.replace('mundo', 'universo');
console.log(var2.toUpperCase());
console.log(var2.toLocaleLowerCase());
console.log("Juan " + "López Carmona");
var var3 = 'Cliente';
console.log(var3.substring(0, var3.indexOf('i') + 1));
console.log(var3.substring(var3.indexOf('e'), var3.lastIndexOf('e') + 1))