import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { url } from 'inspector';
import { planet, result } from '../model/planet';

@Injectable({
  providedIn: 'root'
})
export class PlanetService {
  constructor(private http: HttpClient) {}

  getListPlanets(paginas: number = 1){
    let url = `https://swapi.dev/api/planets/?page=${paginas}`
    return this.http.get<planet>(url)
  }

  getPlanet(num: number = 1){
    let url = `https://swapi.dev/api/planets/${num}`
    return this.http.get<result>(url)
  }
}
