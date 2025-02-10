import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { libro } from '../model/libro.model';

@Component({
  selector: 'app-libro-detalle',
  imports: [],
  templateUrl: './libro-detalle.component.html',
  styleUrl: './libro-detalle.component.css'
})
export class LibroDetalleComponent implements OnInit {
  libro: libro = {}
  constructor( private act: ActivatedRoute){}
  ngOnInit(): void {
    
  }
}
