import { BrowserModule } from '@angular/platform-browser';
import {LOCALE_ID, NgModule} from '@angular/core';
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
import { AccomodationFormComponent } from './accomodation-form/accomodation-form.component';
import { BookingFormComponent } from './booking-form/booking-form.component';
import {BookeddayHttpService} from "./bookedday/bookedday-http.service";
import { registerLocaleData } from '@angular/common';
import localeFr from '@angular/common/locales/fr';


registerLocaleData(localeFr, 'fr');



@NgModule({
  declarations: [
    AppComponent,
    AccomodationComponent,
    AccomodationDetailComponent,
    ConnexionComponent,
    HomeComponent,
    DashboardComponent,
    AccomodationFormComponent,
    BookingFormComponent,
],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    AngularFontAwesomeModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [{provide: LOCALE_ID, useValue: 'fr' }, AppConfigService, AccomodationHttpService, UserHttpServiceService, BookmarkHttpService, BookingHttpService, BookeddayHttpService, ContactHttpService],
  bootstrap: [AppComponent]
})
export class AppModule { }
