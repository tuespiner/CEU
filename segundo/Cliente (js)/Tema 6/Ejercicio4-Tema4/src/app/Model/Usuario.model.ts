export interface Usuario{
    id:number,
    name:string,
    username:string,
    email:string,
    address:{
        street: string,
        suite: string,
        city:string,
        zipCode:string,
        geo:{lat:string,lng:string}
    }
}