import { Component } from '@angular/core';

@Component({
  selector: 'app-user-profile',
  standalone: true,
  imports: [],
  templateUrl: './user-profile.component.html',
  styleUrl: './user-profile.component.css'
})
export class UserProfileComponent {
  nombre: String = 'Juanito'
  rol: String = 'CEO'
  titulo: String = 'Componente User'
  title: String = 'holii'
  
}
