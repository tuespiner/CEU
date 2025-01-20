import { Component } from '@angular/core';

@Component({
  selector: 'app-alumno',
  standalone: true,
  imports: [],
  templateUrl: './alumno.component.html',
  styleUrl: './alumno.component.css'
})
export class AlumnoComponent {
  rojo: String = 'rojo'
  nombre: String = 'juan'
  apellido: String = 'Lopez Carmona'
  edad: number = 19
  dni: String = '78254643H'
  abilitado: Boolean = true
  showAlert(cheked: Boolean){
    if(cheked == true){
      alert(cheked)
    }
  }
}
