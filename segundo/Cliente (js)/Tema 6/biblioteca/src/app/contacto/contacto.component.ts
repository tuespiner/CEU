import { Component } from '@angular/core';
import { LibreriaDireccionServiceService } from '../services/libreria-direccion-service.service';
import { libreriaDireccion } from '../model/libreriaDireccino.model';

@Component({
  selector: 'app-contacto',
  imports: [],
  templateUrl: './contacto.component.html',
  styleUrl: './contacto.component.css'
})
export class ContactoComponent{
  direccion: libreriaDireccion
  constructor(private service: LibreriaDireccionServiceService){
    this.direccion = this.service.getDireccionLibreria()
  }
}
