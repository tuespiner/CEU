import { Component, OnInit } from '@angular/core';
import { PlanetService } from '../services/planet.service';
import { Observable } from 'rxjs';
import { result } from '../model/planet';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-planet-detail',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './planet-detail.component.html',
  styleUrl: './planet-detail.component.css'
})
export class PlanetDetailComponent implements OnInit{
  planetDetail$ = new Observable<result>()
  constructor(private planetService: PlanetService){}
  ngOnInit(): void {
    this.planetDetail$ = this.planetService.getPlanet()
  }
}
