import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AccomodationComponent} from './accomodation/accomodation.component';
import {AccomodationDetailComponent} from './accomodation-detail/accomodation-detail.component';
import {ConnexionComponent} from './connexion/connexion.component';
import {HomeComponent} from "./home/home.component";
import {DashboardComponent} from './dashboard/dashboard.component';
<<<<<<< HEAD
import {AccomodationFormComponent} from "./accomodation-form/accomodation-form.component";
=======
import {BookingFormComponent} from "./booking-form/booking-form.component";
>>>>>>> ed49a14d016b2818d7d81fa6c95828c1ba780b4f


const routes: Routes = [
  {path: 'accomodation', component: AccomodationComponent},
  {path: 'accomodation-detail', component: AccomodationDetailComponent},
  {path: 'connexion', component: ConnexionComponent},
  {path: 'accomodation-detail/:id', component: AccomodationDetailComponent},
  {path: 'booking-form/:acc_id', component: BookingFormComponent},
  {path: 'home', component: HomeComponent},
  {path: 'dashboard', component: DashboardComponent},
<<<<<<< HEAD

=======
  {path: 'accomodation-form', component: AccomodationFormComponent},
>>>>>>> a557a09154222ce4088ca5c328889dc71200f4e4
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
