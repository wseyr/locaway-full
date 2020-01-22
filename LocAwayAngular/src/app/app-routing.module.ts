import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AccomodationComponent} from './accomodation/accomodation.component';
import {AccomodationDetailComponent} from './accomodation-detail/accomodation-detail.component';
import {ConnexionComponent} from './connexion/connexion.component';
import {HomeComponent} from "./home/home.component";
import {DashboardComponent} from './dashboard/dashboard.component';
import {AccomodationFormComponent} from "./accomodation-form/accomodation-form.component";
import {BookingFormComponent} from "./booking-form/booking-form.component";

import {ReservationsComponent} from './reservations/reservations.component';

import {ConceptComponent} from "./concept/concept.component";



const routes: Routes = [
  {path: 'accomodation', component: AccomodationComponent},
  {path: 'accomodation-detail', component: AccomodationDetailComponent},
  {path: 'connexion', component: ConnexionComponent},
  {path: 'accomodation-detail/:id', component: AccomodationDetailComponent},
  {path: 'booking-form/:acc_id', component: BookingFormComponent},
  {path: 'home', component: HomeComponent},
  {path: 'dashboard', component: DashboardComponent},
  {path: 'accomodation-form', component: AccomodationFormComponent},

  {path: 'reservations', component: ReservationsComponent},

  {path: 'concept', component: ConceptComponent}


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
