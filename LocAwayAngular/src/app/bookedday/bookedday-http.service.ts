import { Injectable } from '@angular/core';
import {BookedDay} from "../Model/Bookedday";
import {AppConfigService} from "../app-config.service";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class BookeddayHttpService {
  BookedDays: Array<BookedDay>;

  constructor(private appConfig: AppConfigService, private http: HttpClient) {
    this.load();
  }

  load() {
    this.http.get<Array<BookedDay>>(this.appConfig.backEnd + 'bookedDay').subscribe(resp => {
        this.BookedDays = resp;
      },
      err => console.log(err));
  }

  findAll(): Array<BookedDay> {
    return this.BookedDays;
  }

  findById(id: number): Observable<BookedDay> {
    return this.http.get<BookedDay>(this.appConfig.backEnd + 'bookedDay/' + id);
  }

  save(bookedDay: BookedDay){
    if (!bookedDay.id) {
      this.http.post<BookedDay>(this.appConfig.backEnd + 'bookedDay', bookedDay).subscribe(resp => {
        this.load();
      }, err => console.log(err));
    } else {
      this.http.put<BookedDay>(this.appConfig.backEnd + 'bookedDay/' + bookedDay.id, bookedDay).subscribe(resp => {
        this.load();
      }, err => console.log(err));
    }
  }

  saveNew(bookedDay: BookedDay): Observable<BookedDay>{
    return this.http.post<BookedDay>(this.appConfig.backEnd + 'bookedDay', bookedDay);
  }

  delete(id: number) {
    this.http.delete<BookedDay>(this.appConfig.backEnd + 'bookedDay/' + id).subscribe(resp => {
      this.load();
    }, err => console.log(err));
  }


}
