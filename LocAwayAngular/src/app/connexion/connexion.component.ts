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

  coUser : User = new User();
  verifCoUserEmail:boolean = true;
  verifCoUserPassword:boolean = true;
  unvalidLogin : boolean=this.userService.unvalidLogin;

  veriffirstname:boolean = true;
  veriflastname: boolean = true;
  verifphone:boolean = true;
  verifmail: boolean = true;
  verifpwd: boolean =true;
  verifpwd2: boolean = true;
  veriftos: boolean = true;
  termofservice: boolean = false;
  inscrit: boolean = false;
  constructor(private userService: UserHttpServiceService) {

  }

  ngOnInit() {}


  save(){
    this.veriffirstname = true;
    this.veriflastname = true;
    this.verifphone = true;
    this.verifmail = true;
    this.verifpwd = true;
    this.verifpwd2 = true;
    this.veriftos = true;

    if(this.confirmPassword==this.currentUser.password && this.termofservice && this.currentUser.password
      && this.currentUser.email && this.currentUser.firstName && this.currentUser.lastName && this.currentUser.phoneNumber) {
      this.userService.save(this.currentUser);
      this.cancel();
      this.confirmPassword = null;
      this.inscrit = true;
    }else if(!this.currentUser.lastName){
      this.veriflastname = false;
    }else if(!this.currentUser.firstName){
      this.veriffirstname = false;
    }else if (!this.currentUser.email){
      this.verifmail = false;
    }else if(!this.currentUser.phoneNumber){
      this.verifphone = false;
    }else if (!this.currentUser.password){
      this.verifpwd =false;
    } else if(this.confirmPassword!=this.currentUser.password) {
      this.verifpwd2 = false;
    }else if (!this.termofservice){
      this.veriftos = false;
    }


  }
  cancel(){
    this.currentUser = new User();
    this.termofservice = false;
  }

  connect() {
    console.log("Component Avant le service " + this.unvalidLogin);

    if(this.coUser.email && this.coUser.password) {
      this.userService.connect(this.coUser);
      console.log("Component APRES le service " + this.unvalidLogin);
    } else if  (!this.coUser.email){
      this.verifCoUserEmail=false;
    } else if  (!this.coUser.password){
      this.verifCoUserPassword=false;
    }

  }
}
