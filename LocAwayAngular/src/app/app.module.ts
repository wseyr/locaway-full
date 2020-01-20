import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpClientModule} from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { AngularFontAwesomeModule } from 'angular-font-awesome';
import { AccomodationComponent } from './accomodation/accomodation.component';
import {FormsModule} from '@angular/forms';
import {AppConfigService} from "./app-config.service";
import {AccomodationHttpService} from "./accomodation/accomodation-http.service";
import { AccomodationDetailComponent } from './accomodation-detail/accomodation-detail.component';
import {UserHttpServiceService} from './user/user-http-service.service';
import {BookmarkHttpService} from './bookmark/bookmark-http-service.service';
import {BookingHttpService} from './booking/booking-http-service.service';
import {ContactHttpService} from './contact/contact-http-service.service';
import { ConnexionComponent } from './connexion/connexion.component';
import { HomeComponent } from './home/home.component';
import { DashboardComponent } from './dashboard/dashboard.component';
<<<<<<< HEAD
import { AccomodationFormComponent } from './accomodation-form/accomodation-form.component';
=======
import { BookingFormComponent } from './booking-form/booking-form.component';
>>>>>>> ed49a14d016b2818d7d81fa6c95828c1ba780b4f



@NgModule({
  declarations: [
    AppComponent,
    AccomodationComponent,
    AccomodationDetailComponent,
    ConnexionComponent,
    HomeComponent,
    DashboardComponent,
<<<<<<< HEAD
    AccomodationFormComponent,
=======
    BookingFormComponent,
>>>>>>> ed49a14d016b2818d7d81fa6c95828c1ba780b4f

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    AngularFontAwesomeModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [AppConfigService, AccomodationHttpService, UserHttpServiceService, BookmarkHttpService, BookingHttpService, ContactHttpService],
  bootstrap: [AppComponent]
})
export class AppModule { }
