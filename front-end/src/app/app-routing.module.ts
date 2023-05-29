import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AccueilComponent } from './accueil/accueil.component';
import { LoginComponent } from './login/login.component';
import { ProfilComponent } from './profil/profil.component';

const routes: Routes = [
  {path:'',title:'Accueil',component:AccueilComponent},
  {path:'accueil',title:'Accueil',component:AccueilComponent},
  {path:'login',title:'login',component:LoginComponent},
  {path:'profil',title:'profil',component:ProfilComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
