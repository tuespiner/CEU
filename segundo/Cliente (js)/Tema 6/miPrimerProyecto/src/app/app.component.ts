import { ReturnStatement } from '@angular/compiler';
import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { AlumnoComponent } from './alumno/alumno.component';

@Component({
  selector: 'app-hola',
  standalone: true,
  imports: [RouterOutlet, UserProfileComponent, AlumnoComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title:string = 'Hola Belen';
  nombre:string = 'Juan';
  edad:number = 19;

  getEdad():number {
    return this.edad
  }

  name: String = 'juan'
  src: String = './images.jfif'
  naranja: String = 'naranja'
  chekeado: Boolean = true
  disabilitado: Boolean = true
  asignatura = {
    nombre: 'Desarrollo Entorno Cliente',
    codigo: '1'
  }
}
