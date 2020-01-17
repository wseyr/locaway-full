import { Injectable } from '@angular/core';
import {Contact} from "../Model/Contact";
import {AppConfigService} from "../app-config.service";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ContactHttpService {
  contacts: Array<Contact>;

  constructor(private appConfig: AppConfigService, private http: HttpClient) {
    this.load();
  }

  load() {
    this.http.get<Array<Contact>>(this.appConfig.backEnd + 'contact').subscribe(resp => {
        this.contacts = resp;
      },
      err => console.log(err));
  }

  findAll(): Array<Contact> {
    return this.contacts;
  }

  findById(id: number): Observable<Contact> {
    return this.http.get<Contact>(this.appConfig.backEnd + 'contact/' + id);
  }

  save(contact: Contact) {
    if (!contact.id) {
      this.http.post<Contact>(this.appConfig.backEnd + 'contact', contact).subscribe(resp => {
        this.load();
      }, err => console.log(err));
    } else {
      this.http.put<Contact>(this.appConfig.backEnd + 'contact/' + contact.id, contact).subscribe(resp => {
        this.load();
      }, err => console.log(err));
    }
  }

  delete(id: number) {
    this.http.delete<Contact>(this.appConfig.backEnd + 'contact/' + id).subscribe(resp => {
      this.load();
    }, err => console.log(err));
  }


}
