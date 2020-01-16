import { Injectable } from '@angular/core';
import {Review} from "../Model/Review";
import {AppConfigService} from "../app-config.service";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ReviewHttpService {
  reviews: Array<Review>;

  constructor(private appConfig: AppConfigService, private http: HttpClient) {
    this.load();
  }

  load() {
    this.http.get<Array<Review>>(this.appConfig.backEnd + 'review').subscribe(resp => {
        this.reviews = resp;
      },
      err => console.log(err));
  }

  findAll(): Array<Review> {
    return this.reviews;
  }

  findById(id: number): Observable<Review> {
    return this.http.get<Review>(this.appConfig.backEnd + 'review/' + id);
  }

  save(review: Review) {
    if (!review.id) {
      this.http.post<Review>(this.appConfig.backEnd + 'review', review).subscribe(resp => {
        this.load();
      }, err => console.log(err));
    } else {
      this.http.put<Review>(this.appConfig.backEnd + 'review/' + review.id, review).subscribe(resp => {
        this.load();
      }, err => console.log(err));
    }
  }

  delete(id: number) {
    this.http.delete<Review>(this.appConfig.backEnd + 'review/' + id).subscribe(resp => {
      this.load();
    }, err => console.log(err));
  }


}
