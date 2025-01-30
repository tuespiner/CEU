import { CommonModule } from '@angular/common';
import { Component, Input } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterOutlet } from '@angular/router';
import { CaracteristicasArticuloComponent } from '../caracteristicas-articulo/caracteristicas-articulo.component';

@Component({
  selector: 'app-listado-articulo',
  standalone: true,
  imports: [FormsModule, CommonModule,RouterOutlet, CaracteristicasArticuloComponent],
  templateUrl: './listado-articulo.component.html',
  styleUrl: './listado-articulo.component.css'
})
export class ListadoArticuloComponent {
  @Input()
  articulos: any
  caracteristica: string = ''
  seleccionarCaracteristica(event:string){
    this.caracteristica = event
  }
  
}
