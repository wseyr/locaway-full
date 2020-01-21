import { Component, OnInit } from '@angular/core';
import {User} from '../Model/User';
import {UserHttpServiceService} from '../user/user-http-service.service';

@Component({
  selector: 'connexion',
  templateUrl: './connexion.component.html',
  styleUrls: ['./connexion.component.css']
})
export class ConnexionComponent implements OnInit {
  currentUser: User = new User();
  confirmPassword: string;
  verif: boolean = true;
  coUser : User = new User();
  unvalidLogin : boolean=false;

  veriftos: boolean = true;
  termofservice: boolean = false;

  constructor(private userService: UserHttpServiceService) {
    this.unvalidLogin = userService.unvalidLogin;
  }

  ngOnInit() {}


  save(){

    this.verif =true;
    this.veriftos = true;
    if(this.confirmPassword==this.currentUser.password && this.termofservice) {
      this.userService.save(this.currentUser);
      this.cancel();
    }else if(this.confirmPassword!=this.currentUser.password) {
      this.verif = false;
    }else if (!this.termofservice){
      this.veriftos = false;
    }


  }
  cancel(){
    this.currentUser = new User();
  }

  connect() {
    this.userService.connect(this.coUser);

  }
}
