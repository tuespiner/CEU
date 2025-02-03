import { Injectable } from '@angular/core';
import { personaje } from '../model/personaje';

@Injectable({
  providedIn: 'root'
})
export class PersonajeServiceService {

  constructor(private listaPersonajes: personaje[] = [{
    nombre: 'juan',
    raza: 'si'
  },{
    nombre: 'pablo',
    raza: 'no'
  }
]) { }

  getPersonajes(){
    return this.listaPersonajes
  }

  addPersonaje(personaje: personaje){
    this.listaPersonajes.push(personaje)
  }

  removePesronaje(personaje: personaje){
    this.listaPersonajes.filter((personajeLista) => personajeLista != personaje)
  }
}
