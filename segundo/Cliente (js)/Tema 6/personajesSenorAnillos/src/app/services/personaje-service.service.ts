import { Inject, Injectable } from '@angular/core';
import { personaje } from '../model/personaje';

@Injectable({
  providedIn: 'root'
})
export class PersonajeServiceService {
  listaPersonajes: personaje[] = []
  constructor() {}

  getPersonajes(){
    return this.listaPersonajes
  }

  addPersonaje(personaje: personaje){
    personaje = this.getIdRecursivo(personaje)
    this.listaPersonajes.push(personaje)
  }

  getIdRecursivo(personaje: personaje){
    let lista = this.getPersonajes()
    let idGrande = 0
    lista.forEach((personajeLista) => {
      if(personajeLista.id > idGrande){
        idGrande = personajeLista.id
      }
    })
    personaje.id = idGrande + 1
    return personaje
  }

  removePesronaje(id: number){
    this.listaPersonajes.filter((personajeLista) => personajeLista.id !== id)
  }
}
