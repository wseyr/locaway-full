import { Component, OnInit } from '@angular/core';
import {User} from "../Model/User";
import {UserHttpServiceService} from "../user/user-http-service.service";

@Component({
  selector: 'dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  connectedU : User = JSON.parse(localStorage.getItem("connectedUser"));
  showreservation:boolean = false;
  showlocation:boolean = false;
  constructor(private userService: UserHttpServiceService) {
    console.log(this.connectedU);
  }
  reservation(){
    this.showreservation = true;
    this.showlocation = false;
  }
  location(){
    console.log(this.connectedU.accomodations)
    this.showlocation = true;
    this.showreservation = false;
  }
  save(){
    this.userService.save(this.connectedU);
  }
  ngOnInit() {

  }

}
