import {Component, Input, OnInit} from '@angular/core';
import {AccomodationHttpService} from '../accomodation/accomodation-http.service';
import {Accomodation} from '../Model/Accomodation';
import {ActivatedRoute} from "@angular/router";
import {NgbDate} from "@ng-bootstrap/ng-bootstrap";
import {Option} from "../Model/Option";
import {UserHttpServiceService} from '../user/user-http-service.service';

@Component({
  selector: 'app-accomodation-detail',
  templateUrl: './accomodation-detail.component.html',
  styleUrls: ['./accomodation-detail.component.css']
})
export class AccomodationDetailComponent implements OnInit {
  accomodation_id: number;
  accomodation: Accomodation = null;

  connectedU = JSON.parse(localStorage.getItem("connectedUser"));


  //calendrier
  asyncDataLoaded: boolean = false;
  bookedDates : Array<NgbDate> = new Array<NgbDate>();
  isDisabled = (date: NgbDate, current: {month: number}) => {
    let result: boolean = false;
    this.bookedDates.forEach( (bookedDate) => {
      if(date.equals(bookedDate)){
         result = true;
       }
    });
    return result;
  };


  constructor(private route: ActivatedRoute, private accomodationService: AccomodationHttpService) {
    this.route.params.subscribe(params => {
      this.accomodation_id = params['id'];
      this.accomodationService.findById(this.accomodation_id).subscribe(resp => {
        this.accomodation = resp;

        this.accomodation.optionsE = new Array <Option>();
        this.accomodation.options.forEach((option)=>{
          if(!option.isRule){
            this.accomodation.optionsE.push(option);
          }
        });
        this.accomodation.optionsR = new Array <Option>();
        this.accomodation.options.forEach((option)=>{
          if(option.isRule){
            this.accomodation.optionsR.push(option);
          }
        });

        this.accomodation.bookings.forEach( (booking) => {
          booking.bookedDays.forEach( (bookedDay) => {
            //le JSON retourne un string qu'il faut convertir en date
            let date = new Date(bookedDay.date);
            this.bookedDates.push(new NgbDate(date.getFullYear(), date.getMonth()+1, date.getDate()));
          });
        });
        this.asyncDataLoaded = true;
      });
    });

  }

  ngOnInit() {
  }

}
