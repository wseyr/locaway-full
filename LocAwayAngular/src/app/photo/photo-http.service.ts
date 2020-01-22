import { Injectable } from '@angular/core';
import {Photo} from "../Model/Photo";
import {AppConfigService} from "../app-config.service";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class PhotoHttpService {
  photos: Array<Photo>;

  constructor(private appConfig: AppConfigService, private http: HttpClient) {
    this.load();
  }

  load() {
    this.http.get<Array<Photo>>(this.appConfig.backEnd + 'photo').subscribe(resp => {
        this.photos = resp;
      },
      err => console.log(err));
  }

  findAll(): Array<Photo> {
    return this.photos;
  }

  findById(id: number): Observable<Photo> {
    return this.http.get<Photo>(this.appConfig.backEnd + 'photo/' + id);
  }

  save(photo: Photo) {
    if (!photo.id) {
      this.http.post<Photo>(this.appConfig.backEnd + 'photo', photo).subscribe(resp => {
        this.load();
      }, err => console.log(err));
    } else {
      this.http.put<Photo>(this.appConfig.backEnd + 'photo/' + photo.id, photo).subscribe(resp => {
        this.load();
      }, err => console.log(err));
    }
  }

  delete(id: number) {
    this.http.delete<Photo>(this.appConfig.backEnd + 'photo/' + id).subscribe(resp => {
      this.load();
    }, err => console.log(err));
  }


}
