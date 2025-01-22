import { Component, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-user-profile',
  standalone: true,
  imports: [],
  templateUrl: './user-profile.component.html',
  styleUrl: './user-profile.component.css'
})
export class UserProfileComponent {
  @Input() //para que puedas poner los parametros en el padre
  nombre: string = 'Juanito'
  @Input()
  rol: String = 'CEO'
  titulo: String = 'Componente User'
  title: String = 'holii'
  @Output()
  selected = new EventEmitter<string>();
  
  seleccionar(){
    this.selected.emit(this.nombre)
  }
}

