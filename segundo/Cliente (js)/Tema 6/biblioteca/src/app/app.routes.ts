import { Component } from '@angular/core';
import { Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { HomeComponentComponent } from './home-component/home-component.component';
import { LibrosComponent } from './libros/libros.component';
import { ContactoComponent } from './contacto/contacto.component';

export const routes: Routes = [
    { path:'', component:AppComponent},
    { path:'home', component:HomeComponentComponent},
    { path:'libros', component:LibrosComponent},
    { path:'contacto', component:ContactoComponent},
    { path:'**', redirectTo:'/home'}
];
