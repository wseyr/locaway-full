import { Injectable } from '@angular/core';
import {User} from '../Model/User';
import {HttpClient} from '@angular/common/http';
import {AppConfigService} from "../app-config.service";
import {Observable} from 'rxjs';
import {Router} from "@angular/router"

@Injectable({
  providedIn: 'root'
})
export class UserHttpServiceService {
  users: Array<User>;
  currentUser : User=new User();
  connectedUser: User=new User();

  constructor(private appConfig: AppConfigService, private http: HttpClient, private router: Router) {
    this.load();
  }

  load() {
    this.http.get<Array<User>>(this.appConfig.backEnd + 'user').subscribe(resp => {
      this.users = resp;
    },
      err => console.log(err));
  }

  findAll(): Array<User> {
    return this.users;
  }

  findById(id: number): Observable<User> {
    return this.http.get<User>(this.appConfig.backEnd + 'user/' +id);
  }

  save(user: User) {
    if(!user.id) {
      console.log(user);
      this.http.post<User>(this.appConfig.backEnd + 'user', user).subscribe(resp => {
        this.load();

      }, err => console.log(err));
    }
  }

  delete(id: number) {
    this.http.delete<User>(this.appConfig.backEnd + 'user' +id).subscribe(resp => {
      this.load();
    }, err => console.log(err));
  }

  connect(user : User){

    this.http.get<User>(this.appConfig.backEnd + 'user/login/' + user.email + "/password/" + user.password).subscribe(resp=>{
      this.connectedUser= resp;

      if (this.connectedUser!=null){
        localStorage.setItem('connectedUser', JSON.stringify(this.connectedUser));
        // localStorage.setItem(key, 'Value');
        this.router.navigate(["/home"]);

      } else {
        //TODO Gérer le fail
        //this.router.navigate(["/connexion"]);
      }
    })
          ;
  }

}

