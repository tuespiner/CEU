import { Injectable } from '@angular/core';
import { libreriaDireccion } from '../model/libreriaDireccino.model';

@Injectable({
  providedIn: 'root'
})
export class LibreriaDireccionServiceService {
  direccion: libreriaDireccion
  constructor() {
    this.direccion = {
      id: 1,
      calle:'San Francisco Javier n13',
      ciudad: 'sevilla',
      codigoPostal: 41807
    }
   }

   getDireccionLibreria(){
    return this.direccion
   }
}
