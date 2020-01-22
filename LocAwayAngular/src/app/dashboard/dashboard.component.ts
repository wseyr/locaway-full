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
  showreservation:boolean = false;
  showlocation:boolean = false;
  accomodations: Array<Accomodation> = new Array<Accomodation>();

  locations: Array<Accomodation> = new Array<Accomodation>();

  constructor(private userService: UserHttpServiceService, private accomodationService: AccomodationHttpService) {
    console.log(this.connectedU);
  }

  logements: Array<Accomodation> = new Array<Accomodation>();
  bookings: Array<Booking> = new Array<Booking>();

  listAll(){
    return this.accomodationService.findAll();
  }

  listUserAcco(){
    this.connectedU.accomodations.forEach((accomodation) =>{

        this.accomodationService.findById(accomodation.id).subscribe((fullAcco) =>{
          this.locations.push(fullAcco);
        });
      });

    // for(let i=0;i  < this.listAll().length; i++)
    //   if(this.listAll().includes(user.accomodations[i])){
    //     this.logements.push(user.accomodations[i])
    //   }
    // return this.logements;
  }
/*  listUserAccoBooking(){
    for(let logement of this.logements){
      this.bookings = logement.bookings;
    }
  }*/

/*  listedesbookings(user: User){
    for(let accomodation of this.listUserAcco(user)){
      result:Array<Booking> = accomodation.bookings;
    }
  }*/
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
