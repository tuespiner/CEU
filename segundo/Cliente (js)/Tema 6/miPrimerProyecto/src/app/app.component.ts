import { ReturnStatement } from '@angular/compiler';
import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-hola',
  standalone: true,
  imports: [RouterOutlet],
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

}
