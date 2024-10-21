const salarios = {Jhon: 100, Ann: 160, Peter: 130};

let sumaSal = 0;
for(let sal in salarios){
    var sala = Number(salarios[sal]);
    console.log(sala);
    if(sala == null){
        sumaSal += 0;
    }else{
        sumaSal += sala;
    }
}
console.log(sumaSal);