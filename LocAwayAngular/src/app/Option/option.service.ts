import { Injectable } from '@angular/core';
import {Option} from "../Model/Option";
import {AppConfigService} from "../app-config.service";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class OptionHttpService {
  options: Array<Option>;

  constructor(private appConfig: AppConfigService, private http: HttpClient) {
    this.load();
  }

  load() {
    this.http.get<Array<Option>>(this.appConfig.backEnd + 'option').subscribe(resp => {
        this.options = resp;
      },
      err => console.log(err));
  }

  findAll(): Array<Option> {
    return this.options;
  }

  findById(id: number): Observable<Option> {
    return this.http.get<Option>(this.appConfig.backEnd + 'option/' + id);
  }

  save(option: Option) {
    if (!option.id) {
      this.http.post<Option>(this.appConfig.backEnd + 'option', option).subscribe(resp => {
        this.load();
      }, err => console.log(err));
    } else {
      this.http.put<Option>(this.appConfig.backEnd + 'option/' + option.id, option).subscribe(resp => {
        this.load();
      }, err => console.log(err));
    }
  }

  delete(id: number) {
    this.http.delete<Option>(this.appConfig.backEnd + 'option/' + id).subscribe(resp => {
      this.load();
    }, err => console.log(err));
  }


}
