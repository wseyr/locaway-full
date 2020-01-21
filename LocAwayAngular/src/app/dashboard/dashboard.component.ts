import { Component, OnInit } from '@angular/core';
import {User} from "../Model/User";

@Component({
  selector: 'dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  connectedU : User = JSON.parse(localStorage.getItem("connectedUser"));

  constructor() {
    console.log(this.connectedU);
  }

  ngOnInit() {

  }

}
