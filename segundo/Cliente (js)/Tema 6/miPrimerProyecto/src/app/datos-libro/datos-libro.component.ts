import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-datos-libro',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './datos-libro.component.html',
  styleUrl: './datos-libro.component.css'
})
export class DatosLibroComponent {
  titulo: string = 'titulo datos libro'
  @Input()
  queLibro: string = ''
  libro1={
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
  libro2={
    titulo: 'titulo2',
    autor: 'autor2',
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
  array:any[] = [this.libro1, this.libro2]
  @Output()
  selected = new EventEmitter<any>()

  mostrarTitulo(){
    if(this.queLibro == '1'){
      this.selected.emit(this.libro1.titulo)
    }else if(this.queLibro == '2'){
      this.selected.emit(this.libro2.titulo)
    }
  }
}
