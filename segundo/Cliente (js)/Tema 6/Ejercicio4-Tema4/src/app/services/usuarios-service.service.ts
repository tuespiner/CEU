import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Usuario } from '../Model/Usuario.model';

@Injectable({
  providedIn: 'root'
})
export class UsuariosServiceService {
  url: string = "https://jsonplaceholder.typicode.com/users"

  constructor(private http: HttpClient) { }

  getUsuarios(){
    return this.http.get<Usuario>(this.url)
  }
}
