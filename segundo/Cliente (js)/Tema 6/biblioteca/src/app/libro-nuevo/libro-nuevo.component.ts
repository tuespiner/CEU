import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';
import { LibroServiceService } from '../services/libro-service.service';
import { libro } from '../model/libro.model';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-libro-nuevo',
  imports: [CommonModule, RouterModule, FormsModule],
  templateUrl: './libro-nuevo.component.html',
  styleUrl: './libro-nuevo.component.css'
})
export class LibroNuevoComponent {
  libro: libro={id:0, titulo:'', autor:''}
  constructor(private service: LibroServiceService){}
  darAlta(){
    this.service.darAlta(this.libro)
  }
}
