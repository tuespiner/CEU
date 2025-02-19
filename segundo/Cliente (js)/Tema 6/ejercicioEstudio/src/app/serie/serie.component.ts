import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { SerieServicioService } from '../services/serie-servicio.service';

@Component({
  selector: 'app-serie',
  imports: [],
  templateUrl: './serie.component.html',
  styleUrl: './serie.component.css'
})
export class SerieComponent implements OnInit{
  $serie = new Observable<any>()
  constructor (private servicio: SerieServicioService){}
  ngOnInit(): void {
    
  }
}
