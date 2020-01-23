import { Injectable } from '@angular/core';
import {Accomodation} from "../Model/Accomodation";
import {AppConfigService} from "../app-config.service";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AccomodationHttpService {
  accomodations: Array<Accomodation>;
  leanAccomodations: Array<Accomodation>;
  typesDeBiens: Array<string> = ["HOUSE","APPARTMENT","GUESTHOUSE","ALTERNATIVE","CHALET"];

  constructor(private appConfig: AppConfigService, private http: HttpClient) {
    this.load();
  }

  load() {
    this.http.get<Array<Accomodation>>(this.appConfig.backEnd + 'accomodation').subscribe(resp => {
        this.accomodations = resp;
      },
      err => console.log(err));
  }

  findAllObservable(): Observable<Array<Accomodation>>{
    return this.http.get<Array<Accomodation>>(this.appConfig.backEnd + 'accomodation');

  }

  findAll(): Array<Accomodation> {
    return this.accomodations;
  }

  findById(id: number): Observable<Accomodation> {
    return this.http.get<Accomodation>(this.appConfig.backEnd + 'accomodation/' + id);
  }

  save(accomodation: Accomodation) {
    if (!accomodation.id) {
      this.http.post<Accomodation>(this.appConfig.backEnd + 'accomodation', accomodation).subscribe(resp => {
        this.load();
      }, err => console.log(err));
    } else {
      this.http.put<Accomodation>(this.appConfig.backEnd + 'accomodation/' + accomodation.id, accomodation).subscribe(resp => {
        this.load();
      }, err => console.log(err));
    }
  }

  saveObservable(accomodation: Accomodation): Observable<Accomodation> {
      return this.http.post<Accomodation>(this.appConfig.backEnd + 'accomodation', accomodation);
  }

  delete(id: number) {
    this.http.delete<Accomodation>(this.appConfig.backEnd + 'accomodation/' + id).subscribe(resp => {
      this.load();
    }, err => console.log(err));
  }


  findByCity(city: string): Observable<Array<Accomodation>> {
    return this.http.get<Array<Accomodation>>(this.appConfig.backEnd + 'accomodation/search/' + city);
  }





}
