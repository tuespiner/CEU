import { Component } from '@angular/core';
import {FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { ListadoArticuloComponent } from '../listado-articulo/listado-articulo.component';


export interface Articulo{
  nombre: string
  precio: string
  unidades: string
}


@Component({
  selector: 'app-articulo',
  standalone: true,
  imports: [FormsModule, CommonModule,RouterOutlet, ListadoArticuloComponent],
  templateUrl: './articulo.component.html',
  styleUrl: './articulo.component.css'
})
export class ArticuloComponent {
  nombre: string = ''
  precio: string = ''
  unidades: string = ''
  articulos: Articulo[]=[
    {
      nombre: 'articulo1',
      precio: '3',
      unidades: '4'
    },
    {
      nombre: 'articulo2',
      precio: '23',
      unidades: '1'
    },
    {
      nombre: 'articulo3',
      precio: '8',
      unidades: '40'
    }
  ]
  crearArticulo(){
    this.articulos.push({
      nombre: this.nombre,
      precio: this.precio,
      unidades: this.unidades
    })
  }
}
