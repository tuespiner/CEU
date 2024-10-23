var factura ={
    numero: 1, 
    cliente: "cliente1", 
    divisa: "€", 
    subtotal: 100, 
    IVA: (factura.subtotal * 0.21), 
    importe: () =>{
        return factura.subtotal + factura.IVA;
    }};

    console.log(`La factura ${factura.numero} tiene un importe de ${factura.importe}${factura.divisa}`)