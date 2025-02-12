import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, RouterModule } from '@angular/router';
import { libro } from '../model/libro.model';
import { CommonModule } from '@angular/common';
import { LibroServiceService } from '../services/libro-service.service';

@Component({
  selector: 'app-libro-detalle',
  imports: [CommonModule, RouterModule],
  templateUrl: './libro-detalle.component.html',
  styleUrl: './libro-detalle.component.css'
})
export class LibroDetalleComponent implements OnInit {
  libro: any
  constructor( private act: ActivatedRoute, private service : LibroServiceService){}
  ngOnInit(): void {
    this.libro = this.service.getLibro(this.act.snapshot.params['id'])[0]
  }
}
