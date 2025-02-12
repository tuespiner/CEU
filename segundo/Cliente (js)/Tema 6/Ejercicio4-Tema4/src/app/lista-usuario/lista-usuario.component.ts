import { Component, OnInit } from '@angular/core';
import { UsuariosServiceService } from '../services/usuarios-service.service';
import { Observable } from 'rxjs';
import { Usuario } from '../Model/Usuario.model';

@Component({
  selector: 'app-lista-usuario',
  standalone: true,
  imports: [],
  templateUrl: './lista-usuario.component.html',
  styleUrl: './lista-usuario.component.css'
})
export class ListaUsuarioComponent implements OnInit{
  usuarioList$ = new Observable<Usuario>()
  constructor( private service: UsuariosServiceService){}
  ngOnInit(): void {
    this.usuarioList$ = this.service.getUsuarios()
  }

}
