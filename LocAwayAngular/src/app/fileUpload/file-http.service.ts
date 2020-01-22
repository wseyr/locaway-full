import { Injectable } from '@angular/core';
import {AppConfigService} from "../app-config.service";
import {HttpClient} from "@angular/common/http";
import {Contact} from "../Model/Contact";
import {Observable} from "rxjs";
import {UploadFileResponse} from "./UploadFileResponse";

@Injectable({
  providedIn: 'root'
})
export class FileHttpService {

  constructor(private appConfig: AppConfigService, private http: HttpClient) { }

  upload(file: File): Observable<UploadFileResponse>{
    const formData = new FormData();
    formData.append('file', file);
    return this.http.post<UploadFileResponse>(this.appConfig.backEnd + 'uploadFile', formData);
  }
}
