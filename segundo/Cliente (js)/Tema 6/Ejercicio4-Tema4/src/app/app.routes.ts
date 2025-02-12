import { Routes } from '@angular/router';
import { NavComponent } from './nav/nav.component';
import { HomeComponent } from './home/home.component';
import { ListaUsuarioComponent } from './lista-usuario/lista-usuario.component';

export const routes: Routes = [
    {path:"", component:HomeComponent},
    {path:"home", component:HomeComponent},
    {path:"usuarios", component:ListaUsuarioComponent},
    {path:"**", redirectTo:"home"}
];
