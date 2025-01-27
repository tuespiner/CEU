import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-alumno',
  standalone: true,
  imports: [FormsModule],
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
      this.antesDePulsar = 'check pulsado'
    }else{
      this.antesDePulsar = ''
    }
  }
  antesDePulsar: String = ''
  nombreCompi: string = ''
  ponerNombre(){
    this.nombreCompi = 'Juan'
  }
  texto: string = ''
  cambiarTexto(event: any){
    this.texto = event.target.value()
  }
}
