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

  constructor(userService: UserHttpServiceService) {
    console.log(this.connectedU);
  }

  save(){
    this.userService.save(this.connectedU);
  }
  ngOnInit() {

  }

}
