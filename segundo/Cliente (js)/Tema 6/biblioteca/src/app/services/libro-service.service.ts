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

  darAlta(libro:libro){
    libro.id = this.getId()
    this.libros.push(libro)
  }
  getId(): number{
    let id = 0
    this.libros.forEach((libro) => {
      if(libro.id > id){
        id = libro.id
      }
    })
    return id + 1
  }
  modificar(libro:libro){
    this.libros.filter((libroLista) => libroLista.id != libro.id)[0] = libro
  }
}
