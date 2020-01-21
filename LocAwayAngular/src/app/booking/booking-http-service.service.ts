import { Injectable } from '@angular/core';
import {Booking} from "../Model/Booking";
import {AppConfigService} from "../app-config.service";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class BookingHttpService {
  bookings: Array<Booking>;

  constructor(private appConfig: AppConfigService, private http: HttpClient) {
    this.load();
  }

  load() {
    this.http.get<Array<Booking>>(this.appConfig.backEnd + 'booking').subscribe(resp => {
        this.bookings = resp;
      },
      err => console.log(err));
  }

  findAll(): Array<Booking> {
    return this.bookings;
  }

  findById(id: number): Observable<Booking> {
    return this.http.get<Booking>(this.appConfig.backEnd + 'booking/' + id);
  }

  save(booking: Booking) {
    if (!booking.id) {
      this.http.post<Booking>(this.appConfig.backEnd + 'booking', booking).subscribe(resp => {
        this.load();
      }, err => console.log(err));
    } else {
      this.http.put<Booking>(this.appConfig.backEnd + 'booking/' + booking.id, booking).subscribe(resp => {
        this.load();
      }, err => console.log(err));
    }
  }

  saveNew(booking: Booking): Observable<Booking> {
    return this.http.post<Booking>(this.appConfig.backEnd + 'booking', booking);
  }

  delete(id: number) {
    this.http.delete<Booking>(this.appConfig.backEnd + 'booking/' + id).subscribe(resp => {
      this.load();
    }, err => console.log(err));
  }


}
