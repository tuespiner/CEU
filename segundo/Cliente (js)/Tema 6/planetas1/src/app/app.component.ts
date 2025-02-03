import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Observable } from 'rxjs';
import { PlanetService } from './services/planet.service';
import { FormsModule, NgModel } from '@angular/forms';
import { planet } from './model/planet';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet,  FormsModule, CommonModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit{
  planetService$ = new Observable<planet>()
  constructor(private planetService: PlanetService){}
  ngOnInit(): void {
    this.planetService$ = this.planetService.getListPlanets();
  }
  
  title = 'planetas1';
}
