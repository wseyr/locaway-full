import { Component, OnInit } from '@angular/core';
import {User} from "../Model/User";
import {UserHttpServiceService} from "../user/user-http-service.service";
import {Accomodation} from '../Model/Accomodation';
import {AccomodationHttpService} from '../accomodation/accomodation-http.service';
import {Booking} from '../Model/Booking';

@Component({
  selector: 'dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  connectedU : User = JSON.parse(localStorage.getItem("connectedUser"));
  userFromDatabase: User;
  selectedBookings: number = 1;

  accomodationsOfUser: Array<Accomodation> = new Array<Accomodation>();

  constructor(private userService: UserHttpServiceService, private accomodationService: AccomodationHttpService) {
    console.log(this.connectedU);
    this.listUserAcco();
  }

  listUserAcco(){
    this.userService.findById(this.connectedU.id).subscribe((resp)=>{
      this.userFromDatabase = resp;
      this.connectedU.accomodations.forEach((accomodation) =>{
          this.accomodationService.findById(accomodation.id).subscribe((fullAcco) =>{
            this.accomodationsOfUser.push(fullAcco);
          });
      });
    });
  }

  save(){
    this.userService.save(this.connectedU);
  }
  ngOnInit() {

  }

}
