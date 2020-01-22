import {Component, Input, OnInit} from '@angular/core';
import {Accomodation} from "../Model/Accomodation";
import {User} from '../Model/User';
import {UserHttpServiceService} from '../user/user-http-service.service';


import {AccomodationHttpService} from "../accomodation/accomodation-http.service";


@Component({
  selector: 'reservations',
  templateUrl: './reservations.component.html',
  styleUrls: ['./reservations.component.css']
})
export class ReservationsComponent implements OnInit {
  user: User;
  constructor(private accomodationService: AccomodationHttpService) {
    this.user = JSON.parse(localStorage.getItem("connectedUser"))
  }

  ngOnInit() {

  }
  list(){
    return this.accomodationService.findAll();
    this.user.bookings
  }
}
