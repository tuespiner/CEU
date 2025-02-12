import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, RouterModule } from '@angular/router';
import { Usuario } from '../Model/Usuario.model';
import { UsuariosServiceService } from '../services/usuarios-service.service';
import { Observable } from 'rxjs';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-usuario-detalle',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './usuario-detalle.component.html',
  styleUrl: './usuario-detalle.component.css'
})
export class UsuarioDetalleComponent implements OnInit{
  usuario$= new Observable<Usuario>()
  constructor( private act: ActivatedRoute, private service: UsuariosServiceService){}
  ngOnInit(): void {
    this.usuario$ = this.service.getUsuarioId(this.act.snapshot.params['id'])
    console.log(this.usuario$)
  }
}
