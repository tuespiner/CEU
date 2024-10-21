function palabra(){
    let palabra = "";
    do{
        palabra = prompt("Dime una palabra que no este vacía");
    }while(palabra == "");

    console.log(palabra);
    let palabraSplit = palabra.split("");
    let reves = "";
    palabraSplit.forEach((letra) =>{
        reves = `${letra}${reves}`;
    })
    console.log(reves);
}
palabra();