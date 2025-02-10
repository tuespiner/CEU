import { Injectable } from '@angular/core';
import { libro } from '../model/libro.model';

@Injectable({
  providedIn: 'root'
})
export class LibroServiceService {
  libros: libro[]
  constructor() { 
    this.libros = [
      {
        id: 1,
        titulo: "titulo1",
        autor: "autor1"
      },{
        id: 2,
        titulo: "titulo2",
        autor: "autor2"
      },{
        id:3,
        titulo: "titulo3",
        autor: "autor3"
      },{
        id: 4,
        titulo: "titulo4",
        autor: "autor4"
      }
    ]
  }

  getLibros(){
    return this.libros
  }

  getLibro(id:number){
    return this.libros.filter((libro) => libro.id == id)
  }
}
