import { Component, Output } from '@angular/core';
import { EventEmitter } from 'stream';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-caracteristicas-articulo',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './caracteristicas-articulo.component.html',
  styleUrl: './caracteristicas-articulo.component.css'
})
export class CaracteristicasArticuloComponent {
  @Output()
  selected = new EventEmitter<any>()
  caracteristica: string = ''
  enviarCaracteristica(){
    this.selected.emit(this.caracteristica)
  }
}
