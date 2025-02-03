import { Component } from '@angular/core';
import { ListaPersonajesComponent } from '../lista-personajes/lista-personajes.component';
import { AgregarPersonajeComponent } from '../agregar-personaje/agregar-personaje.component';

@Component({
  selector: 'app-main',
  standalone: true,
  imports: [ListaPersonajesComponent, AgregarPersonajeComponent],
  templateUrl: './main.component.html',
  styleUrl: './main.component.css'
})
export class MainComponent {

}
