import { Component, OnInit } from '@angular/core';
import { LibroServiceService } from '../services/libro-service.service';
import { libro } from '../model/libro.model';
import { CommonModule } from '@angular/common';
import { RouterModule, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-libros',
  imports: [CommonModule, RouterModule],
  templateUrl: './libros.component.html',
  styleUrl: './libros.component.css'
})
export class LibrosComponent implements OnInit{
  libroList$: libro[] = []
constructor( private service : LibroServiceService){}
  ngOnInit(): void {
    this.libroList$ = this.service.getLibros()
  }

}
