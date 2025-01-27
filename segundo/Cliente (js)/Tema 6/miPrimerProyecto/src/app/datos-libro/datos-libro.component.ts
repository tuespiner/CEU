import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-datos-libro',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './datos-libro.component.html',
  styleUrl: './datos-libro.component.css'
})
export class DatosLibroComponent {
  titulo: string = 'titulo datos libro'
  libro={
    titulo: 'titulo',
    autor: 'autor',
    precio: 10,
    stock: 200,
    cantidad: 10,
    imagen: '../images.jfif',
    aumentaDisminuye(texto:string){
      if(texto == '+'){
        this.cantidad++
      }else if(this.cantidad > 0){
        this.cantidad--
      }
    },
    imprimirPosicion(posicion: any){
      console.log(posicion.clientX)
      console.log(posicion.clientY)
    }
    
  }
}
