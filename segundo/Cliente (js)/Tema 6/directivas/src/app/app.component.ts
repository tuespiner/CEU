import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { ArticuloComponent } from './articulo/articulo.component';


export interface Persona{
  nombre: string
  apellidos: string
  edad: number
}


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, FormsModule, CommonModule, ArticuloComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})

export class AppComponent {
  title = 'directivas';
  titulo: string = 'alta usuario'
  nombre: string = ''
  apellidos: string = ''
  pulsado: boolean = false
  mensaje: string = '';
  
  pulsar(){
    this.pulsado = true
    this.mensaje =   'Se ha dado de alta al usuario '+ this.nombre + ' '+ this.apellidos
  }

  personas: Persona[] = [{
    nombre: 'persona1',
    apellidos: 'apellidos1',
    edad: 30
  },
  {
    nombre: 'persona2',
    apellidos: 'apellidos2',
    edad: 20
  }
]
  mensajeBoton: string = 'No ha seleccionado ningun boton'
  botonPulsado(cad: string){
    this.mensajeBoton = `Ha pulsado el boton ${cad}`
  }
}
