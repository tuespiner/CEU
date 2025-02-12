import { Component } from '@angular/core';
import { Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { HomeComponentComponent } from './home-component/home-component.component';
import { LibrosComponent } from './libros/libros.component';
import { ContactoComponent } from './contacto/contacto.component';
import { LibroDetalleComponent } from './libro-detalle/libro-detalle.component';
import { LibroNuevoComponent } from './libro-nuevo/libro-nuevo.component';
import { LibroModificadoComponent } from './libro-modificado/libro-modificado.component';

export const routes: Routes = [
    { path:'', component:HomeComponentComponent},
    { path:'home', component:HomeComponentComponent},
    { path:'libros', component:LibrosComponent},
    { path:'contacto', component:ContactoComponent},
    { path:'libro-detalle/:id', component:LibroDetalleComponent},
    { path:'libro-nuevo', component:LibroNuevoComponent},
    { path:'libro-modificado/:id', component:LibroModificadoComponent},
    { path:'**', redirectTo:'/home'}
];
