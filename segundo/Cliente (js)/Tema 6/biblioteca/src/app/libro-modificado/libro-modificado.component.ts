import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, RouterModule } from '@angular/router';
import { LibroServiceService } from '../services/libro-service.service';

@Component({
  selector: 'app-libro-modificado',
  imports: [CommonModule, RouterModule, FormsModule],
  templateUrl: './libro-modificado.component.html',
  styleUrl: './libro-modificado.component.css'
})
export class LibroModificadoComponent implements OnInit{
  libro: any
  constructor( private service : LibroServiceService,  private act: ActivatedRoute){}
   ngOnInit(): void {
    this.libro = this.service.getLibro(this.act.snapshot.params['id'])[0]
  }
  modificar(){
    this.service.modificar(this.libro)
  }
}
