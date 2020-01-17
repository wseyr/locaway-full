import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AccomodationComponent} from './accomodation/accomodation.component';
import {AccomodationDetailComponent} from './accomodation-detail/accomodation-detail.component';
import {ConnexionComponent} from './connexion/connexion.component';


const routes: Routes = [
  {path: 'accomodation', component: AccomodationComponent},
  {path: 'accomodation-detail', component: AccomodationDetailComponent},
  {path: 'connexion', component: ConnexionComponent},
  {path: 'accomodation-detail/:id', component: AccomodationDetailComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
