import { Component, OnInit } from '@angular/core';
import { PersonajeServiceService } from '../services/personaje-service.service';
import { personaje } from '../model/personaje';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-lista-personajes',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './lista-personajes.component.html',
  styleUrl: './lista-personajes.component.css'
})
export class ListaPersonajesComponent implements OnInit{
  personajes$: personaje[]=[];

  constructor(private servicio: PersonajeServiceService){}
  
  ngOnInit(): void {
    this.personajes$ = this.servicio.getPersonajes()
  }
  
  eliminarPersonaje(id: number){
    this.servicio.removePesronaje(id);
    this.ngOnInit()
  }
}
