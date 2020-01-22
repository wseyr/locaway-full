import { Injectable } from '@angular/core';
import {User} from '../Model/User';
import {HttpClient} from '@angular/common/http';
import {AppConfigService} from "../app-config.service";
import {Observable} from 'rxjs';
import {Router} from "@angular/router"
import {Option} from "../Model/Option";

@Injectable({
  providedIn: 'root'
})
export class UserHttpServiceService {
  users: Array<User>;
  private _connectedUser: User=new User();
  public unvalidLogin : boolean=false;





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
    } else {
      this.http.put<User>(this.appConfig.backEnd + 'user/' + user.id, user).subscribe(resp => {
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
      this._connectedUser= resp;

      if (this._connectedUser!=null){
        localStorage.setItem('connectedUser', JSON.stringify(this._connectedUser));
        this.router.navigate(["home"]);
        } else {
          this.unvalidLogin = true;
          }
    });

  }

  logout(){
    localStorage.removeItem("connectedUser");
    location.reload();
  }

}

