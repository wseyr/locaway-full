import { Injectable } from '@angular/core';
import {Bookmark} from "../Model/Bookmark";
import {AppConfigService} from "../app-config.service";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class BookmarkHttpService {
  bookmarks: Array<Bookmark>;

  constructor(private appConfig: AppConfigService, private http: HttpClient) {
    this.load();
  }

  load() {
    this.http.get<Array<Bookmark>>(this.appConfig.backEnd + 'bookmark').subscribe(resp => {
        this.bookmarks = resp;
      },
      err => console.log(err));
  }

  findAll(): Array<Bookmark> {
    return this.bookmarks;
  }

  findById(id: number): Observable<Bookmark> {
    return this.http.get<Bookmark>(this.appConfig.backEnd + 'bookmark/' + id);
  }

  save(bookmark: Bookmark) {
    if (!bookmark.id) {
      this.http.post<Bookmark>(this.appConfig.backEnd + 'bookmark', bookmark).subscribe(resp => {
        this.load();
      }, err => console.log(err));
    } else {
      this.http.put<Bookmark>(this.appConfig.backEnd + 'bookmark/' + bookmark.id, bookmark).subscribe(resp => {
        this.load();
      }, err => console.log(err));
    }
  }

  delete(id: number) {
    this.http.delete<Bookmark>(this.appConfig.backEnd + 'bookmark/' + id).subscribe(resp => {
      this.load();
    }, err => console.log(err));
  }


}
